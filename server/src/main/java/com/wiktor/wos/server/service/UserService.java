package com.wiktor.wos.server.service;


import com.wiktor.wos.server.entity.User;
import com.wiktor.wos.server.repository.UserRepository;
import com.wiktor.wos.server.service.dto.RegisterDTO;
import com.wiktor.wos.server.service.dto.UserDTO;
import com.wiktor.wos.server.service.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO getUser(String email) {

        return this.userMapper.toDto(this.userRepository.findByEmail(email));
    }

    public void addNewUser(RegisterDTO dto) {

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        userRepository.save(user);
    }

    public void setToken(String email, String token) {
        User user = this.userRepository.findByEmail(email);

        user.setToken(token);

        this.userRepository.save(user);
    }

}
