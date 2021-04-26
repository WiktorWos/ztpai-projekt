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

    public MeetingDTO convertToMeetingDTO() {
        MeetingDTO dto = new MeetingDTO();
        dto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        dto.setHourEnd(this.hourEnd);
        dto.setHourStart(this.hourStart);
        dto.setMeetingDate(this.meetingDate);

        return dto;
    }
}
