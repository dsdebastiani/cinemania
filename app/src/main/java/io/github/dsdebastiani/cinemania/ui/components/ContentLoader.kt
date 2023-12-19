package io.github.dsdebastiani.cinemania.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import io.github.dsdebastiani.cinemania.ui.theme.CineManiaTheme

@Composable
fun ContentLoader(
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier.testTag("ContentLoaderTAG")
) {
    CircularProgressIndicator(
        modifier = Modifier.align(Alignment.Center)
    )
}

@Preview
@Composable
private fun ContentLoaderPreview() {
    CineManiaTheme {
        ContentLoader()
    }
}
