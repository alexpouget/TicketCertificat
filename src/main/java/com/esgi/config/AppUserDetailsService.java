package com.esgi.config;

import com.esgi.entity.User;
import com.esgi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by alex on 29/05/2016.
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByUid(s);

        if(user == null){
            throw new UsernameNotFoundException("l'uid : "+ s + "est inexistant");
        }
        return new AppUserDetails(user,userRepository);
    }

}
