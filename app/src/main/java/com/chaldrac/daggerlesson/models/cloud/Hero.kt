package com.chaldrac.daggerlesson.models.cloud

import com.google.gson.annotations.Expose

import java.io.Serializable

class Hero : Serializable {
    @Expose
    var image: String? = null
    @Expose
    var title: String? = null
    @Expose
    var intro: String? = null
    @Expose
    var year: String? = null
    @Expose
    var text: String? = null
    @Expose
    var color: String? = null
}
