package com.ConnectAI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "social_links")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialLinks {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private String link;
    private String title;
    

    @ManyToOne
    
    private Contact contact;

}
