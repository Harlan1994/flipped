package com.harlan.config;

import com.harlan.authentication.SimpleAuthenticationProvider;
import com.harlan.authentication.SimpleUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SimpleUserDetailsService simpleUserDetailsService;

    @Autowired
    private SimpleAuthenticationProvider simpleAuthenticationProvider;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers(
                        StaticParams.PathRegex.ROOT,
                        StaticParams.PathRegex.INDEX,
                        StaticParams.PathRegex.CSS,
                        StaticParams.PathRegex.JS,
                        StaticParams.PathRegex.IMG,
                        StaticParams.PathRegex.LOGIN,
                        StaticParams.PathRegex.WEBJARS,
                        StaticParams.PathRegex.LOGOUT,
                        StaticParams.PathRegex.POST,
                        StaticParams.PathRegex.PAGE,
                        StaticParams.PathRegex.ARCHIVE,
                        StaticParams.PathRegex.ABOUT
                ).permitAll()  //无需访问权限

                .antMatchers(StaticParams.PathRegex.AUTH_ADMIN)
                .hasAuthority(StaticParams.UserRole.ROLE_ADMIN) //admin角色访问权限

                .antMatchers(StaticParams.PathRegex.AUTH_USER)
                .hasAnyAuthority(StaticParams.UserRole.ROLE_USER, StaticParams.UserRole.ROLE_ADMIN)  //user角色访问权限

                .anyRequest()//all others request authentication
                .authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login-error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给自定义验证工具
        auth.authenticationProvider(simpleAuthenticationProvider);
    }
}
