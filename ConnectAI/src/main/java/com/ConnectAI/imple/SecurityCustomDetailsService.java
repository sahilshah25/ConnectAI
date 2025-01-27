package com.ConnectAI.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ConnectAI.entities.User;
import com.ConnectAI.repo.UserRepo;

@Service
public class SecurityCustomDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          //load our user name
        return  userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("user not found exception" + username));
         
    }


}
