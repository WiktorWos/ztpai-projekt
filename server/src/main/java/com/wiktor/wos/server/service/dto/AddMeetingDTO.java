package com.wiktor.wos.server.service.dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddMeetingDTO {

    @NotNull
    private LocalDate meetingDate;

    @NotNull
    private LocalTime hourStart;

    @NotNull
    private LocalTime hourEnd;

    private Long userId;

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public LocalTime getHourStart() {
        return hourStart;
    }

    public void setHourStart(LocalTime hourStart) {
        this.hourStart = hourStart;
    }

    public LocalTime getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(LocalTime hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MeetingDTO convertToMeetingDTO() {
        MeetingDTO dto = new MeetingDTO();
        dto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        dto.setHourEnd(this.hourEnd);
        dto.setHourStart(this.hourStart);
        dto.setMeetingDate(this.meetingDate);
        dto.setUserId(this.userId);

        return dto;
    }
}
