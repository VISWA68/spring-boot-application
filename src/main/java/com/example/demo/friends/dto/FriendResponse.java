package com.example.demo.friends.dto;


public class FriendResponse {

    private Long userId;        // friend user id
    private String name;
    private String email;
    private String status;      // PENDING / ACCEPTED / BLOCKED

    public FriendResponse(Long userId, String name, String email, String status) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }
}
