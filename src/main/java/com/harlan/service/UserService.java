package com.harlan.service;

import com.harlan.authentication.SimpleAuthenticationProvider;
import com.harlan.domain.User;
import com.harlan.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Page<User> findByPage(Integer page, Integer size) {
        return null;
    }

    @Override
    public void update(User User) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Autowired
    private SimpleAuthenticationProvider simpleAuthenticationProvider;

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
