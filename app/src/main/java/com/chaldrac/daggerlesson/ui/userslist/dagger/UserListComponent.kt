package com.chaldrac.daggerlesson.ui.userslist.dagger

import com.chaldrac.daggerlesson.application.builder.AppComponent
import com.chaldrac.daggerlesson.ui.userslist.UsersListActivity
import dagger.Component

@UsersListScope
@Component(dependencies = [AppComponent::class], modules = [UsersListModule::class, UserModelModule::class])
interface UserListComponent {
    fun inject(usersListActivity: UsersListActivity)
}
