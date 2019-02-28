package com.chaldrac.daggerlesson.ui.userslist.dagger

import com.chaldrac.daggerlesson.ui.userslist.UsersListActivity
import com.chaldrac.daggerlesson.ui.userslist.core.UsersListModel
import com.chaldrac.daggerlesson.ui.userslist.core.UsersListPresenter
import com.chaldrac.daggerlesson.ui.userslist.core.UsersView
import com.chaldrac.daggerlesson.utils.rx.RxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class UsersListModule(private val usersListContext: UsersListActivity) {

    @UsersListScope
    @Provides
    fun provideView(): UsersView {
        return UsersView(usersListContext)
    }

    @UsersListScope
    @Provides
    fun providePresenter(schedulers: RxSchedulers, view: UsersView, model: UsersListModel, cxt:UsersListActivity): UsersListPresenter {
        val subscriptions = CompositeDisposable()
        return UsersListPresenter(schedulers, model, view, cxt, subscriptions)
    }

    @UsersListScope
    @Provides
    fun provideContext(): UsersListActivity {
        return usersListContext
    }

}
