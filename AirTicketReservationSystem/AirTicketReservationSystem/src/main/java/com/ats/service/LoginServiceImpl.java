package com.ats.service;
import com.ats.entity.CurrentUserSession;
import com.ats.entity.UserLoginDTO;
import com.ats.entity.User;
import com.ats.exception.LoginException;
import com.ats.repository.ICurrentUserSessionRepository;
import com.ats.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.security.SecureRandom;
import java.util.Base64;
@Service
public class LoginServiceImpl implements ILoginService{
    private final IUserRepository userRepository;
    private final ICurrentUserSessionRepository userSessionRepository;

    @Autowired
    public LoginServiceImpl(IUserRepository userRepository, ICurrentUserSessionRepository userSessionRepository) {
        this.userRepository = userRepository;
        this.userSessionRepository = userSessionRepository;
    }
    @Override
    public CurrentUserSession userLogin(UserLoginDTO login) throws LoginException {
        User registeredUser = userRepository.findByEmail(login.getEmail());
        if(registeredUser == null) throw new LoginException("Please enter valid email!");

        Optional<CurrentUserSession> loggedInUser =  userSessionRepository.findById(registeredUser.getUserID());
        if(loggedInUser.isPresent()) throw new LoginException("User already Logged!");

        if(registeredUser.getPassword().equals(login.getPassword())) {
            SecureRandom secureRandom = new SecureRandom();
            byte[] keyBytes = new byte[10];
            secureRandom.nextBytes(keyBytes);

            String key = Base64.getEncoder().encodeToString(keyBytes);

            CurrentUserSession currentUserSession = new CurrentUserSession();
            currentUserSession.setUserID(registeredUser.getUserID());
            currentUserSession.setUuid(key);
            currentUserSession.setTime(LocalDateTime.now());
            return userSessionRepository.save(currentUserSession);
        }else
            throw new LoginException("Please enter a valid password!");
    }

    @Override
    public String userLogout(String key) throws LoginException {
        CurrentUserSession loggedInUser = userSessionRepository.findByUuid(key);
        if(loggedInUser == null)  throw new LoginException("Please enter a valid key or login first!");
        userSessionRepository.delete(loggedInUser);
        return "User logged out!";
    }
}
