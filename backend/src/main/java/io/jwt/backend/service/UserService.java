package io.jwt.backend.service;

import io.jwt.backend.model.Role;
import io.jwt.backend.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User>getUsers();
}
