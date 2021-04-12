package com.wiktor.wos.server.repository;

import com.wiktor.wos.server.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
