package com.wiktor.wos.server.service;

import com.wiktor.wos.server.entity.Meeting;
import com.wiktor.wos.server.entity.SetUpMeeting;
import com.wiktor.wos.server.repository.SetUpMeetingRepository;
import com.wiktor.wos.server.service.dto.GuestDTO;
import com.wiktor.wos.server.service.dto.MeetingDTO;
import com.wiktor.wos.server.service.mapper.GuestMapper;
import com.wiktor.wos.server.service.mapper.MeetingMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class SetUpMeetingService {
    private SetUpMeetingRepository setUpMeetingRepository;
    private GuestService guestService;
    private MeetingMapper meetingMapper;
    private GuestMapper guestMapper;

    public SetUpMeetingService(SetUpMeetingRepository setUpMeetingRepository, GuestService guestService,
                               MeetingMapper meetingMapper, GuestMapper guestMapper) {
        this.setUpMeetingRepository = setUpMeetingRepository;
        this.guestService = guestService;
        this.meetingMapper = meetingMapper;
        this.guestMapper = guestMapper;
    }

    public void saveSetUpMeeting(MeetingDTO meeting, GuestDTO guest) {
        if(guestService.getGuestByEmail(guest.getEmail()) == null) {
            guestService.saveGuest(guest);
        }
        SetUpMeeting setUpMeeting = new SetUpMeeting();
        setUpMeeting.setGuest(guestMapper.toEntity(guestService.getGuestByEmail(guest.getEmail())));
        setUpMeeting.setMeeting(meetingMapper.toEntity(meeting));
        setUpMeeting.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        setUpMeetingRepository.save(setUpMeeting);
    }

    public List<MeetingDTO> getUsersSetUpMeetings(Long userID) {
        List<SetUpMeeting> setUpMeetings = setUpMeetingRepository.findByMeeting_User_IdOrderByCreatedAtAsc(userID);
        List<Meeting> meetings = new ArrayList<>();
        setUpMeetings.forEach(setUpMeeting -> meetings.add(setUpMeeting.getMeeting()));
        return meetingMapper.toDto(meetings);
    }
}
