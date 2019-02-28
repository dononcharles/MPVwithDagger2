package com.chaldrac.daggerlesson.models.cloud

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Milestone {
    @SerializedName("url")
    @Expose
    internal var url: String? = null
    @SerializedName("html_url")
    @Expose
    internal var htmlUrl: String? = null
    @SerializedName("labels_url")
    @Expose
    internal var labelsUrl: String? = null
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
    @SerializedName("description")
    @Expose
    internal var description: String? = null
    @SerializedName("creator")
    @Expose
    internal var creator: Creator? = null
    @SerializedName("open_issues")
    @Expose
    internal var openIssues: Int? = null
    @SerializedName("closed_issues")
    @Expose
    internal var closedIssues: Int? = null
    @SerializedName("state")
    @Expose
    internal var state: String? = null
    @SerializedName("created_at")
    @Expose
    internal var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    internal var updatedAt: String? = null
    @SerializedName("due_on")
    @Expose
    internal var dueOn: Any? = null
    @SerializedName("closed_at")
    @Expose
    internal var closedAt: Any? = null
}
