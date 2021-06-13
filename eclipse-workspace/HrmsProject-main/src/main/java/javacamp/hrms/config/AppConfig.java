package javacamp.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppConfig { 
	
	
	@Bean
	public ModelMapper modelMapper() {
			
		return new ModelMapper();
	}
	
	@Bean 
	public Cloudinary cloudinary() {
		
	return	new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "isbank",
				"api_key", "667484579957847",
				"api_secret", "VnbAoGkengQiN4hRxv79FTbxrjo"
				));
	}

}