package com.dea.PropertySphere.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_creds")
public abstract class LoginCreds {

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    private int userid;
    private String email;
    private String password;

    public abstract boolean isAccountNonExpired();

    public abstract boolean isAccountNonLocked();

    public abstract boolean isCredentialsNonExpired();

    public abstract boolean isEnabled();
}
