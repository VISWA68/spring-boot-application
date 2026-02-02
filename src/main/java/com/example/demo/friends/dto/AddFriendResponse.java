package com.example.demo.friends.dto;

import java.time.LocalDate;

import com.example.demo.friends.entity.FriendshipStatus;

public class AddFriendResponse {
    
    private long requestId;
    private FriendshipStatus status;
    private LocalDate requestedAt;

    public AddFriendResponse(long requestId, FriendshipStatus status, LocalDate requestedAt){
        this.requestId = requestId;
        this.status = status;
        this.requestedAt = requestedAt;
    }

    public long getRequestId() {
        return requestId;
    }

    public FriendshipStatus getStatus() {
        return status;
    }

    public LocalDate getRequestedAt() {
        return requestedAt;
    }

}
