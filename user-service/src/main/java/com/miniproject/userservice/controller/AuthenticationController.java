package com.miniproject.userservice.controller;

import com.miniproject.userservice.entity.AuthRequest;
import com.miniproject.userservice.entity.User;
import com.miniproject.userservice.repository.UserRepository;
import com.miniproject.userservice.service.UserService;
import com.miniproject.userservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@Slf4j
public class AuthenticationController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        User user = userService.findByUserName(authRequest.getUserName());
        user.setToken(jwtUtil.generateToken(authRequest.getUserName()));

        return user;
    }
}
