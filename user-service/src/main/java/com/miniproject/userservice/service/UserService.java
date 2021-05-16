package com.miniproject.userservice.service;

import com.miniproject.userservice.entity.User;
import com.miniproject.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        log.info("Inside user service");
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User oldUser, User newUser) {
        oldUser.setRole(newUser.getRole());
        return userRepository.save(oldUser);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByNameContaining(String name) {
        return userRepository.findByUserNameContaining(name);
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());

    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
