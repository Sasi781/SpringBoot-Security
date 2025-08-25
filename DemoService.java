package com.example.api.service;

import com.example.api.jwt.JWTService;
import com.example.api.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTService jwtService;

    public String verify(Users user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

//        System.out.println("Sasi here "+ authentication.isAuthenticated());
        if(authentication.isAuthenticated()){
            return jwtService.generateToken();
        }
        return "fail";
    }
}
