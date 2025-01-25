package com.example.Demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class AccountVo {
    private String username;
    private String email;
    private List<String> following;
    private List<String> followers;
}
