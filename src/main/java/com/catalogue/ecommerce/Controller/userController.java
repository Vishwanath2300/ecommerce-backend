package com.catalogue.ecommerce.Controller;


import com.catalogue.ecommerce.Entity.Users;
import com.catalogue.ecommerce.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController

public class userController {
    private class AuthResponse {
        private String token;

        // Constructor, getters, setters
        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
    @Autowired
    private userService userservice;

    @PostMapping("/register")

    public Users register(@RequestBody Users user) {
        return userservice.register(user);

    }

    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody Users user) {
        System.out.println(user);
        String token=userservice.verify(user);

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping("/secure-data")

    public ResponseEntity<?> getSecureData() {
        String data = "This is secured data accessible only to authenticated users.";
        return  ResponseEntity.ok(new AuthResponse(data));
    }
}
