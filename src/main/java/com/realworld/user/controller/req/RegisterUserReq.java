package com.realworld.user.controller.req;

import com.realworld.user.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserReq {
    private String email;
    private String password;
    private String userName;

    public User dataTransfer() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .name(this.userName)
                .build();
    }
}
