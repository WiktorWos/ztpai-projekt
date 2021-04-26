package com.wiktor.wos.server.service.dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public class MeetingDTO {

    private Long id;

    @NotNull
    private LocalDate meetingDate;

    @NotNull
    private LocalTime hourStart;

    @NotNull
    private LocalTime hourEnd;

    @NotNull
    private Timestamp createdAt;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
