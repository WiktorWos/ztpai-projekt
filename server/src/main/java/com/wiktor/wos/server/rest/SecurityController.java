package com.wiktor.wos.server.rest;

import com.wiktor.wos.server.config.security.JwtTokenProvider;
import com.wiktor.wos.server.service.UserService;
import com.wiktor.wos.server.service.dto.LoginPasswordDTO;
import com.wiktor.wos.server.service.dto.RegisterDTO;
import com.wiktor.wos.server.service.dto.TokenDTO;
import com.wiktor.wos.server.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
public class SecurityController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    public SecurityController(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<Void> signup(
            @RequestBody @Validated RegisterDTO registerDTO
    ) throws Exception {

        userService.addNewUser(registerDTO);

        return ResponseEntity.created(new URI("")).build();
    }

    @PostMapping("login")
    public ResponseEntity<TokenDTO> signin(
            @RequestBody @Validated LoginPasswordDTO loginPasswordDTO
    ) throws Exception {

        try {
            String email = loginPasswordDTO.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, loginPasswordDTO.getPassword()));

            String token = jwtTokenProvider.createToken();
            this.userService.setToken(email, token);

            TokenDTO response = new TokenDTO();
            response.setToken(token);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid login/password supplied");
        }
    }

    @PutMapping("logout")
    public ResponseEntity<Void> signout(Authentication authentication){
        this.userService.setToken(authentication.getName(), null);
        return ResponseEntity.noContent().build();
    }

    // secured
    @GetMapping("user")
    public ResponseEntity<UserDTO> getAuthUser(Authentication authentication) {
        return ResponseEntity.ok(this.userService.getUser(authentication.getName()));
    }
}
