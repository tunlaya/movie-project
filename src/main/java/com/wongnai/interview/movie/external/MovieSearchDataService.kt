package com.wongnai.interview.movie.external

import com.wongnai.interview.movie.Movie

interface MovieSearchDataService {
    fun getSearchData(): Map<String, Set<Movie>>
}