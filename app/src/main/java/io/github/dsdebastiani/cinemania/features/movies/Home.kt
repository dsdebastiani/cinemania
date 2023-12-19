package io.github.dsdebastiani.cinemania.features.movies

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.dsdebastiani.cinemania.R.string
import io.github.dsdebastiani.cinemania.data.movies.Movie
import io.github.dsdebastiani.cinemania.features.movies.MoviesListUiState.Error
import io.github.dsdebastiani.cinemania.features.movies.MoviesListUiState.Loading
import io.github.dsdebastiani.cinemania.features.movies.MoviesListUiState.Success
import io.github.dsdebastiani.cinemania.ui.components.CardMovie
import io.github.dsdebastiani.cinemania.ui.components.ContentError
import io.github.dsdebastiani.cinemania.ui.components.ContentLoader
import io.github.dsdebastiani.cinemania.ui.components.FeaturedMovie

@Composable
fun HomeRoute(
    viewModel: MoviesViewModel = hiltViewModel(),
    onItemClick: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    HomeScreen(
        uiState = uiState,
        tryAgain = viewModel::loadMovies,
        onItemClick = onItemClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    uiState: MoviesListUiState,
    modifier: Modifier = Modifier,
    tryAgain: () -> Unit,
    onItemClick: (Int) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = stringResource(id = string.app_name))
            }, scrollBehavior = scrollBehavior)
        }
    ) {
        Crossfade(targetState = uiState, label = "") { currentState ->
            when (currentState) {
                is Loading -> ContentLoader(Modifier.fillMaxSize())
                is Success -> Content(
                    data = currentState.data,
                    modifier = Modifier.padding(it),
                    onItemClick = onItemClick
                )

                is Error -> ContentError(
                    modifier = Modifier.padding(it),
                    error = currentState.error,
                    tryAgain = tryAgain
                )
            }
        }
    }
}

@Composable
internal fun Content(
    data: List<Movie>,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit
) {
    val firstMovie: Movie = remember {
        data.first()
    }
    val list = remember {
        data.drop(1)
    }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        modifier = modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        item(firstMovie.id, span = { GridItemSpan(maxLineSpan) }) {
            FeaturedMovie(
                movie = firstMovie,
                onDetailsClick = onItemClick
            )
        }

        items(list, key = { it.id }) { movie ->
            CardMovie(
                movie = movie
            )
        }
    }
}
