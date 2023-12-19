package com.example.notes.di

import android.app.Application
import androidx.room.Room
import com.example.notes.room.NoteDao
import com.example.notes.room.NoteDatabase
import com.example.notes.room.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        application: Application
    ):NoteDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NoteDatabase::class.java,
            name = "note_db"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    @Provides
    @Singleton
    fun provideNoteDao(
        noteDatabase: NoteDatabase
    ): NoteDao = noteDatabase.noteDao

    @Provides
    @Singleton
    fun provideRepo (
        dao: NoteDao
    ):Repository{
        return Repository(dao)
    }

}