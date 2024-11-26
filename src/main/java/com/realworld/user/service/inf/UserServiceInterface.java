package com.realworld.user.service.inf;

import com.realworld.user.controller.req.*;
import com.realworld.user.controller.res.*;

public interface UserServiceInterface {
    RegisterUserRes register(RegisterUserReq data);
    LoginUserRes login (LoginUserReq data);
    CurrentUserRes getCurrentUser(CurrentUserReq data);
    UpdatedUserRes update(String email, UpdatedUserReq data);
}
