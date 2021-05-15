package com.miniproject.userservice.repository;

import com.miniproject.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserNameContaining(String name);

    User findByUserName(String userName);
}
