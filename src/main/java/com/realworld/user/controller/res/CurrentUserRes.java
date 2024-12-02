package com.realworld.user.controller.res;

import com.realworld.user.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentUserRes {
    private String username;
    private String email;
    private String bio;
    private String image;
    private String token;

    public CurrentUserRes dataTransfer(User user, String token){
        return CurrentUserRes.builder()
                .username(user.getName())
                .email(user.getEmail())
                .bio(user.getBio())
                .image(user.getImage())
                .token(token)
                .build();
    }
}
