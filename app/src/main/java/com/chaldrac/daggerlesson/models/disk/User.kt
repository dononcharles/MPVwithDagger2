package com.chaldrac.daggerlesson.models.disk

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "d_users")
class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "_id")
    var id: Long? = null

    @ColumnInfo(name = "login")
    var login: String? = null

    @ColumnInfo(name = "avatarUrl")
    var avatarUrl: String? = null

    @ColumnInfo(name = "gravatarId")
    var gravatarId: String? = null

    @ColumnInfo(name = "url")
    var url: String? = null

    @ColumnInfo(name = "followersUrl")
    var followersUrl: String? = null

    @ColumnInfo(name = "followingUrl")
    var followingUrl: String? = null

    @ColumnInfo(name = "type")
    var type: String? = null

    @ColumnInfo(name = "siteAdmin")
    var siteAdmin: Boolean? = null

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "company")
    var company: String? = null

    @ColumnInfo(name = "blog")
    var blog: String? = null

    @ColumnInfo(name = "location")
    var location: String? = null

    @ColumnInfo(name = "email")
    var email: String? = null

    @ColumnInfo(name = "hireable")
    var hireable: String? = null

    @ColumnInfo(name = "bio")
    var bio: String? = null

    @ColumnInfo(name = "publicRepos")
    var publicRepos: Int? = null

    @ColumnInfo(name = "publicGists")
    var publicGists: Int? = null

    @ColumnInfo(name = "followers")
    var followers: Int? = null

    @ColumnInfo(name = "following")
    var following: Int? = null

    @ColumnInfo(name = "createdAt")
    var createdAt: String? = null

    @ColumnInfo(name = "updatedAt")
    var updatedAt: String? = null
}
