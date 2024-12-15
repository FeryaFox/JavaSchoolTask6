package ru.feryafox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.feryafox.model.User;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void testCreateUser() {
        User user = new User("testuser", "test@example.com");
        User createdUser = userService.createUser(user);

        assertNotNull(createdUser.getId());
        assertEquals("testuser", createdUser.getUsername());
        assertEquals("test@example.com", createdUser.getEmail());
    }

    @Test
    void testFindUserById() {
        User user = new User("testuser", "test@example.com");
        User createdUser = userService.createUser(user);

        Optional<User> foundUser = userService.findUserById(createdUser.getId());
        assertTrue(foundUser.isPresent());
        assertEquals(createdUser, foundUser.get());
    }

    @Test
    void testUpdateUser() {
        User user = new User("testuser", "test@example.com");
        User createdUser = userService.createUser(user);

        createdUser.setUsername("updateduser");
        User updatedUser = userService.updateUser(createdUser);

        assertEquals("updateduser", updatedUser.getUsername());
    }

    @Test
    void testDeleteUser() {
        User user = new User("testuser", "test@example.com");
        User createdUser = userService.createUser(user);

        userService.deleteUser(createdUser.getId());

        Optional<User> deletedUser = userService.findUserById(createdUser.getId());
        assertFalse(deletedUser.isPresent());
    }

    @Test
    void testFindUserByUsername() {
        User user = new User("testuser", "test@example.com");
        userService.createUser(user);

        Optional<User> foundUser = userService.findUserByUsername("testuser");
        assertTrue(foundUser.isPresent());
        assertEquals("testuser", foundUser.get().getUsername());
    }
}