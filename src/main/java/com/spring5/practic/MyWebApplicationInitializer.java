package com.spring5.practic;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		   // Load Spring web application configuration
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();
        
        
        servletContext.addListener(new ContextLoaderListener(rootContext));
       
       
        

        // Create and register the DispatcherServlet
        AnnotationConfigWebApplicationContext dispatcherServletConfig = new AnnotationConfigWebApplicationContext();
        dispatcherServletConfig.register(ServlateConfig.class);
        ServletRegistration.Dynamic registration = servletContext.addServlet("servlet", new DispatcherServlet(dispatcherServletConfig));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
		
	}
	
	

}

//public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class[] {
//				RootConfig.class
//		};
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class[] {
//				ServlateConfig.class
//		};
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		// TODO Auto-generated method stub
//		return new String[] {
//				"/"
//		};
//	}
//	
//	
//	
//	
//}
