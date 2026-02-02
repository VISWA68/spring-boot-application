package com.example.demo.friends.dto;

import java.time.LocalDateTime;

public class AddFriendRequest {
    
    private Long userId;
    private Long friendId;
    private LocalDateTime requestedAt;

    public AddFriendRequest(Long userId, Long friendId, LocalDateTime requestedAt){
        this.userId = userId;
        this.friendId = friendId;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }   
}
