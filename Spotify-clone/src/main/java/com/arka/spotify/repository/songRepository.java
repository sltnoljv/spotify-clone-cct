package com.arka.spotify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.arka.spotify.model.Song;

@Repository
public interface songRepository extends JpaRepository<Song, Long> {
	
}