package com.wiktor.wos.server.service.mapper;

import com.wiktor.wos.server.entity.Meeting;
import com.wiktor.wos.server.service.dto.MeetingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeetingMapper extends EntityMapper<Meeting, MeetingDTO> {

    @Mapping(source = "userId", target = "user.id")
    Meeting toEntity(MeetingDTO meetingDTO);

    @Mapping(source = "meeting.user.id", target = "userId")
    MeetingDTO toDto(Meeting meeting);

}
