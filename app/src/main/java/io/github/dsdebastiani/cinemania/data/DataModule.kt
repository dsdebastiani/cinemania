package io.github.dsdebastiani.cinemania.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.dsdebastiani.cinemania.data.movies.MovieRepository
import io.github.dsdebastiani.cinemania.data.movies.MovieRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun provideDiscoveryRepository(repository: MovieRepositoryImpl): MovieRepository

}
