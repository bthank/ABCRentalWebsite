package com.abcrentals.binu.thankachan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.servlet.DispatcherServlet;

import com.abcrentals.binu.thankachan.service.UserService;

/*
 * Class to set up the Spring Security environment for processing and restrict access to resources
 * 
 * 
 * 
 */

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
    @Autowired
    private UserService userService;
	
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    
    
	/*
	 * @Autowired void configureDispatcherServlet( DispatcherServlet
	 * dispatcherServlet ) {
	 * dispatcherServlet.setThrowExceptionIfNoHandlerFound(true); }
	 */
    
    
    // method to configure authentication provider
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
   // method to configure access to resources
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("RENTER","CONTRACTOR","EMPLOYEE","MANAGER","ADMIN","OWNER")
			
			.antMatchers("/resources/**").hasAnyRole("RENTER","CONTRACTOR","EMPLOYEE","MANAGER","ADMIN","OWNER")						
			.antMatchers("/profile/**").hasAnyRole("RENTER","CONTRACTOR","EMPLOYEE","MANAGER","ADMIN","OWNER")			
			.antMatchers("/user/**").hasAnyRole("RENTER","CONTRACTOR","EMPLOYEE","MANAGER","ADMIN","OWNER")
			.antMatchers("/renter/**").hasAnyRole("RENTER","ADMIN")
			.antMatchers("/repair/**").hasAnyRole("RENTER","EMPLOYEE","MANAGER","ADMIN","OWNER")
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/contractor/**").hasAnyRole("CONTRACTOR","ADMIN")
			.antMatchers("/employee/**").hasAnyRole("EMPLOYEE","ADMIN")
			
			.antMatchers("/manager/rental-payments/**").hasAnyRole("MANAGER","ADMIN","EMPLOYEE")
			.antMatchers("/maintenance/manage-rental-repairs/**").hasAnyRole("MANAGER","ADMIN","EMPLOYEE")
			.antMatchers("/maintenance/manage-rental-properties/**").hasAnyRole("MANAGER","ADMIN")

			.antMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
			.antMatchers("/maintenance/**").hasRole("ADMIN")

			.antMatchers("/owner/**").hasAnyRole("OWNER","ADMIN")
			.antMatchers("/rental-property/**").hasAnyRole("ADMIN","EMPLOYEE","MANAGER","OWNER")
			.antMatchers("/rental-repair/**").hasAnyRole("RENTER","ADMIN","EMPLOYEE","MANAGER","OWNER")
			.antMatchers("/rental-unit-amenity/**").hasAnyRole("ADMIN","EMPLOYEE","MANAGER","OWNER")

			
			.antMatchers("/privacy-notice/**").hasAnyRole("RENTER","CONTRACTOR","EMPLOYEE","MANAGER","ADMIN","OWNER")
			.antMatchers("/terms-of-use/**").hasAnyRole("RENTER","CONTRACTOR","EMPLOYEE","MANAGER","ADMIN","OWNER")

			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.successHandler(customAuthenticationSuccessHandler)
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
//			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
	
	//beans
	
	//bcrypt bean definition
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}
	  
	// access denied handler bean definition
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
	
	
	
}






