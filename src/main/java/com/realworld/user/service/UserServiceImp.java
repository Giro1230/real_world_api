package com.realworld.user.service;

import com.realworld.user.controller.req.*;
import com.realworld.user.controller.res.*;

import com.realworld.user.repository.UserRepository;
import com.realworld.user.service.inf.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImp implements UserServiceInterface {

    private Logger logger;
    private final UserRepository userRepository;

    public UserServiceImp(Logger logger, UserRepository userRepository) {
        this.logger = LoggerFactory.getLogger(UserServiceImp.class);
        this.userRepository = userRepository;
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
