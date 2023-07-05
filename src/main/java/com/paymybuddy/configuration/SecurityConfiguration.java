package com.paymybuddy.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//@formatter:off
        http
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers("/user").permitAll()
                                .requestMatchers("/paymybuddy").permitAll()
                                .requestMatchers("/users/new").permitAll()
                                .requestMatchers("/users").permitAll()
                                .requestMatchers("/logout").permitAll()
                                .requestMatchers("/account").authenticated()
                                .requestMatchers("/bankingOperation").authenticated()
                )
                .formLogin(withDefaults());
                
		return http.build();
		//@formatter:on

	}

}
