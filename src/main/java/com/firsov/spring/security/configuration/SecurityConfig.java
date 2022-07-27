package com.firsov.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
     DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);



        //присвоение паролей и ролей без БД
        /*
        User.UserBuilder UserBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(UserBuilder.username("admin").password("admin").roles("ADMIN", "BOSS", "USER"))
                .withUser(UserBuilder.username("Yuri").password("qwerty").roles("USER"))
                .withUser(UserBuilder.username("boss").password("boss").roles("BOSS"));

         */
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
