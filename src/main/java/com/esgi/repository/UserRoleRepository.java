package com.esgi.repository;

import com.esgi.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex on 29/05/2016.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
