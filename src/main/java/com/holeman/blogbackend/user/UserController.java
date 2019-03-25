package com.holeman.blogbackend.user;

import com.holeman.blogbackend.auth.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "아이디 또는 패스워드가 잘못 되었습니다.");

        if (logout != null)
            model.addAttribute("message", "로그아웃 되었습니다.");

        return new ModelAndView("login");
    }

    @GetMapping("/checkLogin")
    public ResponseEntity<?> checkLogin(HttpSession httpSession){
        if(httpSession == null || httpSession.getAttribute("logged") == null){
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
