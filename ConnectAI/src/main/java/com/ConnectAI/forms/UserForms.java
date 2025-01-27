package com.ConnectAI.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForms {
    @NotBlank(message = "name is required")
    @Size(min = 3,max = 10,message = "minimum 3 and maximum 20 character are allowed")
    private String name;
    @Email(message = "email is invalid")
    private String email;
    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "about is required")
    private String about;
    
    @Size(min = 10,max =10, message = "10 digit are required " )
    private String phoneNumber;

}
