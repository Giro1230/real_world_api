package com.realworld.user.controller;

import com.realworld.security.jwt.Jwt;
import com.realworld.user.controller.req.LoginUserReq;
import com.realworld.user.controller.req.RegisterUserReq;
import com.realworld.user.controller.res.LoginUserRes;
import com.realworld.user.controller.res.RegisterUserRes;
import com.realworld.user.service.inf.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final UserServiceInterface userService;

    @Autowired
    public AuthController(Jwt jwt, UserServiceInterface userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserRes> userRegister(@RequestBody RegisterUserReq user) {
        try {
            logger.info("'/users' Request  Data = {}", user);

            RegisterUserRes returnData = userService.register(user);
            logger.info("'/users' Respones Data = {}", user);

            return ResponseEntity.ok(returnData);
        } catch (Exception e) {

            logger.error("Failed to register user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserRes> login(@RequestBody LoginUserReq user) {
        try {
            logger.info("'/login' Request Data = {}", user);

            LoginUserRes returnData = userService.login(user);
            logger.info("'/login' Response Token = {}", returnData);

            return ResponseEntity.ok(returnData);
        } catch (Exception e) {

            logger.error("Failed to login user", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
