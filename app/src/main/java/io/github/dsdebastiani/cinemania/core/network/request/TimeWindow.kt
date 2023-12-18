package io.github.dsdebastiani.cinemania.core.network.request

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = false)
enum class TimeWindow(private val value:String) {
   @Json(name = "day")
    DAY("day"),
    @Json(name = "week")
    WEEK("week");

    override fun toString(): String {
        return value
    }
}
