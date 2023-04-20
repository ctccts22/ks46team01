package ks46team01.user.info.service;

import ks46team01.auth.entity.Role;
import ks46team01.auth.repository.RoleRepository;
import ks46team01.user.info.entity.User;
import ks46team01.user.info.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    RoleRepository roleRepository;

    @Mock
    EmailService emailService;

    @InjectMocks
    UserService userService;

    User testUser;
    Role testRole;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setUsername("testUsername");
        testUser.setPassword("testPassword");
        testUser.setEmail("test@example.com");

        testRole = new Role();
        testRole.setRoleName(Role.RoleName.USER);
    }

    @Test
    void testGetUserByUsername() {
        // When
        when(userRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));

        // Then
        Optional<User> foundUser = userService.getUserByUsername(testUser.getUsername());
        assertTrue(foundUser.isPresent());
        assertEquals(testUser.getUsername(), foundUser.get().getUsername());
    }

    @Test
    void testCreateUser() {
        // When
        when(roleRepository.findByRoleName(Role.RoleName.USER)).thenReturn(testRole);
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        // Then
        User createdUser = userService.createUser(testUser);
        assertNotNull(createdUser);
        assertEquals(testUser.getUsername(), createdUser.getUsername());
    }

    @Test
    void testModifyUser() {
        // Given
        User updatedUser = new User();
        updatedUser.setUsername("testUsername");
        updatedUser.setEmail("newemail@example.com");
        updatedUser.setPhone("123456789");
        updatedUser.setAddress("New Address");

        // When
        when(userRepository.findById(updatedUser.getUsername())).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        // Then
        User modifiedUser = userService.modifyUser(updatedUser);
        assertNotNull(modifiedUser);
        assertEquals(updatedUser.getEmail(), modifiedUser.getEmail());
        assertEquals(updatedUser.getPhone(), modifiedUser.getPhone());
        assertEquals(updatedUser.getAddress(), modifiedUser.getAddress());
    }

    @Test
    void testSendTemporaryPassword() {
        // When
        when(userRepository.findByEmail(testUser.getEmail())).thenReturn(List.of(testUser));

        // Then
        assertDoesNotThrow(() -> userService.sendTemporaryPassword(testUser.getUsername(), testUser.getEmail()));
        verify(emailService, times(1)).sendTemporaryPassword(anyString(), anyString(), anyString());
    }
}
