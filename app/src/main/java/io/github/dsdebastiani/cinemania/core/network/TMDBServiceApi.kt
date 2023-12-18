package io.github.dsdebastiani.cinemania.core.network

import io.github.dsdebastiani.cinemania.core.network.resonses.DiscoverMoviesResponse
import retrofit2.http.GET

interface TMDBServiceApi {

    @GET("discover/movie")
    suspend fun discoverMovies(): DiscoverMoviesResponse
}
