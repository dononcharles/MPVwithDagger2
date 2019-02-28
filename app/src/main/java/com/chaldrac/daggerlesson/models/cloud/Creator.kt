package com.chaldrac.daggerlesson.models.cloud

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Creator {
    @SerializedName("login")
    @Expose
    internal var login: String? = null
    @SerializedName("id")
    @Expose
    internal var id: Int? = null
    @SerializedName("node_id")
    @Expose
    internal var nodeId: String? = null
    @SerializedName("avatar_url")
    @Expose
    internal var avatarUrl: String? = null
    @SerializedName("gravatar_id")
    @Expose
    internal var gravatarId: String? = null
    @SerializedName("url")
    @Expose
    internal var url: String? = null
    @SerializedName("html_url")
    @Expose
    internal var htmlUrl: String? = null
    @SerializedName("followers_url")
    @Expose
    internal var followersUrl: String? = null
    @SerializedName("following_url")
    @Expose
    internal var followingUrl: String? = null
    @SerializedName("gists_url")
    @Expose
    internal var gistsUrl: String? = null
    @SerializedName("starred_url")
    @Expose
    internal var starredUrl: String? = null
    @SerializedName("subscriptions_url")
    @Expose
    internal var subscriptionsUrl: String? = null
    @SerializedName("organizations_url")
    @Expose
    internal var organizationsUrl: String? = null
    @SerializedName("repos_url")
    @Expose
    internal var reposUrl: String? = null
    @SerializedName("events_url")
    @Expose
    internal var eventsUrl: String? = null
    @SerializedName("received_events_url")
    @Expose
    internal var receivedEventsUrl: String? = null
    @SerializedName("type")
    @Expose
    internal var type: String? = null
    @SerializedName("site_admin")
    @Expose
    internal var siteAdmin: Boolean? = null
}
