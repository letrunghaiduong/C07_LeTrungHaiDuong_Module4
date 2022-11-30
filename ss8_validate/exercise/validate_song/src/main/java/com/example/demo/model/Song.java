package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotEmpty(message = "Không được để trống")
//    @Size(max = 800,message = "Không được quá 800 ký tự")
//    @Pattern(regexp = "^([A-Z0-9][a-z0-9]+[ ])+([A-Z0-9][a-z0-9]+)$", message = "{invalid}")
    private String name;

//    @NotEmpty(message = "Không được để trống")
//    @Size(max = 300,message = "Không được quá 300 ký tự")
//    @Pattern(regexp = "^([A-Z0-9][a-z0-9]+[ ])+([A-Z0-9][a-z0-9]+)$", message = "{invalid}")
    private String artist;

//    @NotEmpty(message = "Không được để trống")
//    @Size(max = 1000,message = "Không được quá 1000 ký tự")
//    @Pattern(regexp = "^([A-Z0-9][a-z0-9]+[ ])+([A-Z0-9][a-z0-9]+)$", message = "{invalid}")
    private String kindOfMusic;

    public Song(String name, String artist, String kindOfMusic) {
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public Song() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
