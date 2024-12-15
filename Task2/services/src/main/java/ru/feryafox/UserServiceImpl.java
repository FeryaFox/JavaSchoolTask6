package ru.feryafox;

import ru.feryafox.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final Map<UUID, User> userStorage = new HashMap<>();

    @Override
    public User createUser(User user) {
        if (user.getId() == null) {
            user = new User(user.getUsername(), user.getEmail());
        }
        userStorage.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return Optional.ofNullable(userStorage.get(id));
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userStorage.values().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public List<User> findUsersByEmail(String email) {
        return userStorage.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        if (!userStorage.containsKey(user.getId())) {
            throw new IllegalArgumentException("User not found");
        }
        userStorage.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteUser(UUID id) {
        userStorage.remove(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userStorage.values());
    }
}
