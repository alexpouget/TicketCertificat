package com.esgi.repository;


import com.esgi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex on 29/05/2016.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findRoleByName(String name);
}
