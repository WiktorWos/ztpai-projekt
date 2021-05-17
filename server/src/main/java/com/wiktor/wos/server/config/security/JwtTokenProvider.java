package com.wiktor.wos.server.config.security;

import com.wiktor.wos.server.entity.User;
import com.wiktor.wos.server.repository.UserRepository;
import com.wiktor.wos.server.service.MyUserDetailsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtTokenProvider {

    private final MyUserDetailsService userDetailsService;

    private final UserRepository userRepository;

    public JwtTokenProvider(MyUserDetailsService userDetailsService, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    public String createToken() {
        return RandomStringUtils.randomAlphabetic(128);
    }

    public Authentication getAuthenticationByLogin(String login) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(login);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public Authentication getAuthenticationByToken(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByToken(token);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public boolean validateToken(String token) {
        User user = this.userRepository.findByToken(token);

        if (user == null) {
            return false;
        }

        return user.getToken().equals(token);
    }
}