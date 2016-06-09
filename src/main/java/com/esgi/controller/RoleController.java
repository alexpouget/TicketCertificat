package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.Role;
import com.esgi.entity.UserRole;
import com.esgi.service.RoleService;
import com.esgi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController
@RequestMapping(value="/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    AppUserDetailsService appUserDetailsService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Role> getRole(){
        return roleService.findAllRole();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public Role getRole(@PathVariable int id){
        return roleService.findOneRole(id);
    }
/*
    @RequestMapping(method = RequestMethod.GET, value="/api/userRole"+"/role/{id}")
    public List<UserRole> getUserRoleByRole(@PathVariable int id){
        return userService.findOneUserRoleByRole(id);
    }
*/
    @RequestMapping(method = RequestMethod.POST)
    public Role addRole(@RequestBody Role role){
        return roleService.newRole(role);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public Role updateRole(@PathVariable int id,@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteRole(@PathVariable int id){
        roleService.deleteRole(id);
    }

}
