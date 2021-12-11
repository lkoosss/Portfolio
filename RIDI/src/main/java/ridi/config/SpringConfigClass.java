package ridi.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	
		@Override
		protected Class<?>[] getRootConfigClasses() {
			return new Class[] {RootAppContext.class};
		}
		
		
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return new Class[] {ServletAppContext.class};
		}
		
		
		@Override
		protected String[] getServletMappings() {
			return new String[] {"/"};
		}
		
		@Override
		protected Filter[] getServletFilters() {
			CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
			encodingFilter.setEncoding("UTF-8");
			return new Filter[] {encodingFilter};
		}
		
		
		@Override
		protected void customizeRegistration(Dynamic registration) {
			
			MultipartConfigElement config = new MultipartConfigElement(null,1024*1024*100, 1024*1024*100, 0);
			registration.setMultipartConfig(config);
		}
}
