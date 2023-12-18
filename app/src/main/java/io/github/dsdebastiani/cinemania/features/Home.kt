package io.github.dsdebastiani.cinemania.features

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.github.dsdebastiani.cinemania.R

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
) {
    HomeScreen(modifier)
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Content(modifier)
}

@Composable
internal fun Content(
    modifier: Modifier = Modifier
) {

    Text(
        modifier = modifier,
        text = stringResource(id = R.string.app_name)
    )
}
