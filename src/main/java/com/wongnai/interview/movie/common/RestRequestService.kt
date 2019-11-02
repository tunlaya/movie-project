package com.wongnai.interview.movie.common

interface RestRequestService {
    fun <T> getForObject(url: String, clazz: Class<T>): T?
}