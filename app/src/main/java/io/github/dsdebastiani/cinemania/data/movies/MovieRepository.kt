package io.github.dsdebastiani.cinemania.data.movies

interface MovieRepository {

    suspend fun discoverMovies(): List<Movie>
}
