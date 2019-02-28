package com.chaldrac.daggerlesson.models.cloud

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("url")
    @Expose
    internal var url: String? = null
    @SerializedName("repository_url")
    @Expose
    internal var repositoryUrl: String? = null
    @SerializedName("labels_url")
    @Expose
    internal var labelsUrl: String? = null
    @SerializedName("comments_url")
    @Expose
    internal var commentsUrl: String? = null
    @SerializedName("events_url")
    @Expose
    internal var eventsUrl: String? = null
    @SerializedName("html_url")
    @Expose
    internal var htmlUrl: String? = null
    @SerializedName("id")
    @Expose
    internal var id: Int? = null
    @SerializedName("node_id")
    @Expose
    internal var nodeId: String? = null
    @SerializedName("number")
    @Expose
    internal var number: Int? = null
    @SerializedName("title")
    @Expose
    internal var title: String? = null
    @SerializedName("user")
    @Expose
    internal var user: User? = null
    @SerializedName("labels")
    @Expose
    internal var labels: List<Label>? = null
    @SerializedName("state")
    @Expose
    internal var state: String? = null
    @SerializedName("locked")
    @Expose
    internal var locked: Boolean? = null
    @SerializedName("assignee")
    @Expose
    internal var assignee: Any? = null
    @SerializedName("assignees")
    @Expose
    internal var assignees: List<Any>? = null
    @SerializedName("milestone")
    @Expose
    internal var milestone: Milestone? = null
    @SerializedName("comments")
    @Expose
    internal var comments: Int? = null
    @SerializedName("created_at")
    @Expose
    internal var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    internal var updatedAt: String? = null
    @SerializedName("closed_at")
    @Expose
    internal var closedAt: Any? = null
    @SerializedName("author_association")
    @Expose
    internal var authorAssociation: String? = null
    @SerializedName("body")
    @Expose
    internal var body: String? = null
    @SerializedName("score")
    @Expose
    internal var score: Double? = null
}
