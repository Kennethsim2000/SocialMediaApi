package com.example.Demo.vo;

import java.util.Set;

import lombok.Data;

@Data
public class AccountVo {
    private String username;
    private String email;
    private Set<String> following;
    private Set<String> followers;
}
