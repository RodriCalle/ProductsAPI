package com.example.newapi.controller;

import com.example.newapi.domain.model.User;
import com.example.newapi.domain.repository.IUserRepository;
import com.example.newapi.domain.service.IDefaultUserDetailsService;
import com.example.newapi.service.communication.AuthenticationRequest;
import com.example.newapi.service.communication.AuthenticationResponse;
import com.example.newapi.util.JwtCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtCenter tokenCenter;
    @Autowired
    private IDefaultUserDetailsService userDetailsService;
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/sign-in")
    public ResponseEntity<?> register(@RequestBody AuthenticationRequest request) throws Exception {
        authenticate(request.getUsername(), request.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        User user = userRepository.findByEmail(request.getUsername());
        String token = tokenCenter.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(userDetails.getUsername(), token, user.getId()));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
