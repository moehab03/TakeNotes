package com.codexcue.takenotes.data.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DI {
    @Provides
    fun provideRepo(repositoryImpl: NotesRepositoryImpl): NotesRepository = repositoryImpl
}