package com.dea.PropertySphere.Service;

import com.dea.PropertySphere.Model.LoginCreds;
import com.dea.PropertySphere.Repository.LoginCredsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    LoginCredsRepo loginCredsRepo;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<LoginCreds> loginCreds = loginCredsRepo.findByEmail(email);
        return loginCreds.map(LoginCredsDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User Doest exist"));
    }

    public String addUser(LoginCreds loginCreds) {
        loginCreds.setPassword(passwordEncoder.encode(loginCreds.getPassword()));
        loginCredsRepo.save(loginCreds);
        return "User Added Successfully";
    }

}
