package com.javamaster.springsecurityjwt.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class PostRequest {
    @NotEmpty
    private String title;

    private String content;

    private String authorLogin;
}
