package com.dea.PropertySphere.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class UserData {
    @Id
    int userid;
    String firstName;
    String lastName;
    Date birthDate;
    String email;
    String address;

}
