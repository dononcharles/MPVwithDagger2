package com.chaldrac.daggerlesson.ui.userslist

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.chaldrac.daggerlesson.application.builder.Injector
import com.chaldrac.daggerlesson.ui.userslist.core.UserDetailPresenter
import com.chaldrac.daggerlesson.ui.userslist.core.UserDetailView
import com.chaldrac.daggerlesson.ui.userslist.dagger.DaggerUserDetailComponent
import com.chaldrac.daggerlesson.ui.userslist.dagger.UserDetailModule
import com.chaldrac.daggerlesson.ui.userslist.dagger.UserModelModule
import kotlinx.android.synthetic.main.activity_detail_user.*
import javax.inject.Inject

class DetailUserActivity : AppCompatActivity() {

    @Inject lateinit var userDetailView: UserDetailView
    @Inject lateinit var userDetailPresenter: UserDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerUserDetailComponent.builder().appComponent(Injector.getInstance().getAppComponent())
            .userModelModule(UserModelModule(this))
            .userDetailModule(UserDetailModule(this))
            .build().inject(this)

        setContentView(userDetailView.contructView())
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setHomeButtonEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayUseLogoEnabled(true)
        }
        userDetailPresenter.create()
    }

    override fun onDestroy() {
        super.onDestroy()
        userDetailPresenter.destroy()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                setResult(Activity.RESULT_OK)
                this@DetailUserActivity.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
