package com.catalogue.ecommerce;

//import com.springSecurity.Practise.UserPrincipal;

import com.catalogue.ecommerce.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.catalogue.ecommerce.Entity.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private userRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findAllByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);
    }
}
