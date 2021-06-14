package com.wiktor.wos.server.rest;

import com.wiktor.wos.server.entity.Meeting;
import com.wiktor.wos.server.entity.SetUpMeeting;
import com.wiktor.wos.server.service.MeetingService;
import com.wiktor.wos.server.service.SetUpMeetingService;
import com.wiktor.wos.server.service.UserService;
import com.wiktor.wos.server.service.dto.AddMeetingDTO;
import com.wiktor.wos.server.service.dto.GuestDTO;
import com.wiktor.wos.server.service.dto.MeetingDTO;
import com.wiktor.wos.server.service.dto.UserDTO;
import com.wiktor.wos.server.service.exception.ForbiddenException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/meetings")
public class MeetingController {

    private MeetingService meetingService;

    private UserService userService;

    private SetUpMeetingService setUpMeetingService;

    public MeetingController(MeetingService meetingService, SetUpMeetingService setUpMeetingService,
                             UserService userService) {
        this.meetingService = meetingService;
        this.setUpMeetingService = setUpMeetingService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDTO> getMeeting(@PathVariable Long id) {
        return ResponseEntity.ok(meetingService.getMeeting(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<MeetingDTO>> getUserMeetings(@PathVariable Long id) {
        return ResponseEntity.ok(meetingService.getUserMeetings(id));
    }

    @PostMapping
    public ResponseEntity<Void> addMeeting(@RequestBody @Validated AddMeetingDTO dto, Authentication authentication)
            throws Exception {
        UserDTO userDTO = userService.getUser(authentication.getName());
        dto.setUserId(userDTO.getId());
        meetingService.save(dto);
        return ResponseEntity.created(new URI("")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMeeting(@RequestBody @Validated AddMeetingDTO dto, @PathVariable Long id,
                                           Authentication authentication) {
        UserDTO authUserDTO = userService.getUser(authentication.getName());
        if(!authUserDTO.getId().equals(dto.getUserId())) {
            throw new ForbiddenException("User ID does not match.");
        }
        meetingService.update(dto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id, Authentication authentication) {
        MeetingDTO meetingDTO = meetingService.getMeeting(id);
        UserDTO authUserDTO = userService.getUser(authentication.getName());
        if(!authUserDTO.getId().equals(meetingDTO.getUserId())) {
            throw new ForbiddenException("User ID does not match.");
        }
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
