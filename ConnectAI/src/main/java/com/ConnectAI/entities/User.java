package com.ConnectAI.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    private String name;

    @Column(unique = true,nullable = false)
    private String  email;
    @Column(nullable = false)
    private String password;
    private String phoneNumber;
    @Column(length = 500)
    private String about;
    private String profilePic;
    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneverified=false;


    //login platform information

    private Providers provider=Providers.SELF;
    private String providerUserId;
    

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts=new ArrayList<>();
     

    // @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    // private List<SocialLinks> links= new ArrayList<>();

}
