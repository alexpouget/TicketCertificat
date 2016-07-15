package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;

import com.esgi.entity.User;
import com.esgi.entity.UserRole;
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
@RequestMapping(value="/api/userRole")
public class UserRoleController {

    @Autowired
    UserService userService;
    @Autowired
    AppUserDetailsService appUserDetailsService;


    @RequestMapping(method = RequestMethod.GET)
    public List<UserRole> getUserRole(){
        return userService.findAllUserRole();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public UserRole getUserRole(@PathVariable int id){
        return userService.findOneUserRole(id);
    }
/*
    @RequestMapping(method = RequestMethod.GET, value="/api/userRole"+"/role/{id}")
    public List<UserRole> getUserRoleByRole(@PathVariable int id){
        return userService.findOneUserRoleByRole(id);
    }
*/
    @RequestMapping(method = RequestMethod.POST)
    public UserRole addUsers(@RequestBody UserRole userRole){
        return userService.newUserRole(userRole);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public UserRole updateUsers(@PathVariable int id,@RequestBody UserRole userRole){
        return userService.updateUserRole(userRole);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteUsers(@PathVariable int id){
        userService.deleteUserRole(id);
    }

}
