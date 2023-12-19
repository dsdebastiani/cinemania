package io.github.dsdebastiani.cinemania.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun GradientBox(
    vararg colorStops: Pair<Float, Color>,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) = Box(
    modifier.drawWithContent {
        drawContent()
        drawRect(Brush.verticalGradient(*colorStops))
    },
    contentAlignment,
    propagateMinConstraints,
    content
)
