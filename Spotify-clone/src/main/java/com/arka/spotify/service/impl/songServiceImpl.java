package com.arka.spotify.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.arka.spotify.model.Song;
import com.arka.spotify.service.SongService;
import com.arka.spotify.repository.*;

@Service

public class songServiceImpl implements SongService {
	
	@Autowired
	private songRepository songRepository;

	
	@Override
	public List<Song> getAll() {
		return this.songRepository.findAll();
	}

	
	@Override
	public Song add(Song song) {
		return this.songRepository.save(song);
	}


	@Override
	public Song update(Song song) throws Exception {
		Song repSong = new Song();
		try {
        repSong.setSongId(song.getSongId());
        repSong.setSongName(song.getSongName());
        repSong.setGenre(song.getGenre());
        repSong.setSongDuration(song.getSongDuration());
        repSong.setArtistName(song.getArtistName());

		return this.songRepository.save(repSong);
		}
		catch(Exception e)
		{
		  throw new Exception(e);	
		}
}

	
	@Override
	public Song delete(long id) {
		this.songRepository.deleteById(id);
		return songRepository.getById(id);
	}

	
	@Override
	public Optional<Song> getSongById(long id) {
		return this.songRepository.findById(id);
	}
	
    @Override
    public Boolean isDuplicate(String songName)
    {
    	List<Song> allSongs = getAll();
    	Set<String> allSongNames = allSongs.stream().map(Song::getSongName).collect(Collectors.toSet());
        	if(allSongNames.add(songName)==false)
        	{
        		return true; 
        	}
    	return false;
    }
}