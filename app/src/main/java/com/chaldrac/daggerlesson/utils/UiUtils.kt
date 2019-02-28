package com.chaldrac.daggerlesson.utils

import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.chaldrac.daggerlesson.R
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

object UiUtils {

    private const val dateFormatI = "yyyy-MM-dd'T'HH:mm:ss"
    private const val dateFormatO = "yyyy-MM-dd HH:mm:ss"

    fun handleThrowable(throwable: Throwable) {
        Timber.d("loaded : ok in")
        Timber.e(throwable, throwable.toString())
    }

    fun showSnackbar(view: View, message: String, length: Int) {
        Snackbar.make(view, message, length).setAction("Action", null).show()
    }

    fun convertDate(date: String) : String{
        val formatInput = SimpleDateFormat(dateFormatI, Locale.ENGLISH)
        val formatOutput = SimpleDateFormat(dateFormatO, Locale.ENGLISH)
        val d = formatInput.parse(date)
        return formatOutput.format(d)
    }

    private fun launchFragmentKeepingInBackStack(context: Context, fragmentToLaunch: Fragment, fragmentTag: String) {
        val supportFragmentManager = (context as AppCompatActivity).supportFragmentManager
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragmentToLaunch, fragmentTag)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    fun launchFragmentKeepingInBackStack(context: Context, fragmentToLaunch: Fragment) {
        launchFragmentKeepingInBackStack(context, fragmentToLaunch, fragmentToLaunch.javaClass.name)
    }

    fun launchFragmentWithoutKeepingInBackStack(context: Context, fragmentToLaunch: Fragment) {
        launchFragmentWithoutKeepingInBackStack(context, fragmentToLaunch, fragmentToLaunch.javaClass.name)
    }

    private fun launchFragmentWithoutKeepingInBackStack(
        context: Context,
        fragmentToLaunch: Fragment,
        fragmentTag: String) {
        val supportFragmentManager = (context as AppCompatActivity).supportFragmentManager
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragmentToLaunch, fragmentTag)
            .commitAllowingStateLoss()
    }
}
