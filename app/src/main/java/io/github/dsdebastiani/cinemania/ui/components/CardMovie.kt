package io.github.dsdebastiani.cinemania.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.github.dsdebastiani.cinemania.data.movies.Movie
import io.github.dsdebastiani.cinemania.ui.theme.CineManiaTheme
import io.github.dsdebastiani.cinemania.ui.util.ImageSize.W154
import io.github.dsdebastiani.cinemania.ui.util.ImageUtil

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardMovie(
    movie: Movie,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier.fillMaxSize(3/2f),
    border = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.outline
    ),
) {

    AsyncImage(
        model = ImageUtil.getPosterUrl(movie.posterPath, W154),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        alignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
            .clip(MaterialTheme.shapes.small)
            .align(Alignment.CenterHorizontally)
    )
    Text(
        text = movie.title ?: movie.originalTitle ?: "",
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .basicMarquee(),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Spacer(modifier = Modifier.size(12.dp))
}


@Preview(showBackground = true, backgroundColor = 0xFF141414)
@Composable
internal fun CardMoviePreview() {
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
        CardMovie(movie = movie, modifier = Modifier.padding(16.dp))
    }
}
