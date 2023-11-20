package com.ats.service;

import com.ats.entity.CurrentUserSession;
import com.ats.entity.UserLoginDTO;
import com.ats.exception.LoginException;

public interface ILoginService {
    public CurrentUserSession userLogin(UserLoginDTO login) throws LoginException;
    public String userLogout(String key) throws LoginException;
}
