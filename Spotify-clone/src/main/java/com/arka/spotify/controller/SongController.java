package com.arka.spotify.controller;

import com.arka.spotify.model.Playlist;
import com.arka.spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arka.spotify.model.Song;
import com.arka.spotify.service.SongService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class SongController {

	
	@Autowired
	SongService songService;
	PlaylistService playlistService;

	@GetMapping("/songs")
	public List<Song> getAll() {
		return songService.getAll();
	}



	//Creating a new song
	@PostMapping("/song")
	public ResponseEntity<Song> createSong(@RequestBody Song song) {
		try {
		    if(songService.isDuplicate(song.getSongName()))
		    {
		    	return new ResponseEntity<>(HttpStatus.CONFLICT);
		    }
			    Song _song = this.songService.update(song);
			    return new ResponseEntity<>(_song, HttpStatus.CREATED);
			}
			catch(Exception e)
			{
            	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} 
	 
	}





