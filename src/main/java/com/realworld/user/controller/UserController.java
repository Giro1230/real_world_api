package com.realworld.user.controller;

import com.realworld.security.jwt.Jwt;
import com.realworld.user.controller.req.CurrentUserReq;
import com.realworld.user.controller.req.UpdatedUserReq;
import com.realworld.user.controller.res.CurrentUserRes;
import com.realworld.user.controller.res.UpdatedUserRes;
import com.realworld.user.service.inf.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final UserServiceInterface userService;

    @Autowired
    public UserController(Jwt jwt, UserServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<CurrentUserRes> getCurrentUser(@AuthenticationPrincipal CurrentUserReq user) {
        try {
            logger.info("Get '/user' Request Data");

            CurrentUserRes returnData = userService.getCurrentUser(user);

            return ResponseEntity.ok(returnData);
        } catch (Exception e) {
            logger.error("Fail to current user", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdatedUserRes> updateUser(@AuthenticationPrincipal String email, @RequestBody UpdatedUserReq user) {
        try {
            logger.info("Put '/user' Request Data");
            UpdatedUserRes returnData = userService.update(email, user);

            return ResponseEntity.ok(returnData);
        } catch (Exception e) {
            logger.error("Fail to update user", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
