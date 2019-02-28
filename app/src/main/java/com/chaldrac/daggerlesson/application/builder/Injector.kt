package com.chaldrac.daggerlesson.application.builder

class Injector {
    companion object {
        private val ourInstance = Injector()

        fun getInstance(): Injector {
            return ourInstance
        }

    }

    private var appComponent: AppComponent? = null

    fun getAppComponent(): AppComponent? {
        return appComponent
    }

    fun setAppComponent(appComponent: AppComponent) {
        this.appComponent = appComponent
    }

}
