package io.github.dsdebastiani.cinemania.data.movies

import io.github.dsdebastiani.cinemania.core.IoDispatcher
import io.github.dsdebastiani.cinemania.core.network.TMDBServiceApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: TMDBServiceApi,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) : MovieRepository {
    override suspend fun discoverMovies(): List<Movie> = withContext(coroutineDispatcher) {
        apiService.trendingMovies().results?.map { it.toMovie() } ?: emptyList()
    }
}
