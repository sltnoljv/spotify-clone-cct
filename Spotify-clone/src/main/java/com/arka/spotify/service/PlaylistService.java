package com.arka.spotify.service;

import java.util.List;
import java.util.Optional;


import com.arka.spotify.model.Playlist;

public interface PlaylistService {

	public List<Playlist> getAll1();

	public Playlist add(Playlist playlist);

	public Playlist update(Playlist playlist) throws Exception;

	public Playlist delete(long id);

	public Optional<Playlist> getPlaylistById(long id);
	
	public Boolean isDuplicate(String artistName);

	}
