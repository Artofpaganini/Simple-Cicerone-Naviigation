package com.viktar.dabrou.ciceronenavigation.di

import com.viktar.dabrou.ciceronenavigation.subnavigation.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by terrakok 24.11.16
 */
@Module
object LocalNavigationModule {

    @Provides
    @Singleton
    fun provideLocalNavigationHolder(): LocalCiceroneHolder = LocalCiceroneHolder()
}