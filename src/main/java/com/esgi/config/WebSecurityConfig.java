package com.esgi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by alex on 29/05/2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService appUserDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic();

        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico", "/static/**").permitAll()
                .antMatchers("/","/views/connexion.html")
                .permitAll()
                .anyRequest().authenticated();
        /*http
                .formLogin()
                .loginPage("/connexion")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        http
                .authorizeRequests()
                .antMatchers("/api/ping")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**")
                .authenticated()
                .and()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()

                .httpBasic()
                .and()
                .csrf()
                .disable();*/


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService);
    }
}
