package com.example.demo.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
    
    @JsonProperty("userId")
    private Long userId;
    
    @JsonProperty("name")
    private String name;

    public LoginResponse(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
