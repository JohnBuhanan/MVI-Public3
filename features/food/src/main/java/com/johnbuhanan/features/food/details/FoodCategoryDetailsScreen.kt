package com.johnbuhanan.features.food.details

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import com.johnbuhanan.common.WithViewModel
import com.ramcosta.composedestinations.annotation.Destination
import timber.log.Timber

@Destination(
    navGraph = "food"
)
@Composable
fun FoodCategoryDetailsScreen(
    categoryId: String,
) {
    Timber.e("Composable - FoodCategoryDetails")
    WithViewModel<FoodCategoryDetailsViewModel>(
        onEffect = { effect ->
            when (effect) {
                is FoodCategoryDetailsEffect -> {
                    val scaffoldState: ScaffoldState = rememberScaffoldState()
                    scaffoldState.snackbarHostState.showSnackbar("blah")
                }
            }
        },
        initialize = { viewModel ->
            viewModel.initialize(categoryId)
        },
        start = { viewModel, onEvent ->
            when (val state = viewModel.state.value) {
                is FoodCategoryDetailsState -> FoodCategoryDetailsView(
                    category = state.category,
                    categoryFoodItems = state.categoryFoodItems,
                    onEvent = onEvent
                )
            }
        },
    )
}
