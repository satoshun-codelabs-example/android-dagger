package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(modules = [StorageModule::class])
interface AppComponent {
  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): AppComponent
  }

  fun inject(activity: RegistrationActivity)
  fun inject(activity: MainActivity)
}

@Module
interface StorageModule {
  @Binds
  fun provideStorage(storage: SharedPreferencesStorage): Storage
}
