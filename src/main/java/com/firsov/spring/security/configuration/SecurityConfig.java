package com.firsov.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {



        User.UserBuilder UserBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(UserBuilder.username("admin").password("admin").roles("ADMIN", "BOSS", "USER"))
                .withUser(UserBuilder.username("Yuri").password("qwerty").roles("USER"))
                .withUser(UserBuilder.username("boss").password("boss").roles("BOSS"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("USER", "BOSS", "ADMIN")
                .antMatchers("/boss_page").hasAnyRole("BOSS", "ADMIN")
                .antMatchers("/admin_page").hasAnyRole( "ADMIN")
                .and().formLogin().permitAll();
    }
}
