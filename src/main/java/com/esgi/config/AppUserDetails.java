package com.esgi.config;

import com.esgi.entity.Role;
import com.esgi.entity.User;
import com.esgi.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alex on 29/05/2016.
 */
public class AppUserDetails implements UserDetails,Serializable {

    private User user;
    @JsonIgnore
    private UserRepository userRepository;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        for (Role r: userRepository.getRoles(user.getId())) {
            collection.add(new SimpleGrantedAuthority(r.getName()));
        }

        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public AppUserDetails() {
    }

    public AppUserDetails(User user, UserRepository userRepository) {
        this.user = user;
        this.userRepository = userRepository;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
