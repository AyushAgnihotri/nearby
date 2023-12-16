package com.example.nearbyapp.di.module

import android.content.Context
import com.example.nearbyapp.db.AppDatabase
import com.example.nearbyapp.db.dao.PlacesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    fun provideAppDatabase(appContext: Context): AppDatabase = AppDatabase(appContext)

    @Provides
    @Singleton
    fun providePlacesDao(database: AppDatabase): PlacesDao = database.placesDao()
}
