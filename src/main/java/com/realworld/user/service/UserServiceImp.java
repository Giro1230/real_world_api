package com.realworld.user.service;

import com.realworld.security.jwt.Jwt;
import com.realworld.user.controller.req.*;
import com.realworld.user.controller.res.*;

import com.realworld.user.repository.UserRepository;
import com.realworld.user.service.inf.UserServiceInterface;
import org.slf4j.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServiceInterface {

    private Logger logger;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Jwt jwt;

    public UserServiceImp(Jwt jwt, PasswordEncoder passwordEncoder, UserRepository userRepository, Logger logger) {
        this.jwt = jwt;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.logger = LoggerFactory.getLogger(UserServiceImp.class);
    }

    @Override
    public RegisterUserRes register(RegisterUserReq data) {
        return null;
    }

    @Override
    public LoginUserRes login(LoginUserReq data) {
        return null;
    }

    @Override
    public CurrentUserRes getCurrentUser(CurrentUserReq data) {
        return null;
    }

    @Override
    public UpdatedUserRes update(String email, UpdatedUserReq data) {
        return null;
    }
}
