package com.wongnai.interview.movie.common

object CommonUtil {
    fun spiltSpace(term: String): List<String> = term.split("\\s".toRegex())
}