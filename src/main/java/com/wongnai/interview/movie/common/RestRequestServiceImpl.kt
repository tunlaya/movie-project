package com.wongnai.interview.movie.common

import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.ArrayList

@Service
class RestRequestServiceImpl(
    private val restTemplate: RestTemplate
) : RestRequestService {
    override fun <T> getForObject(url: String, clazz: Class<T>): T {
        val messageConverters = ArrayList<HttpMessageConverter<*>>()
        val converter = MappingJackson2HttpMessageConverter()
        converter.supportedMediaTypes = listOf(MediaType.ALL)
        messageConverters.add(converter)
        restTemplate.messageConverters = messageConverters
        return restTemplate.getForObject(url, clazz)
    }

}