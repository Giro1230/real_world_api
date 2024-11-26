package com.realworld.user.controller.req;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatedUserReq {
    private String email;
}
