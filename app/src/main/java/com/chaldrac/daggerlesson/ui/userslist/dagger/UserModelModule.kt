package com.chaldrac.daggerlesson.ui.userslist.dagger

import android.app.Activity
import com.chaldrac.daggerlesson.api.HeroApi
import com.chaldrac.daggerlesson.models.repo.UserRepository
import com.chaldrac.daggerlesson.ui.userslist.core.UsersListModel
import dagger.Module
import dagger.Provides

@Module
class UserModelModule(private val context : Activity) {
    @UsersListScope
    @Provides
    fun provideModel(api: HeroApi, userRepository: UserRepository): UsersListModel {
        return UsersListModel(context, api, userRepository)
    }
}