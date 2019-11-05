package com.wongnai.interview.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> actors = new ArrayList<>();

	/**
	 * Required by JPA.
	 */
	public Movie() {
	}

	public Movie(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getActors() {
		return actors;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Movie movie = (Movie) o;
		return Objects.equals(id, movie.id) &&
				Objects.equals(name, movie.name) &&
				Objects.equals(actors, movie.actors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, actors);
	}
}
