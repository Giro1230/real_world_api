package com.realworld.user.controller.req;

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
}
