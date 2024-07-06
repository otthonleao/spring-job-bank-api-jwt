package dev.otthon.jobbank.api.auth.controllers;

import dev.otthon.jobbank.api.auth.dtos.UserRequestDTO;
import dev.otthon.jobbank.api.auth.dtos.UserResponseDTO;
import dev.otthon.jobbank.api.auth.mappers.UserMapper;
import dev.otthon.jobbank.core.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthRestController {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponseDTO register(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        var user = userMapper.toUser(userRequestDTO);
        var passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        user = userRepository.save(user);
        return userMapper.toUserResponseDTO(user);
    }

}
