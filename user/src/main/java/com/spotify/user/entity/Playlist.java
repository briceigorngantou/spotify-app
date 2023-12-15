package com.spotify.user.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = true)
    private LocalDate createdAt;

    @Column(nullable = true)
    private LocalDate updatedAt;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Playlist() {

    }

    public Playlist(Long id, String name, String email, User user, LocalDate createdAt, LocalDate updatedAt) {
        this.user = user;
        this.setId(id);
        this.setName(name);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
