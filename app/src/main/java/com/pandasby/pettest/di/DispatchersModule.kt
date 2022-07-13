package com.pandasby.pettest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @DispatcherIO
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DispatcherDefault
    fun provideDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @DispatcherMain
    fun provideDispatcherMain(): CoroutineDispatcher = Dispatchers.Main
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherIO()

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherDefault()

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherMain()