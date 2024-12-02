package com.realworld.user.service;

import com.realworld.security.jwt.Jwt;
import com.realworld.user.controller.req.*;
import com.realworld.user.controller.res.*;
import com.realworld.user.domain.User;
import com.realworld.user.repository.UserRepository;
import com.realworld.user.service.inf.UserServiceInterface;
import org.slf4j.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServiceInterface {

    private final Logger logger;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Jwt jwt;

    public UserServiceImp(Jwt jwt, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jwt = jwt;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.logger = LoggerFactory.getLogger(UserServiceImp.class);
    }

    @Override
    public RegisterUserRes register(RegisterUserReq data) {
        //password encode
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        logger.info("user password encoded : {}", data.getEmail());

        // RegisterUserReq -> User
        User userData = data.dataTransfer();

        return new RegisterUserRes()
                .dataTransfer(userData, jwt.generateToken(userData));
    }

    @Override
    public LoginUserRes login(LoginUserReq data) {
        // getUserEmail
        User user = userRepository.findByEmail(data.getEmail());

        if (passwordEncoder.matches(data.getPassword(), user.getPassword())) {

            // User -> LoginUserRes
            return new LoginUserRes()
                    .dataTransfer(user, jwt.generateToken(user));

        } else {
            logger.error("Failed to login user");
            throw new RuntimeException("Failed to login user");
        }
    }

    @Override
    public CurrentUserRes getCurrentUser(CurrentUserReq data) {
        User user = getUserByEmail(data.getEmail());
        return new CurrentUserRes()
                .dataTransfer(user, jwt.generateToken(user));
    }

    @Override
    public UpdatedUserRes update(String email, UpdatedUserReq data) {
        // findUserByEmail
        User user = getUserByEmail(email);

        // updatedUser
        user.updated(data);

        return new UpdatedUserRes()
                .dataTransfer(user, jwt.generateToken(user));
    }

    public User getUserByEmail(String userEmail) {
        try {

            return userRepository.findByEmail(userEmail);
        } catch (Exception e) {

            logger.error("Failed to get user by email: {}", userEmail, e);
            throw new RuntimeException("Failed to get user by email: " + userEmail, e);
        }
    }
}
