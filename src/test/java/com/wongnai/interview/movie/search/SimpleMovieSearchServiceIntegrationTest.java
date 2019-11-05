package com.wongnai.interview.movie.search;

import java.util.List;

import com.wongnai.interview.movie.BaseIntegrationTest;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieTestHelper;

public class SimpleMovieSearchServiceIntegrationTest extends BaseIntegrationTest {
	@Autowired
	private SimpleMovieSearchService searchService;

	@Test
	public void testFindSingleKeywordContainInTitle() {
		List<Movie> result = searchService.search("Glorious");

		assertGloriousMovieKeyword(result);
	}

	private void assertGloriousMovieKeyword(List<Movie> result) {
		Assert.assertThat(result.size(), Matchers.equalTo(7));
		Assert.assertThat(MovieTestHelper.toMovieNames(result),
				Matchers.hasItems("The Glorious Lady", "The Glorious Fool", "One Glorious Day", "One Glorious Night",
						"Glorious Betsy", "His Glorious Night",
						"Borat! Cultural Learnings of America for Make Benefit Glorious Nation of Kazakhstan"));

		List<String> actors = MovieTestHelper.findMatchedName(result, "His Glorious Night").getActors();
		Assert.assertThat(actors.size(), Matchers.equalTo(2));
		Assert.assertThat(actors, Matchers.hasItems("John Gilbert", "Catherine Dale Owen"));
	}

	@Test
	public void testPartialWordMustNotMatch() {
		List<Movie> result = searchService.search("Glorio");

		Assert.assertThat(result.size(), Matchers.equalTo(0));
	}

	@Test
	public void testFullMovieNameMustNotMatch() {
		List<Movie> result = searchService.search("The Glorious Lady");

		Assert.assertThat(result.size(), Matchers.equalTo(0));
	}

	@Test
	public void testMultiWordMustNotMatch() {
		List<Movie> result = searchService.search("Glorio Lady");

		Assert.assertThat(result.size(), Matchers.equalTo(0));
	}

	@Test
	public void testFindSingleKeywordContainInTitleWithCaseInsensitive() {
		List<Movie> result = searchService.search("glorious");

		assertGloriousMovieKeyword(result);
	}
}
