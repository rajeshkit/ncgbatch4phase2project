package com.ats.service;

import com.ats.entity.User;
import com.ats.exception.UserException;

public interface IUserService {
    public User createUser(User user) throws UserException;
    public User updateUser(User user, String key) throws UserException;
}
