package com.chaldrac.daggerlesson.ui.userslist.dagger

import com.chaldrac.daggerlesson.application.builder.AppComponent
import com.chaldrac.daggerlesson.ui.userslist.DetailUserActivity
import dagger.Component

@UsersListScope
@Component(modules = [UserDetailModule::class, UserModelModule::class], dependencies = [AppComponent::class])
interface UserDetailComponent {
    fun inject (detailUserActivity: DetailUserActivity)
}