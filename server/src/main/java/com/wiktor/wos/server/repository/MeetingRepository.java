package com.wiktor.wos.server.repository;

import com.wiktor.wos.server.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByUser_IdOrderByHourStartDesc(Long id);
}
