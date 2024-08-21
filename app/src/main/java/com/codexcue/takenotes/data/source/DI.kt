package com.codexcue.takenotes.data.source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DI {
    @Provides
    fun provideDS(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource = localDataSourceImpl
}