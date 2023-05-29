package com.arka.spotify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.arka.spotify.model.Song;

@Component
public interface SongService {

	public List<Song> getAll();

	public Song add(Song song);

	public Song update(Song song) throws Exception;

	public Song delete(long id);

	public Optional<Song> getSongById(long id);
	
	public Boolean isDuplicate(String songName);
	}
