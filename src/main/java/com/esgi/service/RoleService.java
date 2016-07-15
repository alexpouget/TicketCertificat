package com.esgi.service;

import com.esgi.entity.Role;
import com.esgi.entity.User;
import com.esgi.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface RoleService {

    List<Role> findAllRole();

    void deleteRole(int id);

    Role updateRole(Role role);

    Role newRole(Role role);

    Role findOneRole(int id);
}
