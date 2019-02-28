package com.chaldrac.daggerlesson.application.builder

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppContextModule(private val context: Context) {

    @AppScope
    @Provides
    fun provideAppContext(): Context {
        return context
    }
}
