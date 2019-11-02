package com.wongnai.interview.movie.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wongnai.interview.movie.external.MovieSearchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieSearchService;

@Component("simpleMovieSearchService")
public class SimpleMovieSearchService implements MovieSearchService {

	private static Map<String, List<Movie>> searchData = new HashMap<>();

	@Autowired
	private MovieSearchDataService movieSearchDataService;

	@Override
	public List<Movie> search(String queryText) {
		//TODO: Step 2 => Implement this method by using data from MovieDataService
		// All test in SimpleMovieSearchServiceIntegrationTest must pass.
		// Please do not change @Component annotation on this class
		Map<String, Set<Movie>> movieSearchData = movieSearchDataService.getSearchData();
		Set<Movie> movies = movieSearchData.get(queryText.toLowerCase());
		if (movies == null || movies.isEmpty()) {
			return Collections.emptyList();
		}
		return new ArrayList<>(movies);
	}
}
