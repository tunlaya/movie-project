package com.wongnai.interview.movie.external

import com.wongnai.interview.movie.Movie
import com.wongnai.interview.movie.MovieRepository
import com.wongnai.interview.movie.common.CommonUtil
import com.wongnai.interview.movie.mapper.MovieMapper
import org.springframework.stereotype.Component

@Component
class MovieServiceImpl(
    private val movieDataService: MovieDataService,
    private val movieMapper: MovieMapper,
    private val movieRepository: MovieRepository
) : MovieService {

    companion object {
        val movieSearchData = mutableMapOf<String, MutableSet<Movie>>()
        val invertedIndexMovieSearchData = mutableMapOf<String, MutableList<Long>>()
    }

    override fun getSearchData(): Map<String, Set<Movie>> {
        if (movieSearchData.isNotEmpty()) {
            return movieSearchData
        }

        val moviesResponse = movieDataService.fetchAll()
        moviesResponse.forEach { movieData ->
            val movie = movieMapper.movieDataToMovie(movieData)
            val words = CommonUtil.spiltSpace(movie.name)
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

    override fun getMovies(): List<Movie> {
        return movieDataService.fetchAll().map { movieMapper.movieDataToMovie(it) }
    }

    override fun getInvertedIndexSearchData(): Map<String, List<Long>> {
        if (invertedIndexMovieSearchData.isNotEmpty()) {
            return invertedIndexMovieSearchData
        }

        val movies = movieRepository.findAll()
        movies.forEach { movie ->
            val words = CommonUtil.spiltSpace(movie.name)
            words.forEach { word ->
                putInvertedIndexMovieSearchData(word.toLowerCase(), movie.id)
            }
        }
        return invertedIndexMovieSearchData
    }

    private fun putInvertedIndexMovieSearchData(word: String, id: Long) {
        if (invertedIndexMovieSearchData[word].isNullOrEmpty()) {
            invertedIndexMovieSearchData[word] = mutableListOf(id)
        } else {
            invertedIndexMovieSearchData[word]?.add(id)
        }
    }
}