package ru.job4j.h2mvc.police.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Vitaly Vasilyev, date: 24.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * @param auth билдер.
     * @throws Exception искл.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(encoder.encode("secret")).roles("ADMIN").and()
                .withUser("user").password(encoder.encode("password")).roles("USER");
    }

    /**
     * @param http http.
     * @throws Exception искл.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/accidents").authenticated()
                .antMatchers(HttpMethod.GET, "/accidents/add").hasRole("ADMIN")
                .anyRequest().permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/accidents")

                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}