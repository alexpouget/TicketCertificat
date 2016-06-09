package com.esgi.service;

import com.esgi.entity.User;
import com.esgi.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface UserService {
    //User
    List<User> findAllUser();
    User findByUid(String uid);
    User newUser(User user);
    User updateUser(User user);
    void deleteUser(String id);
    //UserRole
    List<UserRole> findAllUserRole();
    UserRole findOneUserRole(int id);
    List<UserRole> findOneUserRoleByUid(String uid);
    List<UserRole> findOneUserRoleByRole(int id);
    UserRole updateUserRole(UserRole userRole);
    UserRole newUserRole(UserRole userRole);
    void deleteUserRole(int id);
}
