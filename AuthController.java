package com.example.controller;

import com.example.dto.UserDto;
import com.example.dto.TokenDto;
import com.example.model.Project;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.register(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserDto userDto) {
        String token = userService.login(userDto.getUsername(), userDto.getPassword());
        if (token != null) {
            TokenDto tokenDto = new TokenDto();
            tokenDto.setAccessToken(token);
            tokenDto.setTokenType("Bearer");
            return ResponseEntity.ok(tokenDto);
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(/* project list */);
    }

    @PostMapping("/projects/create")

        return ResponseEntity.ok(/* created project */);
    }
}
