package io.github.dsdebastiani.cinemania.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.github.dsdebastiani.cinemania.R
import io.github.dsdebastiani.cinemania.data.movies.Movie
import io.github.dsdebastiani.cinemania.ui.theme.CineManiaTheme
import io.github.dsdebastiani.cinemania.ui.util.ImageSize.W342
import io.github.dsdebastiani.cinemania.ui.util.ImageUtil

@Composable
fun FeaturedMovie(
    movie: Movie,
    modifier: Modifier = Modifier,
    onDetailsClick: (Int) -> Unit
) = Card(
    modifier = modifier
        .height(468.dp)
        .fillMaxWidth(),
    border = BorderStroke(
        width = 1.dp,
        brush = Brush.verticalGradient(
            0.5f to MaterialTheme.colorScheme.outline,
            1.0f to MaterialTheme.colorScheme.surfaceVariant
        )
    ),
) {
    Box(modifier = Modifier.fillMaxSize()) {
        GradientBox(
            0.5f to Color.Transparent,
            1.0f to MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = ImageUtil.getPosterUrl(movie.posterPath, W342),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.TopCenter,
                modifier = Modifier.matchParentSize()
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = movie.title ?: movie.originalTitle ?: "",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Button(
                onClick = { onDetailsClick(movie.id) }
            ) {
                Text(text = stringResource(id = R.string.watch_now_button))
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF141414)
@Composable
internal fun FeaturedMoviePreview() {
    val movie = Movie(
        adult = null,
        backdropPath = null,
        genreIds = listOf(),
        id = 4919,
        originalLanguage = null,
        originalTitle = "Avengers : Endgame",
        overview = null,
        popularity = null,
        posterPath = "https://image.tmdb.org/t/p/w342/1E5baAaEse26fej7uHcjOgEE2t2.jpg",
        releaseDate = null,
        title = "Avengers: Endgame",
        video = null,
        voteAverage = null,
        voteCount = null
    )
    CineManiaTheme {
        FeaturedMovie(movie = movie, modifier = Modifier.padding(16.dp)) {}
    }
}
