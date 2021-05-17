package com.wiktor.wos.server.rest;

import com.wiktor.wos.server.service.MeetingService;
import com.wiktor.wos.server.service.dto.AddMeetingDTO;
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

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
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
        dto.setName("user");
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

}
