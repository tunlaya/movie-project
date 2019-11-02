package com.wongnai.interview.movie.external

import com.wongnai.interview.movie.Movie

interface MovieService {
    fun getSearchData(): Map<String, Set<Movie>>
    fun getMovies(): List<Movie>
    fun getInvertedIndexSearchData(): Map<String, List<Long>>
}