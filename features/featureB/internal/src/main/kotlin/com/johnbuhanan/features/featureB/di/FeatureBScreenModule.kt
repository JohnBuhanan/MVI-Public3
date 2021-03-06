package com.johnbuhanan.features.featureB.di

import cafe.adriel.voyager.core.registry.screenModule
import com.johnbuhanan.features.featureB.api.FeatureB
import com.johnbuhanan.features.featureB.screen1.Screen1Screen
import com.johnbuhanan.features.featureB.screen2.Screen2Screen
import com.johnbuhanan.features.featureB.screen3.Screen3Screen
import com.johnbuhanan.navigation.ScreenModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object FeatureBScreenModule {
    @Provides
    @IntoSet
    fun provideScreenModule(): ScreenModule {
        return screenModule {
            register<FeatureB.Route.Screen1> {
                Screen1Screen()
            }
            register<FeatureB.Route.Screen2> {
                Screen2Screen()
            }
            register<FeatureB.Route.Screen3> {
                Screen3Screen()
            }
        }
    }
}
