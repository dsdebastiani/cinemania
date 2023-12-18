package io.github.dsdebastiani.cinemania.core.network.resonses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class DiscoverMoviesResponse(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: List<MovieResponse>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
)
