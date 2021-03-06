package com.johnbuhanan.features.featureA.screen2

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.androidx.AndroidScreen
import com.johnbuhanan.common.viewmodel.WithViewModel
import com.johnbuhanan.features.featureA.screen2.Screen2Effect.ShowToast
import timber.log.Timber

class Screen2Screen(private val onResult: (Long) -> Unit) : AndroidScreen() {
    @Composable
    override fun Content() {
        val context = LocalContext.current
        Timber.e("Composable - FeatureA")
        WithViewModel<Screen2ViewModel>(
            onEffect = { effect ->
                when (effect) {
                    is ShowToast -> {
                        Timber.e("Composable - onEffect - ShowToast")
                        Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                    }
                }
            },
            start = { viewModel, onEvent ->
                viewModel.onResult = onResult
                BackHandler {
                    Timber.e("BACK_HANDLER")
                    onEvent(Screen2Event.TappedBack)
                }
                when (val state = viewModel.state.collectAsState().value) {
                    is Screen2State -> Screen2View(
                        message = state.message,
                        onEvent = onEvent,
                    )
                }
            },
        )
    }
}

