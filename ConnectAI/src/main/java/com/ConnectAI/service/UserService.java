package com.ConnectAI.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.ConnectAI.entities.User;


@Service
public interface UserService {

   User saveUser(User user);
   Optional<User> getUserById(String id);
   Optional<User> updateUser(User user);
   void deleteUser(String id);
   boolean isUserExists(String UserId);
   boolean isUserExistsbyEmail(String email);

   List<User> getAllUsers();


}
