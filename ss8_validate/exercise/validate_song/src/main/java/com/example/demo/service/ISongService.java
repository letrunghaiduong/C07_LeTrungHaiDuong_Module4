package com.example.demo.service;

import com.example.demo.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Optional findById(Integer id);
}
