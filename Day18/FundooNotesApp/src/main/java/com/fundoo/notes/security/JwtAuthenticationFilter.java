package com.fundoo.notes.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService,
                                    UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtUtil.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Reject tokens issued before the user's last password change.
            // Stateless JWTs can't be "revoked" outright, but comparing the
            // token's issuedAt against passwordChangedAt gives us the same
            // effect: any token from before a reset stops working immediately.
            User user = userRepository.findByEmail(username);
            boolean issuedBeforePasswordChange = false;
            if (user != null && user.getPasswordChangedAt() != null) {
                Date issuedAt = jwtUtil.extractIssuedAt(token);
                Date passwordChangedAt = java.sql.Timestamp.valueOf(user.getPasswordChangedAt());
                // 1s grace window avoids false negatives from timestamp truncation
                issuedBeforePasswordChange = issuedAt.getTime() < passwordChangedAt.getTime() - 1000;
            }

            if (!issuedBeforePasswordChange && jwtUtil.validateToken(token, userDetails.getUsername())) {
                //  Extract role from JWT
                String role = jwtUtil.extractRole(token);

                // Build authorities from role claim
                List<GrantedAuthority> authorities =
                        List.of(new SimpleGrantedAuthority("ROLE_"+role));

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}

