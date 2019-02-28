package com.chaldrac.daggerlesson.ui.userslist.dagger

import com.chaldrac.daggerlesson.ui.userslist.DetailUserActivity
import com.chaldrac.daggerlesson.ui.userslist.core.UserDetailPresenter
import com.chaldrac.daggerlesson.ui.userslist.core.UserDetailView
import com.chaldrac.daggerlesson.ui.userslist.core.UsersListModel
import com.chaldrac.daggerlesson.utils.rx.RxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class UserDetailModule(private val userDetailContext : DetailUserActivity) {

    @UsersListScope
    @Provides
    fun provideView(): UserDetailView {
        return UserDetailView(userDetailContext)
    }

    @UsersListScope
    @Provides
    fun provideContext() : DetailUserActivity {
        return userDetailContext
    }

    @UsersListScope
    @Provides
    fun providePresenter(rxSchedulers: RxSchedulers, model: UsersListModel, view: UserDetailView, conttxt : DetailUserActivity) : UserDetailPresenter{
        val compositeDisposable = CompositeDisposable()
        return UserDetailPresenter(rxSchedulers, model, view, conttxt, compositeDisposable)
    }
}