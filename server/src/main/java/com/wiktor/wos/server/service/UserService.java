package com.wiktor.wos.server.service;


import com.wiktor.wos.server.entity.User;
import com.wiktor.wos.server.entity.UserDetails;
import com.wiktor.wos.server.repository.UserRepository;
import com.wiktor.wos.server.service.dto.RegisterDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(RegisterDTO dto) {

        User user = new User();
        UserDetails userDetails = new UserDetails();
        userDetails.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userDetails.setFirstName(dto.getFirstName());
        userDetails.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userRepository.save(user);
    }

    public void setToken(String email, String token) {
        User user = this.userRepository.findByEmail(email);

        user.setToken(token);

        this.userRepository.save(user);
    }

}
