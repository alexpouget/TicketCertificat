package com.esgi.repository;

import com.esgi.entity.Role;
import com.esgi.entity.User;
import com.esgi.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * Created by alex on 29/05/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    @Query("select ur.role from UserRole ur where ur.user.id=:id")
    List<Role> getRoles(@Param("id") int id);

    @Query("select ur.role from UserRole ur where ur.user.uid=:uid and ur.user.password=:password")
    List<Role> getRoles(@Param("uid") String uid,@Param("password") String password);

    User findUserByUid(String uid);
}
