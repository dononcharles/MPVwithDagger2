package com.chaldrac.daggerlesson.ui.userslist.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.chaldrac.daggerlesson.R
import com.chaldrac.daggerlesson.models.disk.User
import com.chaldrac.daggerlesson.ui.userslist.DetailUserActivity
import com.chaldrac.daggerlesson.utils.UiUtils
import com.google.gson.Gson
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import java.util.*

class UserDetailView(var context: DetailUserActivity) {

    private val view: View

    @BindView(R.id.avatar)
    lateinit var avatar: ImageView
    @BindView(R.id.username)
    lateinit var login: TextView
    @BindView(R.id.fullname)
    lateinit var fullname: TextView
    @BindView(R.id.company)
    lateinit var company: TextView
    @BindView(R.id.location)
    lateinit var location: TextView
    @BindView(R.id.email)
    lateinit var email: TextView
    @BindView(R.id.createdat)
    lateinit var createdat: TextView
    @BindView(R.id.nbfollowers)
    lateinit var nbfollowers: TextView
    @BindView(R.id.bio)
    lateinit var bio: TextView

    init {
        val frameLayout = FrameLayout(Objects.requireNonNull(context))
        frameLayout.layoutParams =
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_detail_user, frameLayout, true)
        ButterKnife.bind(this, view)

        val strObj = context.intent.getStringExtra("user")
        val user = Gson().fromJson<User>(strObj, User::class.java)

        context.title = if (user.name != null) "#${user.name}" else "#${user.login}"

        Glide.with(view.context).load(user.avatarUrl).into(avatar)
        login.text = user.login
        fullname.text = if (user.name != null) user.name else "---------"
        company.text = if (user.company != null) user.company else "---------"
        email.text = if (user.email != null) user.email else "---------"
        location.text = if (user.location != null) user.location else "---------"
        createdat.text = UiUtils.convertDate(user.createdAt!!)
        nbfollowers.text = user.followers.toString()
        bio.text = if (user.bio != null) user.bio else "---------"
    }

    fun contructView(): View {
        return view
    }

    fun onRetryClick(): Observable<Unit> {
        return login.clicks()
    }

}