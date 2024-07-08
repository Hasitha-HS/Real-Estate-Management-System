package com.dea.PropertySphere.Controller;

import com.dea.PropertySphere.Model.AuthRequest;
import com.dea.PropertySphere.Model.LoginCreds;
import com.dea.PropertySphere.Service.JwtService;
import com.dea.PropertySphere.Service.LoginCredsDetails;
import com.dea.PropertySphere.Service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class LoginController {

        @Autowired
        private UserDetailServiceImpl userDetailService;

        @Autowired
        private JwtService jwtService;

        @Autowired
        private AuthenticationManager authenticationManager;

        @GetMapping("/welcome")
        public String welcome() {
            return "Welcome, this endpoint is not secure";
        }

        @PostMapping("/addNewUser")
        public String addNewUser(@RequestBody LoginCreds loginCreds) {
            return userDetailService.addUser(loginCreds);
        }

        @GetMapping("/user/userProfile")
//        @PreAuthorize("hasAuthority('ROLE_USER')")
        public String userProfile() {
            return "Welcome to User Profile";
        }

        @GetMapping("/admin/adminProfile")
//        @PreAuthorize("")
        public String adminProfile() {
            return "Welcome to Admin Profile";
        }

        @PostMapping("/generateToken")
        public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(authRequest.getEmail());
            } else {
                throw new UsernameNotFoundException("Invalid user request!");
            }
        }
    }


