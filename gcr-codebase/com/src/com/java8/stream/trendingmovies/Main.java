package com.java8.stream.trendingmovies;

import java.util.*;
import java.util.stream.*;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {

        List<Movie> movies = List.of(
            new Movie("Movie A", 8.9, 2023),
            new Movie("Movie B", 7.5, 2021),
            new Movie("Movie C", 9.2, 2024),
            new Movie("Movie D", 8.1, 2019),
            new Movie("Movie E", 8.7, 2022),
            new Movie("Movie F", 9.0, 2023),
            new Movie("Movie G", 7.9, 2020)
        );

        movies.stream()
              .filter(m -> m.getReleaseYear() >= 2020)   // recent movies
              .sorted(Comparator.comparing(Movie::getRating).reversed())
              .limit(5)                                  // top 5
              .forEach(System.out::println);
    }
}
