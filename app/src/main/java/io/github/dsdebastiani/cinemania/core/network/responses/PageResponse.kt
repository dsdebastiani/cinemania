package io.github.dsdebastiani.cinemania.core.network.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class PageResponse<out T>(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: List<T>?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
)
