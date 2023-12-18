package io.github.dsdebastiani.cinemania.core.network.responses.configuration


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class ConfigurationResponse(
    @Json(name = "images")
    val images: ImagesConfigResponse?,
    @Json(name = "change_keys")
    val changeKeys: List<String?>?
)
