package com.example.demo.repository;

import com.example.demo.Entyty.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Repository
public class UserRepository {
    Set<User> users;

    public UserRepository() {
        users = new HashSet<>();
        users.add(new User(1l, "User", "$2a$12$ZX2bLRXno8.UVbfPEMXk6uWcZKTbKLm.Rowov/QJ/feaDo2RXM4YC", "ROLE_USER" ));
        users.add(new User(2l, "Admin", "$2a$12$ZX2bLRXno8.UVbfPEMXk6uWcZKTbKLm.Rowov/QJ/feaDo2RXM4YC", "ROLE_ADMIN" ));
    }

    public User getByName(String username) {
        return users.stream().filter(user -> Objects.equals(user.getName(), username)).findAny().orElse(null);
    }
}
