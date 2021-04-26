package com.wiktor.wos.server.service.mapper;

import com.wiktor.wos.server.entity.Meeting;
import com.wiktor.wos.server.service.dto.MeetingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeetingMapper extends EntityMapper<Meeting, MeetingDTO> {

    @Mapping(source = "userID", target = "user.id")
    Meeting toEntity(MeetingDTO meetingDTO);

    @Mapping(source = "meeting.user.id", target = "userID")
    MeetingDTO toDto(Meeting meeting);
}
