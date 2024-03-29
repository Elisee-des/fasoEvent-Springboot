package com.admin_user.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.admin_user.service.CustomSuccessHandler;
import com.admin_user.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;

    @Bean
    static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
    	http.csrf(c -> c.disable())
		
		.authorizeHttpRequests(request -> request
				.requestMatchers("/", "/accueil", "/assets_public/**").permitAll()
				.requestMatchers("/login", "/assets_private/**").permitAll()
				.requestMatchers("/options-incriptions", "/assets_private/**").permitAll()
				.requestMatchers("/admin-page").hasAuthority("ADMIN")
				.requestMatchers("/promoteur-page").hasAuthority("PROMOTEUR")
				.requestMatchers("/abonne-page").hasAuthority("ABONNE")
				.requestMatchers("/registration","/assets_private/**").permitAll()
				.requestMatchers("/registration-promoteur","/assets_private/**").permitAll()
				.anyRequest().authenticated())
				
				/*.requestMatchers("/admin-page")
				.hasAuthority("ADMIN").requestMatchers("/user-page")
				.hasAuthority("ABONNE").requestMatchers("/registration","/css/**").permitAll()
				.anyRequest().authenticated())*/
		
		.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
				.successHandler(customSuccessHandler).permitAll())
		
		.logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").permitAll());
		
		return http.build();
	
    }
	
	
	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
}
