package com.chaldrac.daggerlesson.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chaldrac.daggerlesson.ui.splash.core.SplashPresenter
import com.chaldrac.daggerlesson.ui.splash.core.SplashView
import javax.inject.Inject
import android.content.Intent
import com.chaldrac.daggerlesson.application.builder.Injector
import com.chaldrac.daggerlesson.ui.userslist.UsersListActivity
import com.chaldrac.daggerlesson.ui.splash.dagger.DaggerSplashComponent
import com.chaldrac.daggerlesson.ui.splash.dagger.SplashContextModule
import timber.log.Timber


class SplashScreenActivity : AppCompatActivity() {

    @Inject
    lateinit var view: SplashView
    @Inject
    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSplashComponent.builder().appComponent(
            Injector.getInstance().getAppComponent()
        ).splashContextModule(SplashContextModule(this)).build().inject(this)

        setContentView(view.constructView())
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    fun showHeroesListActivity() {
        Timber.d("loaded : ok showed")
        val i = Intent(this, UsersListActivity::class.java)
        startActivity(i)
    }
}
