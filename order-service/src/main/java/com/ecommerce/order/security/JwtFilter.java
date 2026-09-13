package com.ecommerce.order.security;

import com.ecommerce.order.client.AuthClient;
import com.ecommerce.order.security.user.TokenValidationResponse;
import com.ecommerce.order.security.user.UserResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private AuthClient authClient;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (null != header && header.startsWith("Bearer ")) {
            String accessToken = header.substring(7);

            try {
                TokenValidationResponse validationResponse = authClient.validateToken(accessToken);
                if (null != validationResponse && validationResponse.isValid()) {
                    UserResponse userResponse = validationResponse.getUserInfo();
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userResponse.getRole().name());
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userResponse, (Object) null, List.of(authority));
                    authentication.setDetails(accessToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    filterChain.doFilter(request, response);
                } else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
            } catch (Exception ex) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(ex.getMessage());
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
