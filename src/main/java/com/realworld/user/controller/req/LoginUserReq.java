package com.realworld.user.controller.req;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginUserReq {
    private String email;
    private String password;
}
