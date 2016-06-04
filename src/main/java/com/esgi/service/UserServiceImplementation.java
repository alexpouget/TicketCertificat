package com.esgi.service;

import com.esgi.entity.User;
import com.esgi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findByUid(String uid) {
        return userRepository.findUserByUid(uid);
    }

    @Override
    public User newUser(User user) {
        User user1 = new User();
        user1.setUid(user.getUid());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        return userRepository.save(user1);
    }

    @Override
    public User updateUser(User user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setUid(user.getUid());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        return userRepository.save(user1);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }
}
