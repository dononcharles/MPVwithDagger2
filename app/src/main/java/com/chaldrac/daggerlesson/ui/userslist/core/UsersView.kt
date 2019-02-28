package com.chaldrac.daggerlesson.ui.userslist.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.chaldrac.daggerlesson.R
import com.chaldrac.daggerlesson.models.disk.User
import com.chaldrac.daggerlesson.ui.userslist.UsersListActivity
import com.chaldrac.daggerlesson.ui.userslist.list.UsersListAdapter
import com.chaldrac.daggerlesson.ui.pi.LoadDataView
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable

import java.util.ArrayList
import java.util.Objects

class UsersView(context: UsersListActivity) : LoadDataView {

    @BindView(R.id.recyclerH)
    lateinit var list: RecyclerView

    @BindView(R.id.emptyView)
    lateinit var emptyView: ConstraintLayout

    @BindView(R.id.loadingView)
    lateinit var loadingView: ConstraintLayout

    @BindView(R.id.retryView)
    lateinit var retryView: ConstraintLayout

    @BindView(R.id.retryB)
    lateinit var retryB: AppCompatButton

    private val view: View

    private val adapter: UsersListAdapter

    init {
        val frameLayout = FrameLayout(Objects.requireNonNull(context))
        frameLayout.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_heroes_list, frameLayout, true)
        ButterKnife.bind(this, view)

        adapter = UsersListAdapter()
        list.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        list.layoutManager = layoutManager
    }

    fun constructView(): View {
        return view
    }

    fun itemClicks(): Observable<Int> {
        return adapter.observeClicks()
    }

    fun swapAdapter(users: ArrayList<User>) {
        adapter.swapAdapter(users)
    }

    fun onRetryClick(): Observable<Unit> {
        return retryB.clicks()
    }

    override fun showEmptyMessage() {
        emptyView.visibility = View.VISIBLE
    }

    override fun hideEmptyMessage() {
        emptyView.visibility = View.GONE
    }

    override fun showLoading() {
        loadingView.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loadingView.visibility = View.GONE
    }

    override fun showRetry() {
        retryView.visibility = View.VISIBLE
    }

    override fun hideRetry() {
        retryView.visibility = View.GONE
    }

    fun showRecycler(){
        list.visibility = View.VISIBLE
    }

    fun hideRecycler(){
        list.visibility = View.GONE
    }
}
