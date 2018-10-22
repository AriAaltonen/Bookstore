package com.bookstore.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            //.antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login").permitAll()
            .and()
        .logout()
        .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        Collection<UserDetails> users = new ArrayList<UserDetails>();
        users.add(generateUser("user", "password", "USER"));
        users.add(generateUser("admin", "admin123", "ADMIN"));

        return new InMemoryUserDetailsManager(users);
    }

    private UserDetails generateUser(String username, String password, String role){
        return User.withDefaultPasswordEncoder()
            .username(username)
            .password(password)
            .roles(role)
            .build();
    }
}