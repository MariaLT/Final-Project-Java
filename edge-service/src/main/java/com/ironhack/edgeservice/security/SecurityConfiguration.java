package com.ironhack.edgeservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login").authenticated()
/*                .antMatchers(HttpMethod.GET, "/login", "/library/books", "/library/books/{ean}",
                        "/library/loanedBooks/user/{userId}").authenticated()
                .antMatchers(HttpMethod.GET, "/library/loanedBooks", "/library/loanedBooks/{ean}",
                        "/library/loanedBooks/available", "/library/loanedBooks/lost",
                        "/library/loanedBooks/loaned", "/library/loanedBooks/overdue",
                        "/library/loanedBooks/update", "/users/profile").hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.POST, "/library/books", "/library/loanedBooks/{ean}").hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.DELETE, "/library/books/{ean}").hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.PATCH,"/library/loanedBooks/pickUp","/library/loanedBooks/{id}").hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.POST, "/library/loanedBooks").hasRole("STUDENT")
                .antMatchers(HttpMethod.GET, "/library/loanedBooks/return/{ean}").hasRole("STUDENT")*/
                .anyRequest().permitAll();
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
