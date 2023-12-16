package io.github.dsdebastiani.cinemania.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Red45,
    onPrimary = White,
    secondary = Red60,
    tertiary = Teal,
    background = Black08,
    onBackground = Grey60,
    onSurface = Grey60,
    onSurfaceVariant = White
)

@Composable
fun CineManiaTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = CineManiaTypography,
        shapes = CineManiaShapes,
        content = content
    )
}
