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
import com.example.demo.friends.service.FriendshipService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public AddFriendResponse addFriend(@RequestBody AddFriendRequest request) {
        request.setRequestedAt(LocalDateTime.now());
        return friendshipService.addFriend(request);
    }

    @PutMapping("/friends/update-status")
    public String updateFriendshipStatus(@PathVariable String id) {
        // Implementation for updating friendship status would go here
        return "Update friendship status functionality is not implemented yet.";
    }
}
