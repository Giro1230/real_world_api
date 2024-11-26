package com.realworld.user.controller;

import com.realworld.user.controller.req.*;
import com.realworld.user.controller.res.*;
import com.realworld.user.service.inf.UserServiceInterface;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final Jwt jwt;
    private final UserServiceInterface userService;

    @PostMapping("/register")
    public void userRegister(@RequestBody RegisterUserReq user) {

    }
}
