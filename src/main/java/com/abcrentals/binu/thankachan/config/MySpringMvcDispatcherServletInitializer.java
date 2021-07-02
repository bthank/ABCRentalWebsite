package com.abcrentals.binu.thankachan.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * Class to initialize the dispatcher servlet settings
 * 
 * 
 * 
 */

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// method for obtaining root config classes
	@Override
	protected Class<?>[] getRootConfigClasses() {		 
		return null;
	}

	// method for obtaining servlet config class(es)
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DemoAppConfig.class };
	}
	
	// method for obtaining servlet mappings
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}






