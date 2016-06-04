package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.User;
import com.esgi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AppUserDetailsService appUserDetailsService;

    @RequestMapping(value="/api/logout",method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
    }

    @RequestMapping(value="/api/login",method = RequestMethod.GET)
    public UserDetails getUserDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails)authentication.getPrincipal();
    }

    @RequestMapping(value="/api/user",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.findAllUser();
    }

    @RequestMapping(value="/api/user/{uid}",method = RequestMethod.GET)
    public User getUsers(@PathVariable String uid){
        return userService.findByUid(uid);
    }

    @RequestMapping(value="/api/user/connexion/{uid}",method = RequestMethod.GET)
    public User Connexion(@PathVariable String uid){
        return userService.findByUid(uid);
    }

    @RequestMapping(value="/api/user",method = RequestMethod.POST)
    public User addUsers(@RequestBody User user){
        return userService.newUser(user);
    }

    @RequestMapping(value="/api/user/{uid}",method = RequestMethod.PUT)
    public User updateUsers(@PathVariable int id,@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value="/api/user/{uid}",method = RequestMethod.DELETE)
    public void deleteUsers(@PathVariable int id){
        userService.deleteUser(id);
    }

}
