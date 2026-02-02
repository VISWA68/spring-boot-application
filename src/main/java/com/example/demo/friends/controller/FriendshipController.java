package com.example.demo.friends.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.friends.dto.FriendResponse;
import com.example.demo.friends.service.FriendshipService;

@RestController
@RequestMapping("/{id}")
public class FriendshipController {

    private final FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @GetMapping("/friends/all")
    public List<FriendResponse> getAllFriends(@PathVariable Long id) {
        return friendshipService.getAllFriendsOfUser(id);
    }

    @PostMapping("/friends/add")
    public String addFriend(@PathVariable Long id) {
        // Implementation for adding a friend would go here
        return "Add friend functionality is not implemented yet.";
    }
}
