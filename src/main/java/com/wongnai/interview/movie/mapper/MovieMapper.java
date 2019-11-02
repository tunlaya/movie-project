package com.wongnai.interview.movie.mapper;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.external.MovieData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {
    @Mapping(source = "title", target = "name")
    @Mapping(source = "cast", target = "actors")
    Movie movieDataToMovie(MovieData movieData);
}
