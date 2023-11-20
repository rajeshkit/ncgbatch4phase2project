//import com.ats.entity.CurrentUserSession;
//import com.ats.entity.User;
//import com.ats.exception.UserException;
//import com.ats.repository.ICurrentUserSessionRepository;
//import com.ats.repository.IUserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//class UserServiceImplTest {
//
//    @Mock
//    private IUserRepository userRepository;
//
//    @Mock
//    private ICurrentUserSessionRepository userSessionRepository;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateUser() throws UserException {
//        // Arrange
//        User newUser = new User("test@example.com", "password", "John Doe");
//        when(userRepository.findByEmail(anyString())).thenReturn(null);
//        when(userRepository.save(newUser)).thenReturn(newUser);
//
//        // Act
//        User createdUser = userService.createUser(newUser);
//
//        // Assert
//        verify(userRepository, times(1)).findByEmail(anyString());
//        verify(userRepository, times(1)).save(newUser);
//        assert newUser.equals(createdUser);
//    }
//
//    @Test
//    void testCreateUser_ExistingUser() {
//        // Arrange
//        User existingUser = new User("existing@example.com", "password", "Existing User");
//        when(userRepository.findByEmail(anyString())).thenReturn(existingUser);
//
//        // Act & Assert
//        assertThrows(UserException.class, () -> userService.createUser(existingUser));
//        verify(userRepository, times(1)).findByEmail(anyString());
//        verify(userRepository, never()).save(existingUser);
//    }
//
//    @Test
//    void testUpdateUser() throws UserException {
//        // Arrange
//        User updatedUser = new User("test@example.com", "newPassword", "Updated User");
//        String sessionKey = "validSessionKey";
//        CurrentUserSession currentUserSession = new CurrentUserSession(sessionKey, updatedUser.getUserID());
//        when(userSessionRepository.findByUuid(sessionKey)).thenReturn(currentUserSession);
//        when(userRepository.save(updatedUser)).thenReturn(updatedUser);
//
//        // Act
//        User resultUser = userService.updateUser(updatedUser, sessionKey);
//
//        // Assert
//        verify(userSessionRepository, times(1)).findByUuid(sessionKey);
//        verify(userRepository, times(1)).save(updatedUser);
//        assert updatedUser.equals(resultUser);
//    }
//
//    @Test
//    void testUpdateUser_InvalidKey() {
//        // Arrange
//        User userToUpdate = new User("test@example.com", "password", "John Doe");
//        String invalidKey = "invalidKey";
//        when(userSessionRepository.findByUuid(invalidKey)).thenReturn(null);
//
//        // Act & Assert
//        assertThrows(UserException.class, () -> userService.updateUser(userToUpdate, invalidKey));
//        verify(userSessionRepository, times(1)).findByUuid(invalidKey);
//        verify(userRepository, never()).save(userToUpdate);
//    }
//
//    @Test
//    void testUpdateUser_InvalidUserDetails() {
//        // Arrange
//        User userToUpdate = new User("test@example.com", "password", "John Doe");
//        String sessionKey = "validSessionKey";
//        CurrentUserSession currentUserSession = new CurrentUserSession(sessionKey, 999); // Invalid user ID
//        when(userSessionRepository.findByUuid(sessionKey)).thenReturn(currentUserSession);
//
//        // Act & Assert
//        assertThrows(UserException.class, () -> userService.updateUser(userToUpdate, sessionKey));
//        verify(userSessionRepository, times(1)).findByUuid(sessionKey);
//        verify(userRepository, never()).save(userToUpdate);
//    }
//}
