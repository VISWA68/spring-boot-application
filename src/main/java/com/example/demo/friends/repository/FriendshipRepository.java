package com.example.demo.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.friends.entity.Friends;

public interface FriendshipRepository extends JpaRepository<Friends, Long> {
    @Query("""
    SELECT f FROM Friends f
    WHERE f.user.id = :userId
       OR f.friend.id = :userId
    """)
    List<Friends> findAllByUserId(@Param("userId") Long userId);
}
