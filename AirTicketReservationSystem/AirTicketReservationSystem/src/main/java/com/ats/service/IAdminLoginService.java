package com.ats.service;

import com.ats.entity.AdminLogin;
import com.ats.entity.CurrentAdminSession;
import com.ats.exception.AdminException;
import com.ats.exception.LoginException;

public interface IAdminLoginService {
    public CurrentAdminSession adminLogin(AdminLogin loginDTO) throws LoginException, AdminException;

    public String adminLogout(String key) throws LoginException;

}
