package com.spotify.user.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.spotify.user.entity.Playlist;
import com.spotify.user.service.PlaylistService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Playlist addUser(@RequestBody Playlist playlist) {
        return playlistService.savePlaylist(playlist);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) throws Exception {
        return playlistService.updatePlaylist(playlist, id);
    }

    @PatchMapping("/patch/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Playlist patchUser(@PathVariable Long id, @RequestBody Map<String, Object> playlist) throws Exception {
        return playlistService.patchUser(id, playlist);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Playlist> getPlaylists() {
        return playlistService.getPlaylists();
    }

    @GetMapping("/getByName/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Playlist getByName(@PathVariable String name) {
        return playlistService.getByName(name);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> deletePlaylist(@PathVariable Long id) {
        return playlistService.deletePlaylist(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Playlist getById(@PathVariable Long id) throws Exception {
        return playlistService.getById(id);
    }

}