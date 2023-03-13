package com.codewithamit.blogappapis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.codewithamit.blogappapis.security.CustomUserDetailService;
//import com.codewithamit.blogappapis.security.JwtAuthenticationEntryPoint;
//import com.codewithamit.blogappapis.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    /* @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
 */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        final String[] PUBLIC_URLS = {
            "/api/v1/auth/**",
            "/v3/api-docs",
            "/v2/api-docs",
            "/swagger-resources/**",
		    "/swagger-ui/**",
		    "/webjars/**"
        };

        /*http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/api/v1/auth/login").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(this.jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
        return http.build(); */

        http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers(PUBLIC_URLS).permitAll()
        .requestMatchers(HttpMethod.GET).permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
	          
	    return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(this.customUserDetailService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }
   
}
