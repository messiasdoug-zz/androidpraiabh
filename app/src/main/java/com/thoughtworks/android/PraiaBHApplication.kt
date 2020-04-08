package com.thoughtworks.android

import android.app.Application
import com.thoughtworks.android.di.repositoryModule
import com.thoughtworks.android.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PraiaBHApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PraiaBHApplication)
            modules(viewModelModule, repositoryModule)
        }
    }
}