package com.spotify.user.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spotify.user.entity.Playlist;
import com.spotify.user.repository.PlaylistRepository;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository PlaylistRepository) {
        this.playlistRepository = PlaylistRepository;
    }

    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getByName(String name) {
        return playlistRepository.findByName(name);
    }

    public Playlist getById(Long id) throws Exception {
        return playlistRepository.findById(id).orElseThrow(Exception::new);
    }

    public Playlist updatePlaylist(Playlist playlist, Long id) throws Exception {
        Playlist currentPlaylist = playlistRepository.findById(id).orElseThrow(Exception::new);
        currentPlaylist.setName(playlist.getName());
        currentPlaylist.setCreatedAt(playlist.getCreatedAt());
        currentPlaylist.setUpdatedAt(playlist.getUpdatedAt());
        return playlistRepository.save(currentPlaylist);
    }

    public ResponseEntity<String> deletePlaylist(Long idPlaylist) {
        if (!playlistRepository.findById(idPlaylist).isEmpty()) {
            playlistRepository.deleteById(idPlaylist);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("playlist are deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resource not found");
    }

    /**
     * @param id
     * @param playlist
     * @return
     * @throws Exception
     */
    public Playlist patchUser(Long id, Map<String, Object> playlist) throws Exception {
        Playlist currentPlaylist = playlistRepository.findById(id).orElseThrow(null);
        if (playlist.containsKey("name")) {
            currentPlaylist.setName((playlist.get("name").toString()));
        }
        return playlistRepository.save(currentPlaylist);
    }
}
