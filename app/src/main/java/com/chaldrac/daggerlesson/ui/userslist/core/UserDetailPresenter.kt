package com.chaldrac.daggerlesson.ui.userslist.core

import com.chaldrac.daggerlesson.ui.userslist.DetailUserActivity
import com.chaldrac.daggerlesson.ui.pi.Presenter
import com.chaldrac.daggerlesson.utils.rx.RxSchedulers
import io.reactivex.disposables.CompositeDisposable

class UserDetailPresenter(
    private val rxSchedulers: RxSchedulers,
    private val model: UsersListModel,
    private val view: UserDetailView,
    private val context: DetailUserActivity,
    private val subscriptions: CompositeDisposable
) : Presenter {

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
        subscriptions.clear()
    }

    override fun create() {

    }
}