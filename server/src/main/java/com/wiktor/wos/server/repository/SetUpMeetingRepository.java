package com.wiktor.wos.server.repository;

import com.wiktor.wos.server.entity.SetUpMeeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetUpMeetingRepository extends JpaRepository<SetUpMeeting, Long> {
    List<SetUpMeeting> findByMeeting_User_IdOrderByCreatedAtAsc(Long id);
}
