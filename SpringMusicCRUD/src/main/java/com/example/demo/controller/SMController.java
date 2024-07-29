package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Music;
import com.example.demo.form.MusicForm;
import com.example.demo.service.MusicService;

@Controller
public class SMController {

	@Autowired
	MusicService service;
	
	@GetMapping("index")
	public String indexView() {
		return "index";
	}
	
	@PostMapping(value="menu",params="select")
	public String listView(Model model) {
		Iterable<Music> list = service.findAll();
		model.addAttribute("list",list);
		return "list";
	}
	
	@PostMapping(value="menu",params="insert")
	public String InsertView() {
		return "music-insert";
	}
	
	@PostMapping("insert")
	public String InsertConfirmView(MusicForm f) {
		Music music = new Music(f.getSong_id(),f.getSong_name(),f.getSinger());
		service.insert(music);
		return "music-insert-complete";
	}
	
	@PostMapping(value="menu",params="update")
	public String UpdateView(Model model) {
		Iterable<Music> list = service.findAll();
		model.addAttribute("list",list);
		return "music-update";
	}
	
	@PostMapping("update1")
	public String UpdateConfirmView1(MusicForm f,Model model) {
		Optional<Music> music = service.findbyId(f.getSong_id());
		model.addAttribute("music",music);
		return "music-update-form";
	}
	
	@PostMapping("update2")
	public String UpdateConfirmView2(MusicForm f) {
		Music music = new Music(f.getSong_id(),f.getSong_name(),f.getSinger());
		service.update(music);
		return "music-update-complete";
	}
	
	@PostMapping(value="menu",params="delete")
	public String DeleteView(Model model) {
		Iterable<Music> list = service.findAll();
		model.addAttribute("list",list);
		return "music-delete";
	}
	
	@PostMapping("delete")
	public String MusicDeleteConfirmView(MusicForm f) {
		service.delete(f.getSong_id());
		return "music-delete-complete";
	}
}
