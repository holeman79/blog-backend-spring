package com.holeman.blogbackend.auth;

import lombok.Data;

@Data
public class LoginUser {
    private String loginId;
    private String password;
}
