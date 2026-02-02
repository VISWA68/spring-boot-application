package com.example.demo.friends.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.friends.dto.AddFriendRequest;
import com.example.demo.friends.dto.AddFriendResponse;
import com.example.demo.friends.dto.FriendResponse;
import com.example.demo.friends.entity.Friends;
import com.example.demo.friends.entity.FriendshipStatus;
import com.example.demo.friends.repository.FriendshipRepository;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;

@Service
public class FriendshipService {

    private final FriendshipRepository friendshipRepository;
    private final UserRepository userRepository;

    public FriendshipService(FriendshipRepository friendshipRepository, UserRepository userRepository) {
        this.friendshipRepository = friendshipRepository;
        this.userRepository = userRepository;
    }

    public List<FriendResponse> getAllFriendsByStatus(Long currentUserId, FriendshipStatus status) {

        List<Friends> friendships =
                friendshipRepository.findFriendsByStatus(currentUserId, status);

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

    public AddFriendResponse addFriend(AddFriendRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User friend = userRepository.findById(request.getFriendId())
                .orElseThrow(() -> new RuntimeException("Friend not found"));

        Friends friendship = new Friends();
        friendship.setUser(user);
        friendship.setFriend(friend);
        friendship.setStatus(FriendshipStatus.PENDING);

        Friends saved = friendshipRepository.save(friendship);

        return new AddFriendResponse(
                saved.getId(),
                saved.getStatus(),
                LocalDate.now()
        );

    }

    public void updateFriendshipStatus(
            Long friendshipId,
            FriendshipStatus newStatus
    ) {
        Friends friendship = friendshipRepository.findById(friendshipId)
                .orElseThrow(() -> new RuntimeException("Friendship not found"));

        friendship.setStatus(newStatus);

        friendshipRepository.save(friendship);
    }
}
