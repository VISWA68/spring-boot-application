package com.example.demo.friends.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.friends.dto.FriendResponse;
import com.example.demo.friends.entity.Friends;
import com.example.demo.friends.repository.FriendshipRepository;

@Service
public class FriendshipService {

    private final FriendshipRepository friendshipRepository;

    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public List<FriendResponse> getAllFriendsOfUser(Long currentUserId) {

        List<Friends> friendships =
                friendshipRepository.findAllByUserId(currentUserId);

        return friendships.stream()
                .map(friendship -> {

                    // 🔑 determine the other user
                    var friendUser =
                            friendship.getUser().getId().equals(currentUserId)
                                    ? friendship.getFriend()
                                    : friendship.getUser();

                    return new FriendResponse(
                            friendUser.getId(),
                            friendUser.getName(),
                            friendUser.getEmail(),
                            friendship.getStatus().name()
                    );
                })
                .toList();
    }
}
