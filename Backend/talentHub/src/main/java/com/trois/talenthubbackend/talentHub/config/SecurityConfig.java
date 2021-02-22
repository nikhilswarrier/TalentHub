package com.trois.talenthubbackend.talentHub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${spring.security.user.name}")
	private String username;
	@Value("${spring.security.user.password}")
	private String password;
	@Value("${spring.security.user.roles}")
	private String role;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();

	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withDefaultPasswordEncoder().username(username).password(password).roles(role).build());
	}
}