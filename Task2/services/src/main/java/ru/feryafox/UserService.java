package ru.feryafox;

import ru.feryafox.model.User;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(User user);
    Optional<User> findUserById(UUID id);
    Optional<User> findUserByUsername(String username);
    List<User> findUsersByEmail(String email);
    User updateUser(User user);
    void deleteUser(UUID id);
    List<User> getAllUsers();
}