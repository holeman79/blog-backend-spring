package com.holeman.blogbackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUser(Long userId){
        return userRepository.findById(userId).get();
    }

}
