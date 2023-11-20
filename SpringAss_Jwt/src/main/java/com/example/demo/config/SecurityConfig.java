package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService detailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("hari")
				.password(encoder.encode("pwd"))
				.roles("ADMIN")
				.build();
		UserDetails user = User.withUsername("sri")
				.password(encoder.encode("dwp"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin,user);
	}
	/**
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/welcome","/auth").permitAll()
				.and()
				.authorizeHttpRequests().requestMatchers("/jwt/**").authenticated()
				.and().formLogin().and().build();
				
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws  Exception{
		return configuration.getAuthenticationManager();
		
	}
}
