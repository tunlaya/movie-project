package com.wongnai.interview.movie.sync;

import javax.transaction.Transactional;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.external.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.MovieRepository;

import java.util.List;

@Component
public class MovieDataSynchronizer {
	@Autowired
	private MovieService movieService;

	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public void forceSync() {
		//TODO: implement this to sync movie into repository
		List<Movie> movies = movieService.getMovies();
		movieRepository.saveAll(movies);
	}
}
