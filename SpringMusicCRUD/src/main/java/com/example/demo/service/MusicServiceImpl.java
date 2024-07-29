package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Music;
import com.example.demo.repository.MusicCrudRepository;

@Service
public class MusicServiceImpl implements MusicService {
	@Autowired
	MusicCrudRepository repository;

	@Override
	public Iterable<Music> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findAll();
	}

	@Override
	public void insert(Music music) {
		// TODO 自動生成されたメソッド・スタブ
		repository.save(music);
	}

	@Override
	public void delete(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteById(id);
	}

	@Override
	public void update(Music music) {
		// TODO 自動生成されたメソッド・スタブ
		repository.save(music);
	}

	@Override
	public Optional<Music> findbyId(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findById(id);
	}

	

}
