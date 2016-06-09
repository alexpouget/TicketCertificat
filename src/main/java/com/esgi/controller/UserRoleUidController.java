package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.UserRole;
import com.esgi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController

public class UserRoleUidController {

    @Autowired
    UserService userService;
    @Autowired
    AppUserDetailsService appUserDetailsService;

    @RequestMapping(method = RequestMethod.GET, value="/api/userRoleUid/{uid}")
    public List<UserRole> getUserRoleByUid(@PathVariable String uid){
        return userService.findOneUserRoleByUid(uid);
    }



}
