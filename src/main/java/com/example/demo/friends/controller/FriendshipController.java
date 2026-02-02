package com.example.demo.friends.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.friends.dto.AddFriendRequest;
import com.example.demo.friends.dto.AddFriendResponse;
import com.example.demo.friends.dto.FriendResponse;
import com.example.demo.friends.entity.FriendshipStatus;
import com.example.demo.friends.service.FriendshipService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users/{userId}/friends")
public class FriendshipController {

    private final FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @GetMapping("/accepted")
    public List<FriendResponse> getAllFriends(@PathVariable Long userId) {
        return friendshipService.getAllFriendsByStatus(userId, FriendshipStatus.ACCEPTED);
    }

    @GetMapping("/pending")
    public List<FriendResponse> getAllPendingFriends(@PathVariable Long userId) {
        return friendshipService.getAllFriendsByStatus(userId, FriendshipStatus.PENDING);
    }

    @GetMapping("/blocked")
    public List<FriendResponse> getAllBlockedFriends(@PathVariable Long userId) {
        return friendshipService.getAllFriendsByStatus(userId, FriendshipStatus.BLOCKED);
    }

    @GetMapping("/rejected")
    public List<FriendResponse> getAllRejectedFriends(@PathVariable Long userId) {
        return friendshipService.getAllFriendsByStatus(userId, FriendshipStatus.REJECTED);
    }

    @PostMapping("/add")
    public AddFriendResponse addFriend(@RequestBody AddFriendRequest request) {
        request.setRequestedAt(LocalDateTime.now());
        return friendshipService.addFriend(request);
    }

    @PutMapping("/{friendshipId}/accept")
    public String acceptFriend(
            @PathVariable Long userId,
            @PathVariable Long friendshipId
    ) {
        return "Friendship accepted";
    }
}

