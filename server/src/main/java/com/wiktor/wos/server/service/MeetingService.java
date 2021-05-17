package com.wiktor.wos.server.service;

import com.wiktor.wos.server.entity.Meeting;
import com.wiktor.wos.server.repository.MeetingRepository;
import com.wiktor.wos.server.service.dto.AddMeetingDTO;
import com.wiktor.wos.server.service.dto.MeetingDTO;
import com.wiktor.wos.server.service.exception.EntityNotFoundException;
import com.wiktor.wos.server.service.mapper.MeetingMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MeetingService {

    private MeetingRepository meetingRepository;

    private MeetingMapper meetingMapper;

    public MeetingService(MeetingRepository meetingRepository, MeetingMapper meetingMapper) {
        this.meetingRepository = meetingRepository;
        this.meetingMapper = meetingMapper;
    }

    public void save(AddMeetingDTO addMeetingDTO) {
        MeetingDTO meetingDTO = addMeetingDTO.convertToMeetingDTO();
        Meeting meeting = meetingMapper.toEntity(meetingDTO);

        meetingRepository.save(meeting);
    }

    public void update(AddMeetingDTO updatedDTO, Long id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requested meeting not found"));

        meeting.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        meeting.setHourStart(updatedDTO.getHourStart());
        meeting.setHourEnd(updatedDTO.getHourEnd());
        meeting.setMeetingDate(updatedDTO.getMeetingDate());

        meetingRepository.save(meeting);
    }

    public MeetingDTO getMeeting(Long id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requested meeting not found"));

        return meetingMapper.toDto(meeting);
    }

    public List<MeetingDTO> getUserMeetings(Long id) {
        List<Meeting> posts = meetingRepository.findByUser_IdOrderByHourStartDesc(id);

        return meetingMapper.toDto(posts);
    }

    public void deletePost(Long id) {
        if(!meetingRepository.existsById(id)) throw new EntityNotFoundException("Requested meeting not found");

        meetingRepository.deleteById(id);
    }
}
