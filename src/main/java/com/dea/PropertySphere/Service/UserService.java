package com.dea.PropertySphere.Service;


import com.dea.PropertySphere.Model.LoginCreds;
import com.dea.PropertySphere.Repository.LoginCredsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    LoginCredsRepo loginCredsRepo;

    LoginCreds login(int id,String password){
        if (loginCredsRepo.existsById(id)){

        }
    }
}
