package com.wongnai.interview.movie.external

import com.wongnai.interview.movie.Movie
import com.wongnai.interview.movie.mapper.MovieMapper
import org.springframework.stereotype.Component

@Component
class MovieSearchDataServiceImpl(
    private val movieDataService: MovieDataService,
    private val movieMapper: MovieMapper
) : MovieSearchDataService {

    companion object {
        val movieSearchData = mutableMapOf<String, MutableSet<Movie>>()
    }

    override fun getSearchData(): Map<String, Set<Movie>> {
        if (movieSearchData.isNotEmpty()) {
            return movieSearchData
        }

        val moviesResponse = movieDataService.fetchAll()
        moviesResponse.forEach { movieData ->
            val movie = movieMapper.movieDataToMovie(movieData)
            val words = movie.name.split("\\s".toRegex())
            words.forEach { word ->
                putMovieSearchData(word.toLowerCase(), movie)
            }
        }
        return movieSearchData
    }

    private fun putMovieSearchData(word: String, movie: Movie) {
        if (movieSearchData[word].isNullOrEmpty()) {
            movieSearchData[word] = mutableSetOf(movie)
        } else {
            movieSearchData[word]?.add(movie)
        }
    }
}