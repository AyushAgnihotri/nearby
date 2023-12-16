package com.example.nearbyapp.di.module

import com.example.nearbyapp.db.dao.PlacesDao
import com.example.nearbyapp.util.Constants
import com.example.nearbyapp.data.local.DBPlacesStore
import com.example.nearbyapp.data.local.PlacesStore
import com.example.nearbyapp.data.remote.NearbyPlacesService
import com.example.nearbyapp.data.remote.RemoteNearbyPlacesService
import com.example.nearbyapp.data.remote.api.NearbyAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Provides
    fun providePlacesStore(placesDao: PlacesDao): PlacesStore {
        return DBPlacesStore(placesDao)
    }

    @Provides
    @Singleton
    fun provideNearbyPlacesService(): NearbyPlacesService {
        val logging = HttpLoggingInterceptor()
        logging.apply { logging.level = HttpLoggingInterceptor.Level.BODY }
        val httpClient = OkHttpClient.Builder().addInterceptor(logging).build()

        val api =
            Retrofit
                .Builder()
                .client(httpClient)
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NearbyAPI::class.java)
        return RemoteNearbyPlacesService(api)
    }
}
