package com.example.TrackerProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**", "/css/**", "/home").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/addmood", true).permitAll();
		return http.build();

	}

	@Bean
	public UserDetailsService userDetailsService() {
	UserDetails user = User.withDefaultPasswordEncoder()
	.username("user")
	.password("user")
	.roles("USER")
	.username("admin")
	.password("admin")
	.roles("ADMIN")
	.build();
	List<UserDetails> users = new ArrayList();
	users.add(user);
	return new InMemoryUserDetailsManager(users);
	}

}
