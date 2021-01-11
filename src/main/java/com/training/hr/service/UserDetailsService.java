package com.training.hr.service;

import com.training.hr.entity.User;
import com.training.hr.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDetailsService  implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(userName);
        if(null==user){
            throw new UsernameNotFoundException("Invalid Username or Password");
        } else

        return  new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),null);
    }
}
