package com.ConnectAI.imple;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ConnectAI.entities.User;
import com.ConnectAI.helper.ResourceNotFoundException;
import com.ConnectAI.repo.UserRepo;
import com.ConnectAI.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        //user id have to generate
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);
        //encode password here
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User usersaved=this.userRepo.save(user);
        return usersaved;
    }

    @Override
    public Optional<User> getUserById(String id) {
       return this.userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
     User user2= userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("user not found"));
     
     user2.setName(user.getName());
     user2.setAbout(user.getAbout());
     user2.setEmail(user.getEmail());
     user2.setPassword(user.getPassword());
     user2.setPhoneNumber(user.getPhoneNumber());
     user2.setProfilePic(user.getProfilePic());
     user2.setEnabled(true);
     user2.setEmailVerified(user.isEmailVerified());
     user2.setPhoneverified(user.isPhoneverified());
     user2.setProvider(user.getProvider());
     user2.setProviderUserId(user.getProviderUserId());

     User savedUser=userRepo.save(user2);

     return Optional.ofNullable(savedUser); 


    }

    @Override
    public void deleteUser(String id) {
        User user2= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found"));
         this.userRepo.delete(user2);
    }

    @Override
    public boolean isUserExists(String UserId) {
        User user2= userRepo.findById(UserId).orElseThrow(null);
        return user2!=null ? true:false;
    }

    @Override
    public boolean isUserExistsbyEmail(String email) {
      User user=this.userRepo.findByEmail(email).orElseThrow(null);
      return user!=null?true:false;
    }

    @Override
    public List<User> getAllUsers() {
       List<User> users=this.userRepo.findAll();
       return users;
    }

}
