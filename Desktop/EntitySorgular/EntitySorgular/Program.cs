using System;
using EntitySorgular.Data;
using EntitySorgular.Models;
using System.Collections.Generic;
using System.Linq;
using Microsoft.EntityFrameworkCore;

namespace EntitySorgular
{
    class Program
    {

        public static void WriteToConsole(IEnumerable<object> items)
        {
            string header="";
            foreach(var pName in items.FirstOrDefault().GetType().GetProperties())
            {
                header += $"{pName.Name}".PadRight(35);
            }
           
            Console.WriteLine(header);
             Console.WriteLine(new String('-', header.Length));
            foreach(var item in items)
            {
                string body="";
                foreach (var prop in item.GetType().GetProperties())
                {
                    body += $"{prop.GetValue(item)}".PadRight(35);
                }
                Console.WriteLine(body);
            }

        }
        public static void Ornek1()
            {
                /*select ProductID, ProductName, UnitPrice, UnitsInStock, 
                (select CategoryName from Categories where Categories.CategoryID=Products.CategoryID) 
                from Products where UnitPrice>=20 and UnitPrice<=50 
                order by UnitPrice desc
                
                veya
                
                select ProductID as ID, ProductName UrunAdi, UnitPrice=Fiyat, UnitsInStock 'Stok Adedi', C.CategoryName [Kategori Adı]
                from Products P join Categories C on C.CategoryID=P.CategoryID 
                where UnitPrice>=20 and UnitPrice<=50  
                order by UnitPrice desc*/

                NorthwindContext context=new NorthwindContext();
                var result=context.Products.Where(x => x.UnitPrice>=20 && x.UnitPrice<=50).OrderByDescending(x=>x.UnitPrice).Select(x=>new {
                    ID=x.ProductId,
                    UrunAdi=x.ProductName,
                    StokAdedi=x.UnitsInStock,
                    Fiyat=x.UnitPrice,
                    KategoriAdi=x.Category.CategoryName
                });
                WriteToConsole(result);
            }

            /*
            select C.CompanyName, CONCAT(E.FirstName, ' ', E.LastName) as Personel,O.OrderID, O.OrderDate, [Kargo Firması]=s.CompanyName 
            from Orders O 
            join Customers C on O.CustomerID=C.CustomerID 
            join Employees E on O.EmployeeID=E.EmployeeID 
            join Shippers S on O.ShipVia=S.ShipperID
            */

            public static void Ornek2()
            {
                using NorthwindContext context=new NorthwindContext();
                var result=context.Orders.Select(x=>new{
                    MusteriSirketAdi=x.Customer.CompanyName,
                    Personel=$"{x.Employee.FirstName} {x.Employee.LastName}",
                    SiparişId=x.OrderId,
                    SiparisTarihi=x.OrderDate,
                    KargoSirketi=x.ShipViaNavigation.CompanyName
                });
                WriteToConsole(result);

            }

            /*select FirstName as 'Ad', LastName as 'Soyad', BirthDate as 'D.Tarihi', 
            DATEDIFF(YEAR, BirthDate, GETDATE()) as 'Yas' from Employees order by Yas*/
            public static void Ornek3()
            {
                using NorthwindContext context=new NorthwindContext();
                var result=context.Employees.Select(x=> new{
                    Ad = x.FirstName,
                    Soyad=x.LastName,
                    DogumTarihi=x.BirthDate.Value.ToShortDateString(),
                    Yas = DateTime.Now.Year-x.BirthDate.Value.Year

                     
                 } ) ;          
                WriteToConsole(result);
                
            }

            /*
            declare @name nvarchar(16) = 'Beverages', @Id int
            if exists(select * from Categories where CategoryName = @name)
                begin
                    select @Id = CategoryID from Categories where CategoryName = @name
                    insert into Products (ProductName, UnitPrice, UnitsInStock, CategoryID) values ('Kola', 5.00, 500, @Id)
                    select ProductID, ProductName, UnitPrice, UnitsInStock, (select  CategoryName from Categories where Categories.CategoryID=Products.CategoryID) from Products where ProductName like 'Kola%'
                end
            else
                begin
                    print 'kategori yok'
                end
            */
            public static void Ornek4()
            {
                using NorthwindContext context=new NorthwindContext();
                Categories category=context.Categories.FirstOrDefault(x => x.CategoryName=="Beverages");
                if(category==null)
                {
                    Console.ForegroundColor=ConsoleColor.Red;
                    Console.WriteLine("Parametrede verdiğiniz kategori bulunamadı!");
                    Console.ResetColor();
                    return;
                }

                Products product=new Products();
                product.ProductName="Kola 1";
                product.UnitPrice=5.00M;
                product.UnitsInStock=500;
                product.CategoryId=category.CategoryId;

                //product.CategoryId=context.Categories.FirstOrDefault(x=>x.CategoryName=="Beverages").CategoryId;
                context.Products.Add(product);
                bool result=context.SaveChanges()>0;
                Console.WriteLine($"Kategori Ekleme İşlemi {(result ? "Başarılı" : "Başarısız" )}");
                
                context.Categories.FirstOrDefault(x=>x.CategoryName=="Beverages").Products.Add(new Products
                {
                    ProductName="Kola 2",
                    UnitPrice=5.00M,
                    UnitsInStock=500
                });
                result=context.SaveChanges()>0;
                Console.WriteLine($"Kategori Ekleme İşlemi {(result ? "Başarılı" : "Başarısız" )}");
               
                var products=context.Products.AsNoTracking()
                .Where(x=>x.ProductName.StartsWith("Kola"))
                .Select(x=>new
                {
                    ID=x.ProductId,
                    UrunAdi=x.ProductName,
                    Fiyat=x.UnitPrice,
                    StokAdet=x.UnitsInStock,
                    Kategori=x.Category.CategoryName
                });
                WriteToConsole(products);
                
            }

            public static void Ornek5()
            {
            /*
            -- Müşteriler tablosunda şirket adına Restaurant geçen şirketleri listeleyiniz. 
            select * from Customers where CompanyName like '%restaurant%'
            */
            using NorthwindContext context=new NorthwindContext();
            var result=context.Customers.Where(x=>x.CompanyName.Contains("Restaurant")).Select(x=>new{
            x.CompanyName,
            x.ContactTitle
            });
            WriteToConsole(result);
            }

            public static void Ornek6()
            {

            /*
            select C.CategoryName, sum(P.UnitsInStock) as Adet from Products P join Categories C on P.CategoryID = C.CategoryID
            group by  C.CategoryName
            order by Adet
            */

            using NorthwindContext context=new NorthwindContext();
            var result=context.Products.
            GroupBy( x=> new{x.Category.CategoryName}).
            Select( x=> new{
                        Kategori=x.Key,
                        Adet = x.Sum(p=>p.UnitsInStock)                    
                    }).
            OrderByDescending(x=>x.Adet);
            WriteToConsole(result);
            }

            
           




                static void Main(string[] args)
        {
            Console.Clear();
            //Ornek1();
            //Ornek2();
            //Ornek3();
            //Ornek4();
            //Ornek5();
            Ornek6();

        }
    }

   
}
