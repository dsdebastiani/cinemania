package io.github.dsdebastiani.cinemania.core.network

import io.github.dsdebastiani.cinemania.core.network.request.TimeWindow
import io.github.dsdebastiani.cinemania.core.network.request.TimeWindow.DAY
import io.github.dsdebastiani.cinemania.core.network.responses.MovieResponse
import io.github.dsdebastiani.cinemania.core.network.responses.PageResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBServiceApi {

    /**
     * Get the trending movies on TMDB.
     * A single call to get the most trending movies on the entirety of TMDB.
     *
     * @param timeWindow Defines the period of trending window. Default "day"
     * @param language ISO-3166 language code. Default "en-US"
     */
    @GET("trending/movie/{time_window}")
    suspend fun trendingMovies(
        @Path("time_window") timeWindow: TimeWindow = DAY,
        @Query("language") language: String? = null
    ) : PageResponse<MovieResponse>

}
