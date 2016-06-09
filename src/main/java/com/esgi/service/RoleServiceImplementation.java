package com.esgi.service;

import com.esgi.entity.Role;
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
public class RoleServiceImplementation implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.delete(id);
    }

    @Override
    public Role updateRole(Role role) {
        Role role1 = new Role();
        role1.setId(role.getId());
        role1.setName(role.getName());
        return roleRepository.save(role1);
    }

    @Override
    public Role newRole(Role role) {
        Role role1 = new Role();
        role1.setName(role.getName());
        return roleRepository.save(role1);
    }

    @Override
    public Role findOneRole(int id) {
        return roleRepository.findOne(id);
    }
}
