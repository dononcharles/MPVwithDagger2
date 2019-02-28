package com.chaldrac.daggerlesson.models.cloud

import com.google.gson.annotations.Expose

class Heroes{
    @Expose
    lateinit var elements: List<Hero>
}
