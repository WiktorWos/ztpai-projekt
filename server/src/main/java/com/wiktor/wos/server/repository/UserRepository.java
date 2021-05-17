package com.wiktor.wos.server.repository;

import com.wiktor.wos.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String login);

    User findByToken(String token);
}
