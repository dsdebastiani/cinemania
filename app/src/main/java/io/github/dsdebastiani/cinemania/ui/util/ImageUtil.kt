package io.github.dsdebastiani.cinemania.ui.util

object ImageUtil {

    private const val BASE_URL = "https://image.tmdb.org/t/p/"

    fun getPosterUrl(
        path: String?,
        size: ImageSize
    ) : String? = path?.let { BASE_URL + size.value + it }
}

enum class ImageSize(val value: String) {
    W92("w92"),
    W154("w154"),
    W185("w185"),
    W342("w342"),
    W500("w500"),
    W780("w700"),
    ORIGINAL("original")
}
