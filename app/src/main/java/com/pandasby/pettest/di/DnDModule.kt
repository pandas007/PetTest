package com.pandasby.pettest.di

import com.pandasby.pettest.data.repos.DnDClassesRepositoryImpl
import com.pandasby.pettest.domain.repos.DnDClassesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DnDModule {

    @Binds
    abstract fun bindClassesRepository(repo: DnDClassesRepositoryImpl): DnDClassesRepository
}