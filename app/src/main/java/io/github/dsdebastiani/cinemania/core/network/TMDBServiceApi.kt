package io.github.dsdebastiani.cinemania.core.network

import io.github.dsdebastiani.cinemania.core.network.request.TimeWindow
import io.github.dsdebastiani.cinemania.core.network.request.TimeWindow.DAY
import io.github.dsdebastiani.cinemania.core.network.responses.MovieResponse
import io.github.dsdebastiani.cinemania.core.network.responses.PageResponse
import io.github.dsdebastiani.cinemania.core.network.responses.configuration.ConfigurationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBServiceApi {

    /**
     * Query the API configuration details.
     * The data returned here in the configuration endpoint is designed to provide some of
     * the required information you'll need as you integrate our API. For example, you can get a
     * list of valid image sizes and the valid image address.
     **/
    @GET("configuration")
    suspend fun configuration() : ConfigurationResponse

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
