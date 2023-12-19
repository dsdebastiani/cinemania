package io.github.dsdebastiani.cinemania.features.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.dsdebastiani.cinemania.data.movies.Movie
import io.github.dsdebastiani.cinemania.data.movies.MovieRepository
import io.github.dsdebastiani.cinemania.features.movies.MoviesListUiState.Error
import io.github.dsdebastiani.cinemania.features.movies.MoviesListUiState.Loading
import io.github.dsdebastiani.cinemania.features.movies.MoviesListUiState.Success
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<MoviesListUiState>(Loading)
    val uiState: StateFlow<MoviesListUiState> = _uiState.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            _uiState.update { Loading }
            try {
                val result = movieRepository.discoverMovies()
                _uiState.update { Success(result) }
            } catch (e: Throwable) {
                _uiState.update { Error(e) }
            }
        }
    }
}

sealed interface MoviesListUiState {
    data object Loading : MoviesListUiState
    class Success(val data: List<Movie>) : MoviesListUiState
    class Error(val error: Throwable) : MoviesListUiState
}
