package com.pomotask.pomotask.config.security;

import com.pomotask.pomotask.config.security.oauth2.AuthUserService;
import com.pomotask.pomotask.config.security.handler.SuccessHandlerCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig {


    private static final String[] PUBLIC_MATCHERS = {
            "/h2-console/**",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/bus/v3/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/webjars/**",
            "/oauth/**"
    };
    private static final String[] PUBLIC_MATCHERS_GET = {};
    private static final String[] PUBLIC_MATCHERS_POST = {};
    @Autowired
    private Environment env;
    @Autowired
    private AuthUserService authService;



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        if (Arrays.asList(env.getActiveProfiles()).contains("test"))
            http.headers().frameOptions().disable();
        http.cors().and().csrf().disable();

        http
//                .cors()
//                    .and()
//                .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    .and()
//                .csrf()
//                    .disable()
//                .formLogin()
//                    .disable()
//                .httpBasic()
//                    .disable()
                .authorizeRequests()
                    .antMatchers(PUBLIC_MATCHERS).permitAll()
                    .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
                    .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
                    .anyRequest().authenticated()
                    .and()
                .oauth2Login(
                )
//                    .authorizationEndpoint()
//                    .baseUri("/oauth2/authorize")
//                    .and()
//                .redirectionEndpoint()
//                    .baseUri("/oauth2/callback/*")
//                    .and()
                .userInfoEndpoint()
                    .userService(authService)
                    .and()
                .successHandler(new SuccessHandlerCustom());
        return http.build();
    }

}
