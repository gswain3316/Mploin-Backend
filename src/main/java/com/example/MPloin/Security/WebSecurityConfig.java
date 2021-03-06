
package com.example.MPloin.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * public WebSecurityConfig() { super(); // TODO Auto-generated constructor stub
	 * }
	 * 
	 * public WebSecurityConfig(boolean disableDefaults) { super(disableDefaults);
	 * // TODO Auto-generated constructor stub }
	 */
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/register").permitAll().anyRequest().
	 * authenticated().and().formLogin()
	 * .loginPage("/login").permitAll().and().logout().logoutUrl("/logout").
	 * permitAll(); }
	 */
	/*
	 * @Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();
	 * }
	 */
	
	

	@Bean
	UserDetailsService userDetailService() {
		return new InMemoryUserDetailsManager(
				User.withDefaultPasswordEncoder().username("mploin").
				password("mploin123").roles("USER").build());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/register").permitAll()
			.anyRequest().authenticated();
		
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
	}

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

}
