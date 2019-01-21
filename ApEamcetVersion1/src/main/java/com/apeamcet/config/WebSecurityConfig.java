package com.apeamcet.config;

import javax.inject.Inject;			

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Inject
	SpringTemplateEngine templateEngine;
	@Autowired
	private UserDetailsService userDetailsService;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 *  Authorization :The access permissions is done according to the type of users is defined here.
	 */
    @Override  
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/css/**","/fonts/**","/js/**",  "/home","/engineering", "/medical", "/agricultural","/getAgriculturalData","/getEngData","/getMedData","/map.png","/getDistrictData/**","/getDistUserData","/getAgrUserData","/getEngUserData","/getMedUserData").permitAll().antMatchers("/adminhome","/add","/uploaddata","/downloadData").hasAnyAuthority("ROLE_ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    }
    /*
     * (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     * Authentication: The Spring security is invoked from the below method.
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
}
