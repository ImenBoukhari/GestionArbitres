package com.example.GestionArbitre.payload;

import lombok.Data;

@Data
public class Login {
    private String usernameOrEmail;
    private String password;
    
}
