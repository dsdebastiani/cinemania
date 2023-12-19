package io.github.dsdebastiani.cinemania.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.dsdebastiani.cinemania.R
import io.github.dsdebastiani.cinemania.R.drawable
import io.github.dsdebastiani.cinemania.ui.theme.CineManiaTheme
import okio.IOException

@Composable
fun ContentError(
    error: Throwable,
    modifier: Modifier = Modifier,
    tryAgain: () -> Unit
) = Column(
    modifier = modifier
        .scrollable(rememberScrollState(), Vertical)
        .fillMaxSize()
        .padding(16.dp)
        .testTag("ContentErrorContainer"),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Image(
        painter = painterResource(id = drawable.cinemania_logo),
        contentDescription = "",
        modifier = Modifier
            .size(180.dp)
    )

    Spacer(modifier = Modifier.size(24.dp))

    Text(
        text = error.localizedMessage ?: stringResource(id = R.string.generic_error_message),
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center,
        modifier = Modifier.testTag("ErrorMessage")
    )

    Spacer(modifier = Modifier.size(24.dp))

    Button(onClick = tryAgain, modifier = Modifier.testTag("TryAgainButton")) {
        Text(text = stringResource(id = R.string.try_again_button))

    }
}

@Preview
@Composable
fun ContentErrorPreview() {
    CineManiaTheme {
        ContentError(IOException(), Modifier.fillMaxSize()) {}
    }
}
