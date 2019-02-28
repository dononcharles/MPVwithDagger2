package com.chaldrac.daggerlesson.ui.userslist.list

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.chaldrac.daggerlesson.R
import com.chaldrac.daggerlesson.models.disk.User
import io.reactivex.subjects.PublishSubject

internal class UsersListViewHolder(private val view: View, clickSubject: PublishSubject<Int>) :
    RecyclerView.ViewHolder(view) {

    @BindView(R.id.hero_name)
    lateinit var userName: TextView

    @BindView(R.id.avatar)
    lateinit var avatar: ImageView

    @BindView(R.id.followers)
    lateinit var followers: TextView

    init {
        ButterKnife.bind(this, view)
        view.setOnClickListener { clickSubject.onNext(adapterPosition) }
    }

    fun bind(user: User) {
        Glide.with(view.context).load(user.avatarUrl).into(avatar)

        userName.text = if (TextUtils.isEmpty(user.login)) "missing Login" else user.login
        followers.text = if (user.followers != null) user.followers.toString() else "0"
        /* dateReleaseHero.setText(TextUtils.isEmpty(hero.getYear()) ? "missing year" : hero.getYear());
        descriptionHero.setText(TextUtils.isEmpty(hero.getIntro()) ? "missing text" : hero.getIntro());
        separatorHero.setBackgroundColor(Color.parseColor(hero.getColor()));*/
    }
}
