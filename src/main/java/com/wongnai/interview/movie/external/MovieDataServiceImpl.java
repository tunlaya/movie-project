package com.wongnai.interview.movie.external;

import com.wongnai.interview.movie.common.RestRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDataServiceImpl implements MovieDataService {
	private static final String MOVIE_DATA_URL
			= "https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json";

	@Autowired
	private RestRequestService restRequestService;

	@Override
	public MoviesResponse fetchAll() {
		//TODO:
		// Step 1 => Implement this method to download data from MOVIE_DATA_URL and fix any error you may found.
		// Please noted that you must only read data remotely and only from given source,
		// do not download and use local file or put the file anywhere else.
		return restRequestService.getForObject(MOVIE_DATA_URL, MoviesResponse.class);
	}
}
