package com.wongnai.interview.movie.service

import com.wongnai.interview.movie.Movie

interface MovieService {
    fun getSearchData(): Map<String, Set<Movie>>
    fun getMovies(): List<Movie>
    fun getInvertedIndexSearchData(): Map<String, List<Movie>>
}