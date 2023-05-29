package com.arka.spotify.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.arka.spotify.model.Playlist;
import com.arka.spotify.service.PlaylistService;
import com.arka.spotify.repository.*;

@Service

public class playlistServiceImpl implements PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistRepository;

	
	@Override
	public List<Playlist> getAll1() {
		return this.playlistRepository.findAll();
	}

	
	@Override
	public Playlist add(Playlist song) {
		return this.playlistRepository.save(song);
	}


	@Override
	public Playlist update(Playlist playlist) throws Exception {
		Playlist repPlaylist = new Playlist();
		try {
        repPlaylist.setPlaylistName(playlist.getPlaylistName());
        repPlaylist.setDescription(playlist.getDescription());
        return this.playlistRepository.save(repPlaylist);
		}
		catch(Exception e)
		{
		  throw new Exception(e);	
		}
}

	
	@Override
	public Playlist delete(long id) {
		this.playlistRepository.deleteById(id);
		return playlistRepository.getById(id);
	}

	
	@Override
	public Optional<Playlist> getPlaylistById(long id) {
		return this.playlistRepository.findById(id);
	}
	
	@Override
	public Boolean isDuplicate(String artistName)
	{
		List<Playlist> allPlaylist = getAll1();
		Set<String> allPlaylistNames = allPlaylist.stream().map(Playlist :: getPlaylistName).collect(Collectors.toSet());
        if(allPlaylistNames.add(artistName)==false)
        {
        	return true;
        }
        return false;
	}
}