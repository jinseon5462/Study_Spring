package com.springboot.myapp2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.myapp2.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class MyAppSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//인증없이 접근을 허용하려는 경로
		http.authorizeRequests()
			.antMatchers("/", "/index", "/guest/**", "/regForm", "/regist", "/auth/**", "/list").permitAll();
		
		http.authorizeRequests()
			.anyRequest().authenticated();
		
		http.csrf().disable();
		//로그인폼 페이지 설정
		http.formLogin().loginPage("/auth/loginForm");
		//로그인 처리 URI 설정
		http.formLogin().loginProcessingUrl("/auth/securitylogin");
		//로그아웃 설정
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
