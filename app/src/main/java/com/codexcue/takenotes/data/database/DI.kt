package com.codexcue.takenotes.data.database

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DI {
    @Provides
    fun provideDatabase(): NotesDatabase = NotesDatabase.getInstance()
}