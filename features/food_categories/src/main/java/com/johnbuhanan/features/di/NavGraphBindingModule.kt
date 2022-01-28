package com.johnbuhanan.features.di

import com.johnbuhanan.common.DirectionTransform
import com.johnbuhanan.common.NavGraphKey
import com.johnbuhanan.common.Route
import com.johnbuhanan.features.NavGraphs
import com.johnbuhanan.features.destinations.FoodCategoryDetailsScreenDestination
import com.ramcosta.composedestinations.spec.NavGraphSpec
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
object NavGraphModule {
    @Provides
    @IntoMap
    @NavGraphKey(Route.FoodCategories::class)
    fun provideNavGraphSpec(): NavGraphSpec {
        return NavGraphs.root
    }

    @Provides
    @IntoMap
    @NavGraphKey(Route.FoodCategoryDetails::class)
    fun provideDirections(): DirectionTransform {
        return {
            val id = (it as Route.FoodCategoryDetails).id
            FoodCategoryDetailsScreenDestination(id)
        }
    }
}