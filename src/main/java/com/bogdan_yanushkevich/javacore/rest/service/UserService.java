package com.bogdan_yanushkevich.javacore.rest.service;

import com.bogdan_yanushkevich.javacore.rest.model.User;
import com.bogdan_yanushkevich.javacore.rest.repository.UserRepository;
import com.bogdan_yanushkevich.javacore.rest.repository.impl.HibUserRepositoryImpl;


import java.util.List;

public class UserService {

    private final UserRepository userRepository = new HibUserRepositoryImpl();

    public User save(String name) {
        User user = new User();
        user.setUserName(name);
        return userRepository.create(user);
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public User update(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setUserName(name);
        return userRepository.update(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
