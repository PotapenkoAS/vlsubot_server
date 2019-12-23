package com.example.vlsubot_1_0.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.example.vlsubot_1_0.Constants.ROLE_STUDENT;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/content/**").permitAll()
                .antMatchers("/rest/**").permitAll()
                .antMatchers("/rest/message").hasRole(ROLE_STUDENT)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureForwardUrl("/login?error=true")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home");
    }
}