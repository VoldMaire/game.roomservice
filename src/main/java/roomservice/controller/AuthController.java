package roomservice.controller;

import java.net.URI;
import java.util.Collections;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import roomservice.datasource.PlayerRepository;
import roomservice.datasource.RoleRepository;
import roomservice.entity.Player;
import roomservice.entity.Role;
import roomservice.entity.RoleName;
import roomservice.exception.AppException;
import roomservice.payload.ApiResponse;
import roomservice.payload.JwtAuthenticationResponse;
import roomservice.payload.LoginRequest;
import roomservice.payload.SignUpRequest;
import roomservice.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(),
                                                loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (playerRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                                      HttpStatus.BAD_REQUEST);
        }

        if (playerRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                                      HttpStatus.BAD_REQUEST);
        }

        Player player = new Player(signUpRequest.getName(), signUpRequest.getUsername(),
                               signUpRequest.getEmail(), signUpRequest.getPassword());

        player.setPassword(passwordEncoder.encode(player.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                                      .orElseThrow(() -> new AppException("User Role not set."));

        player.setRoles(Collections.singleton(userRole));

        Player result = playerRepository.save(player);

        URI location = ServletUriComponentsBuilder
                       .fromCurrentContextPath().path("/api/users/{username}")
                       .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}