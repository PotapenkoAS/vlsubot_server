package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.commonObject.CustomUserDetails;
import com.example.vlsubot_1_0.model.entity.User;
import com.example.vlsubot_1_0.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository ur;

    @Autowired
    public CustomUserDetailsService(UserRepository ur) {
        this.ur = ur;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user;
        try {
            if ((user = ur.findByLogin(username)) != null) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
                return new CustomUserDetails(user.getLogin(), "{noop}" + user.getPassword(), true, true, true
                        , true, authorities, user.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UsernameNotFoundException(username);
    }
}