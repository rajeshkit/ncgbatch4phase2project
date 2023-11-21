package com.ats.service;

import com.ats.entity.CurrentUserSession;
import com.ats.entity.User;
import com.ats.exception.UserException;
import com.ats.repository.ICurrentUserSessionRepository;
import com.ats.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final ICurrentUserSessionRepository userSessionRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, ICurrentUserSessionRepository userSessionRepository) {
        this.userRepository = userRepository;
        this.userSessionRepository = userSessionRepository;
    }

    @Override
    public User createUser(User user) throws UserException {
        User registeredUser = userRepository.findByEmail(user.getMobile());
        if (registeredUser != null) throw new UserException("User is already registered!");
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, String key) throws UserException {
        CurrentUserSession loggedInUser = userSessionRepository.findByUuid(key);
        if (loggedInUser == null) throw new UserException("Please enter a valid key or login first!");
        if (!Objects.equals(user.getUserID(), loggedInUser.getUserID()))
            throw new UserException("Invalid user details, please login for updating user!");
        return userRepository.save(user);
    }
}
