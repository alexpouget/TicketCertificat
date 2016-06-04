package com.esgi.service;

import com.esgi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface UserService {
    List<User> findAllUser();
    User findByUid(String uid);
    User newUser(User user);
    User updateUser(User user);
    void deleteUser(int id);
}
