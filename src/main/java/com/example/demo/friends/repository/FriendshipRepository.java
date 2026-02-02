package com.example.demo.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.friends.entity.Friends;
import com.example.demo.friends.entity.FriendshipStatus;

public interface FriendshipRepository extends JpaRepository<Friends, Long> {
    @Query("""
    SELECT f FROM Friends f
    WHERE (f.user.id = :userId
       OR f.friend.id = :userId)
       AND f.status = :status
    """)
    List<Friends> findFriendsByStatus(@Param("userId") Long userId, @Param("status") FriendshipStatus status);
}
