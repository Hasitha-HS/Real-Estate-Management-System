package com.dea.PropertySphere.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginCreds {

    @Id
    private int userid;
    private String email;
    private String password;


}
