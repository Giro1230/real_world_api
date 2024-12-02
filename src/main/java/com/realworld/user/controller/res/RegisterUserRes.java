package com.realworld.user.controller.res;

import com.realworld.user.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserRes {
    private String username;
    private String email;
    private String bio;
    private String image;
    private String token;

    public RegisterUserRes dataTransfer(User user, String token){
        return RegisterUserRes.builder()
                .username(user.getName())
                .email(user.getEmail())
                .bio(user.getBio())
                .image(user.getImage())
                .token(token)
                .build();
    }
}
