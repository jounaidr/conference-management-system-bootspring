package com.lukas.ramonas.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.hibernate.cfg.AvailableSettings.USER;

public class SecurityConfig {
    @Configuration
    @EnableWebSecurity
    public class SecSecurityConfig extends WebSecurityConfigurerAdapter {


        @Override
        protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user1").password(passwordEncoder().encode("{noop}user1Pass")).roles("USER")
                    .and()
                    .withUser("user2").password(passwordEncoder().encode("{noop}user2Pass")).roles("USER")
                    .and()
                    .withUser("admin").password(passwordEncoder().encode("{noop}adminPass")).roles("ADMIN");
        }

        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/anonymous*").anonymous()
                    .antMatchers("/login*").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login.html")
                    .loginProcessingUrl("/perform_login")
                    .defaultSuccessUrl("/homepage.html", true)
                    //.failureUrl("/login.html?error=true")
                    //.failureHandler(authenticationFailureHandler())
                    .and()
                    .logout()
                    .logoutUrl("/perform_logout")
                    .deleteCookies("JSESSIONID");
                    //.logoutSuccessHandler(logoutSuccessHandler());

        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
}
