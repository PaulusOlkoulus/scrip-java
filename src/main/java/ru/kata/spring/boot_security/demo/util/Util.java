package ru.kata.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Util {

    private final UserServiceImpl userServiceImpl;
private final RoleServiceImpl roleServiceImpl;

    public Util(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
    }


    @PostConstruct
    public void init() {
        // создаю роли
        Role roleUser = new Role(1L, "ROLE_USER");
        Role roleAdmin = new Role(2L, "ROLE_ADMIN");
        roleServiceImpl.save(roleUser);
        roleServiceImpl.save(roleAdmin);

        // для входа
        userServiceImpl.saveUserWithRoles(new User("admin", "admin", 30, "admin", "admin@mail.com"),
                new HashSet<>(Set.of(roleAdmin)));
        System.out.println(roleAdmin);
        userServiceImpl.saveUserWithRoles(new User("user", "user", 31, "user", "user@mail.com"),
                new HashSet<>(Set.of(roleUser)));
    }
}