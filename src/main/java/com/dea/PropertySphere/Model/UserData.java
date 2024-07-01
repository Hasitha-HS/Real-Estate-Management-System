package com.dea.PropertySphere.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "user_data")
public class UserData {
    @Id
    int userid;
    String firstName;
    String lastName;
    Date birthDate;
    String email;
    String address;
}
