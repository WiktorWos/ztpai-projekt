package com.wiktor.wos.server.repository;

import com.wiktor.wos.server.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
