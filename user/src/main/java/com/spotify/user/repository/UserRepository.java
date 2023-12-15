package com.spotify.user.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spotify.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    Optional<User> findById(Long id);

    List<User> findAll();

    @Modifying
    @Query("update User u set u.username = ?1 where u.id = ?2")
    int setFixedFirstnameFor(String firstname, Long id);
}
