package com.codewithamit.blogappapis.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. get token

        String requestToken = request.getHeader("Authorization");

        // Bearer 2352523sdgsg

        System.out.println(requestToken);

        String username = null;

        String token = null;

        if (requestToken != null && requestToken.startsWith(token)) {

            token = requestToken.substring(7);
            try {
                username = this.jwtTokenHelper.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable the get the token ! ");
            } catch (ExpiredJwtException e) {
                System.out.println("Jwt token has expired ! ");
            } catch (MalformedJwtException e) {
                System.out.println("Invalid token ! ");
            }
        } else {
            System.out.println("Jwt token does not with bearer ! ");
        }

        // Once we get token, now validate
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (this.jwtTokenHelper.validateToken(token, userDetails)) {
                // shi chal raha hai
                // authentication

                UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                userNamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
            } else {
                System.out.println("Invalid jwt token");
            }
            System.out.println("username is null or context is not null ! ");
        }

        filterChain.doFilter(request, response);

    }

}
