package com.johnbuhanan.features.featureA.screen1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import timber.log.Timber

@Preview
@Composable
fun FeatureAView(
    thing: String = "Test string",
    onEvent: (Screen1Event) -> Unit = {},
) {
    Timber.e("Composable - FeatureAView")
    Text(
        text = thing,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
    )
}
