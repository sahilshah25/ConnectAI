package com.ConnectAI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetails(){

      UserDetails user1=  User
      .withDefaultPasswordEncoder()
      .username ("sahilshah")
      .password("sahilshah")
      .roles("ADMIN","USER")
      .build();
     UserDetails user2= User.
      withDefaultPasswordEncoder()
      .username("sahilahmad")
      .password("sahilshah")
      .roles("ADMIN","USER")
      .build();

    var inmemoryUserdatailManager =new InMemoryUserDetailsManager(user1,user2);
    return  inmemoryUserdatailManager;
    }

}
