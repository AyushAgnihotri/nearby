package com.example.nearbyapp.di.module

import com.example.nearbyapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
