package com.chaldrac.daggerlesson.models.cloud

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Label {
    @SerializedName("id")
    @Expose
    internal var id: Int? = null
    @SerializedName("node_id")
    @Expose
    internal var nodeId: String? = null
    @SerializedName("url")
    @Expose
    internal var url: String? = null
    @SerializedName("name")
    @Expose
    internal var name: String? = null
    @SerializedName("color")
    @Expose
    internal var color: String? = null
    @SerializedName("default")
    @Expose
    internal var _default: Boolean? = null
}
