package com.chaldrac.daggerlesson.ui.userslist

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.chaldrac.daggerlesson.R
import com.chaldrac.daggerlesson.application.builder.Injector
import com.chaldrac.daggerlesson.models.disk.User
import com.chaldrac.daggerlesson.ui.userslist.core.UsersListPresenter
import com.chaldrac.daggerlesson.ui.userslist.core.UsersView
import com.chaldrac.daggerlesson.ui.userslist.dagger.DaggerUserListComponent
import com.chaldrac.daggerlesson.ui.userslist.dagger.UserModelModule
import com.chaldrac.daggerlesson.ui.userslist.dagger.UsersListModule
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_heroes_list.*
import javax.inject.Inject

class UsersListActivity : AppCompatActivity() {

    @Inject
    lateinit var view: UsersView
    @Inject
    lateinit var presenter: UsersListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerUserListComponent.builder().appComponent(Injector.getInstance().getAppComponent())
            .usersListModule(UsersListModule(this))
            .userModelModule(UserModelModule(this))
            .build().inject(this)

        setContentView(view.constructView())
        setSupportActionBar(toolbar)

        title = getString(R.string.acti_github_title)

        presenter.create()
        handleIntent(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.app_bar_search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
           // setIconifiedByDefault(false)
        }

        return super.onCreateOptionsMenu(menu)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //use the query to search your data somehow
            Log.e("tes", query)
        }
    }

    override fun onNewIntent(intent: Intent) {
        handleIntent(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    fun goToHeroDetailsActivity(user: User) {
        val i = Intent(this, DetailUserActivity::class.java)
        i.putExtra("user", Gson().toJson(user))
        startActivity(i)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.app_bar_search -> {
                onSearchRequested()
                true
            }
            else -> false
        }
    }
}
