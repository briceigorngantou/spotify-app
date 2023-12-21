package com.spotify.user.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spotify.user.entity.User;
import com.spotify.user.repository.UserRepository;

import main.java.com.spotify.user.dto.UserDTO;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    public User updateUser(User user, Long id) throws Exception {
        User currentUser = userRepository.findById(id).orElseThrow(Exception::new);
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        return userRepository.save(currentUser);
    }

    public ResponseEntity<String> deleteUser(Long idUser) {
        if (!this.userRepository.findById(idUser).isEmpty()) {
            userRepository.deleteById(idUser);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("user are deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resource not found");
    }

    public User patchUser(Long id, Map<String, Object> user) throws Exception {
        User currentUser = userRepository.findById(id).orElseThrow(Exception::new);
        if (user.containsKey("username")) {
            currentUser.setUsername(user.get("username").toString());
        }
        if (user.containsKey("email")) {
            currentUser.setUsername(user.get("email").toString());
        }
        return userRepository.save(currentUser);
    }

    public UserDTO getUserDTOById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(RuntimeException::new);
        if (user != null) {
            return new UserDTO(user.getUsername(), user.getEmail());
        }
        return null;
    }
}
