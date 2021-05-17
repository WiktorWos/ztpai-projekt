package com.wiktor.wos.server.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface MyUserDetailsService extends UserDetailsService {

    UserDetails loadUserByToken(String token);
}
