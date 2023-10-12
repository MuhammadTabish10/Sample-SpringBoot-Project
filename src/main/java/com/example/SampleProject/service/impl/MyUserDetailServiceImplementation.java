package com.example.SampleProject.service.impl;

import com.example.SampleProject.dto.CustomUserDetail;
import com.example.SampleProject.model.User;
import com.example.SampleProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceImplementation implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new CustomUserDetail(user);
    }
}
