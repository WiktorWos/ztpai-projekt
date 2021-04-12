package com.wiktor.wos.server.repository;

import com.wiktor.wos.server.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
