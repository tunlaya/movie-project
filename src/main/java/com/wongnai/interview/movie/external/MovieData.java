package com.wongnai.interview.movie.external;

import java.util.List;
import java.util.Objects;

public class MovieData {
	private String title;
	private int year;
	private List<String> cast;
	private List<String> genres;

	public MovieData() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MovieData movieData = (MovieData) o;
		return year == movieData.year &&
				Objects.equals(title, movieData.title) &&
				Objects.equals(cast, movieData.cast) &&
				Objects.equals(genres, movieData.genres);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, year, cast, genres);
	}
}
