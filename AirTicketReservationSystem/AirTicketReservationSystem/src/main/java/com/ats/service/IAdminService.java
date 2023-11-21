package com.ats.service;

import com.ats.entity.Admin;
import com.ats.exception.AdminException;

public interface IAdminService {
    public Admin createAdmin(Admin admin) throws AdminException;
    public Admin updateAdmin(Admin admin, String key) throws AdminException;
}
