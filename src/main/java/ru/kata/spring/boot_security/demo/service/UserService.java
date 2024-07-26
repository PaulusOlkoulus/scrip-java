package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public interface UserService {
    List<User> findAll();

    Optional<User> findByUsername(String name);

    Optional<User> findByEmail(String email);

    void deleteUser(long id);


    void updateUser(UserDTO user);

    void saveUserWithRoles(UserDTO user);

    void saveUserWithRoles(User user, Set<Role> roles);

    UserDTO getUserById(Long id);


}
