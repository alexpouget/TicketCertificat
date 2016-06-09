package com.esgi.service;

import com.esgi.entity.User;
import com.esgi.entity.UserRole;
import com.esgi.repository.RoleRepository;
import com.esgi.repository.UserRepository;
import com.esgi.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;


    public List<User> findAllUser() {
        return userRepository.findAll();
    }


    public User findByUid(String uid) {
        return userRepository.findUserByUid(uid);
    }


    public User newUser(User user) {
        User user1 = new User();
        user1.setUid(user.getUid());
        user1.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user1.setEmail(user.getEmail());
        user1 = userRepository.save(user1);
        UserRole userRole = new UserRole();
        userRole.setUser(user1);
        userRole.setRole(roleRepository.findRoleByName("user"));
        userRoleRepository.save(userRole);
        return user1;
    }


    public User updateUser(User user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setUid(user.getUid());
        user1.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user1.setEmail(user.getEmail());
        user1 = userRepository.save(user1);
        return user1;
    }


    public void deleteUser(String id) {
        User u = userRepository.findUserByUid(id);
        userRepository.delete(u);
    }

    //UserRole

    public List<UserRole> findAllUserRole(){
        return userRoleRepository.findAll();
    }

    public UserRole findOneUserRole(int id){
        return userRoleRepository.findOne(id);
    }

    public List<UserRole> findOneUserRoleByUid(String uid){
        return userRoleRepository.getAllByUser(uid);
    }

    public List<UserRole> findOneUserRoleByRole(int id){
        return userRoleRepository.getAllByRole(id);
    }

    public UserRole updateUserRole(UserRole userRole){
        UserRole userRole1 = new UserRole();

        userRole1.setId(userRole.getId());

        if(null!=userRole.getUser()){
            userRole1.setRole(roleRepository.findOne(userRole.getRole().getId()));

        }
        if(null!=userRole.getUser()){
            userRole1.setUser(userRepository.findOne(userRole.getUser().getId()));
        }
        return userRoleRepository.save(userRole1);
    }

    public UserRole newUserRole(UserRole userRole){
        UserRole userRole1 = new UserRole();
        if(null!=userRole.getUser()){
            userRole1.setRole(roleRepository.findOne(userRole.getRole().getId()));

        }
        if(null!=userRole.getUser()){
            userRole1.setUser(userRepository.findOne(userRole.getUser().getId()));
        }
        return userRoleRepository.save(userRole1);
    }

    public void deleteUserRole(int id){

        userRoleRepository.delete(id);
    }
}
