package com.chaldrac.daggerlesson.ui.userslist.core

import androidx.lifecycle.Observer
import com.chaldrac.daggerlesson.models.cloud.Item
import com.chaldrac.daggerlesson.models.disk.User
import com.chaldrac.daggerlesson.ui.userslist.UsersListActivity
import com.chaldrac.daggerlesson.ui.pi.Presenter
import com.chaldrac.daggerlesson.utils.UiUtils
import com.chaldrac.daggerlesson.utils.rx.RxSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.*


/**
 * This class represent the pattern Presenter in MVP of Github users list
 */
class UsersListPresenter(
    private val rxSchedulers: RxSchedulers,
    private val model: UsersListModel,
    private val view: UsersView,
    private val context: UsersListActivity,
    private val subscriptions: CompositeDisposable
) : Presenter {

    private var users = ArrayList<User>()

    private fun heroesList(): Disposable {
        view.showLoading()
        return model.isNetworkAvailable
            .doOnNext { networkAvailable ->
                if (!networkAvailable) {
                    Timber.d("no connexion")
                }
            }
            .filter { true }
            .flatMap { model.provideGithubUserList() }
            .observeOn(rxSchedulers.androidThread())
            .subscribe({ heroes ->

                if (!heroes.items!!.isEmpty()) {
                    for (item: Item in heroes.items!!) {
                        val u = User()
                        u.id = item.user?.id
                        u.login = item.user?.login
                        u.avatarUrl = item.user?.avatarUrl
                        model.insertUserIntoLocal(u)
                    }
                }
                model.userFromDbLocal.observe(context,
                    Observer<List<User>> { usersO ->
                        if (!usersO.isEmpty()) {
                            view.showRecycler()
                            view.hideLoading()
                            view.hideEmptyMessage()
                            view.swapAdapter(usersO as ArrayList<User>)
                            users = usersO
                        } else {
                            view.hideRecycler()
                            view.hideLoading()
                            view.hideRetry()
                            view.showEmptyMessage()
                        }
                    })


            }, { throwable ->
                view.hideRecycler()
                view.showRetry()
                view.hideLoading()
                UiUtils.handleThrowable(throwable)
            })
    }

    private fun responseToRetryClick(): Disposable {
        return view.onRetryClick()
            .subscribe({
                view.hideRetry()
                this.heroesList()
            }, { throwable ->
                view.showRetry()
                view.hideLoading()
                UiUtils.handleThrowable(throwable)
            })
    }

    private fun respondToClick(): Disposable {
        var indice = 0
        return view.itemClicks()
            .flatMap { i ->
                indice = i
                model.isNetworkAvailable
            }.flatMap { model.getUserDetail(users[indice].login!!) }
            .observeOn(rxSchedulers.androidThread())
            .subscribe({ userRemote ->
                val userLocal = model.findUserByLogin(users[indice].login!!)

                /* .observe(context,
                 Observer<User> { userLocal ->*/
                userLocal.email = userRemote.email
                userLocal.followers = userRemote.followers
                userLocal.name = userRemote.name
                userLocal.company = userRemote.company
                userLocal.createdAt = userRemote.createdAt
                userLocal.updatedAt = userRemote.updatedAt
                userLocal.location = userRemote.location
                userLocal.following = userRemote.following
                userLocal.blog = userRemote.blog
                userLocal.publicGists = userRemote.publicGists
                userLocal.publicRepos = userRemote.publicRepos
                userLocal.bio = userRemote.bio

                // update local database with remote user info
                model.updateUserLocal(userLocal)

                // call detail activity
                model.gotoHeroDetailsActivity(userLocal)
                /*  })*/
            }, { throwable ->
                UiUtils.handleThrowable(throwable)
            }
            )

    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        subscriptions.clear()
    }

    override fun create() {
        subscriptions.add(heroesList())
        subscriptions.add(respondToClick())
        subscriptions.add(responseToRetryClick())
    }
}
