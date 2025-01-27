package com.ConnectAI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.ConnectAI.imple.SecurityCustomDetailsService;

@Configuration
public class SecurityConfig {

    // @Bean
    // public InMemoryUserDetailsManager userDetails(){

    //   UserDetails user1=  User
    //   .withDefaultPasswordEncoder()
    //   .username ("sahilshah")
    //   .password("sahilshah")
    //   .roles("ADMIN","USER")
    //   .build();
    //  UserDetails user2= User.
    //   withDefaultPasswordEncoder()
    //   .username("sahilahmad")
    //   .password("sahilshah")
    //   .roles("ADMIN","USER")
    //   .build();

    // var inmemoryUserdatailManager =new InMemoryUserDetailsManager(user1,user2);
    // return  inmemoryUserdatailManager;
    // } 

     @Autowired
    private SecurityCustomDetailsService securityCustomDetailsService;

    //authentication of routes
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
      
     
    DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();

    //user detail service ka object
    daoAuthenticationProvider.setUserDetailsService(securityCustomDetailsService);

    //password encoder ka object
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
      return daoAuthenticationProvider;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

      //configure url ke konse public rahinge aur konse private
      httpSecurity.authorizeHttpRequests(authrize->{
        authrize.requestMatchers("/user/**").authenticated();
        authrize.anyRequest().permitAll();

      });

      //form default login
      //if we want any change so we come here related to form login
      httpSecurity.formLogin(Customizer.withDefaults());
     return httpSecurity.build();


    }

    @Bean
    public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    }
}
