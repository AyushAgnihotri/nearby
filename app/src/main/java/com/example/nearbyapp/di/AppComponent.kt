package com.example.nearbyapp.di

import android.app.Application
import com.example.nearbyapp.NearbyApplication
import com.example.nearbyapp.di.module.AppModule
import com.example.nearbyapp.di.module.DbModule
import com.example.nearbyapp.di.module.RepositoryModule
import com.example.nearbyapp.di.module.UiModule
import com.example.nearbyapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DbModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        UiModule::class,
    ],
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: NearbyApplication)
}
