package com.dea.PropertySphere.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_creds")
public class LoginCreds {

    @Id
    int userid;
    String email;
    String password;

}
