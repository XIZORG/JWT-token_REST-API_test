package com.javamaster.springsecurityjwt.dao;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
