package com.wiktor.wos.server.service;

import com.wiktor.wos.server.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements MyUserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) {
        return this.userRepository.findByEmail(login);
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByToken(String token) {
        return this.userRepository.findByToken(token);
    }
}
