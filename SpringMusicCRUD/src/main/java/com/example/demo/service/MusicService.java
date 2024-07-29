package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Music;

public interface MusicService {
	Iterable<Music> findAll();
	void insert(Music music);
	void delete(Integer id);
	void update(Music music);
	Optional<Music> findbyId(Integer id);
}
