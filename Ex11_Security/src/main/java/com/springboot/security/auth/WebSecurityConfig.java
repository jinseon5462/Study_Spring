package com.springboot.security.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// url 요청에 대한 허용여부 설정 : 큰 -> 작은 - 계속 덮어쓴다.
		http.authorizeRequests()
				.antMatchers("/").permitAll()	// 모두에게 허용
				.antMatchers("/css/**", "/js/**", "/img/**").permitAll()	
				.antMatchers("/guest/**").permitAll()	// guest 아래 모든 url 요청에 대해 모두에게 허용
				.antMatchers("/member/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated();
		http.formLogin()
				.loginPage("/loginForm")
				.loginProcessingUrl("/j_spring_security_check")
				.failureUrl("/loginError")
				.usernameParameter("j_username")
				.passwordParameter("j_password")
				.permitAll();	// 로그인 폼 url은 모두에게 허용
		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.permitAll();	// 로그아웃 url 요청은 모두에게 허용
		
		http.csrf().disable();	// 위조변조 방지 꺼놓기
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 인증 사용자 등록(user, admin)
		auth.inMemoryAuthentication()
			// 사용자 이름 : user, 패스워드 : 1234, 역할이름(ROLE) : USER
			.withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
			.and()
			.withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN")
			.and()
			.withUser("eseo").password(passwordEncoder().encode("1111")).roles("ADMIN");
	}

	// 스프링 시큐리티 암호화 클래스 종류 : BCryptPasswordEncoder, StandartPasswordEncoder
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
}
