package com.chaldrac.daggerlesson.ui.userslist.core

import android.app.Activity
import androidx.lifecycle.LiveData
import com.chaldrac.daggerlesson.api.HeroApi
import com.chaldrac.daggerlesson.models.cloud.ApiGithubUser
import com.chaldrac.daggerlesson.models.cloud.Heroes
import com.chaldrac.daggerlesson.models.disk.User
import com.chaldrac.daggerlesson.models.repo.UserRepository
import com.chaldrac.daggerlesson.ui.userslist.UsersListActivity
import com.chaldrac.daggerlesson.utils.NetworkUtils
import io.reactivex.Observable

/**
 * Class representating Model pattern
 */
class UsersListModel(
    private val context: Activity,
    private val api: HeroApi,
    private val userRepository: UserRepository
) {

    internal val userFromDbLocal: LiveData<List<User>>
        get() = userRepository.findAll()


    internal val isNetworkAvailable: Observable<Boolean>
        get() = NetworkUtils.isNetworkAvailableObservable(context)

    /**
     * @return Observable<Heroes>
    </Heroes> */
    internal fun provideListHeroes(): Observable<Heroes> {
        return api.heroes
    }

    /**
     * get user detail information from remote
     */
    internal fun getUserDetail(login:String) : Observable<com.chaldrac.daggerlesson.models.cloud.User>{
        return api.getDetailUser(login)
    }

    /**
     * get user by login
     */
    internal fun findUserByLogin(login: String) : User{
        return userRepository.findById(login)
    }

    /**
     * update user info in local disk
     */
    internal fun updateUserLocal(user: User){
        userRepository.update(user)
    }

    /**
     * @return Observable<ApiGithubUser>
    </ApiGithubUser> */
    internal fun provideGithubUserList(): Observable<ApiGithubUser> {
        return api.gUsers
    }

    internal fun insertUserIntoLocal(user: User) {
        userRepository.insert(user)
    }

    internal fun gotoHeroDetailsActivity(user: User) {
        if (context is UsersListActivity) {
            context.goToHeroDetailsActivity(user)
        }
    }
}
