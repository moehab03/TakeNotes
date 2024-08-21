package com.codexcue.takenotes.app

import android.app.Application
import com.codexcue.takenotes.data.database.NotesDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        NotesDatabase.initDataBase(this)
    }
}