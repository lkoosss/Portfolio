package ridi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc	
@ComponentScan("ridi.controller") 
@Configuration
public class ServletAppContext implements WebMvcConfigurer{
	
		
		public void configureViewResolvers(ViewResolverRegistry registry) {
			WebMvcConfigurer.super.configureViewResolvers(registry);
			registry.jsp("/WEB-INF/views/",".jsp");
		}
		
		
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			WebMvcConfigurer.super.addResourceHandlers(registry);
			registry.addResourceHandler("/**").addResourceLocations("/resources/");
			//registry.addResourceHandler("/bookImage/**").addResourceLocations("file:///C:/bookImage/");
			registry.addResourceHandler("/bookImage/**").addResourceLocations("file:///root/Downloads/bookImage/");
		
		}
		@Bean
		public StandardServletMultipartResolver  multipartResolver() {
			return new StandardServletMultipartResolver();
		}
}