package com.wiktor.wos.server.rest;

import com.wiktor.wos.server.entity.Meeting;
import com.wiktor.wos.server.entity.SetUpMeeting;
import com.wiktor.wos.server.service.MeetingService;
import com.wiktor.wos.server.service.SetUpMeetingService;
import com.wiktor.wos.server.service.dto.AddMeetingDTO;
import com.wiktor.wos.server.service.dto.GuestDTO;
import com.wiktor.wos.server.service.dto.MeetingDTO;
import com.wiktor.wos.server.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/meetings")
public class MeetingController {

    private MeetingService meetingService;

    private SetUpMeetingService setUpMeetingService;

    public MeetingController(MeetingService meetingService, SetUpMeetingService setUpMeetingService) {
        this.meetingService = meetingService;
        this.setUpMeetingService = setUpMeetingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDTO> getMeeting(@PathVariable Long id) {
        return ResponseEntity.ok(meetingService.getMeeting(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<MeetingDTO>> getUserPosts(@PathVariable Long id) {
        return ResponseEntity.ok(meetingService.getUserMeetings(id));
    }

    @PostMapping
    public ResponseEntity<Void> addPost(@RequestBody @Validated AddMeetingDTO dto)
            throws Exception {
        //TODO user will be retrieved from Authentication
        UserDTO authenticatedUser = getAuthUseDTO();
        dto.setUserId(authenticatedUser.getId());
        meetingService.save(dto);
        return ResponseEntity.created(new URI("")).build();
    }

    private UserDTO getAuthUseDTO() {
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setFirstName("user");
        dto.setEmail("email");
        dto.setLastName("user");
        return dto;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@RequestBody @Validated AddMeetingDTO dto, @PathVariable Long id) {
        //TODO check if authorised user id matches meeting user id
        meetingService.update(dto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        //TODO check if authorised user id matches meeting user id
        meetingService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/setUp/{id}")
    public ResponseEntity<Void> setUpMeeting(@RequestBody @Validated GuestDTO guestDTO, @PathVariable Long id)
            throws Exception{
        MeetingDTO meetingDTO = meetingService.getMeeting(id);
        setUpMeetingService.saveSetUpMeeting(meetingDTO, guestDTO);
        return ResponseEntity.created(new URI("")).build();
    }

    @GetMapping("/setUp/user/{id}")
    public ResponseEntity<List<MeetingDTO>> getSetUpMeetings(@PathVariable Long id) {
        return ResponseEntity.ok(setUpMeetingService.getUsersSetUpMeetings(id));
    }

}
