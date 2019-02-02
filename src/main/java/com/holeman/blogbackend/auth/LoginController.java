package com.holeman.blogbackend.auth;

import com.holeman.blogbackend.user.User;
import com.holeman.blogbackend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginUser loginUser){
        User user = userService.getUser(loginUser.getId());
        if(user == null) return
        return "users/loginform";
    }
}
