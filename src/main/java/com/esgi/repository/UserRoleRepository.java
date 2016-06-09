package com.esgi.repository;

import com.esgi.entity.Role;
import com.esgi.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by alex on 29/05/2016.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {

    @Query("select a from UserRole a where a.role.id=:id")
    List<UserRole> getAllByRole(@Param("id") Integer id);

    @Query("select a from UserRole a where a.user.uid=:uid")
    List<UserRole> getAllByUser(@Param("uid") String uid);
}
