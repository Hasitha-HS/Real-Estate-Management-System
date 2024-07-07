package com.dea.PropertySphere.Service;

import com.dea.PropertySphere.Model.LoginCreds;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class LoginCredsDetails implements UserDetails {

    private String email;
    private int id;
    private String password;
//    private List<GrantedAuthority> authorities;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginCredsDetails(LoginCreds loginCreds) {
        id=loginCreds.getUserid();
        email = loginCreds.getEmail();
        password = loginCreds.getPassword();
//        authorities = Arrays.stream(userInfo.getRoles().split("",""))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
    }


}
