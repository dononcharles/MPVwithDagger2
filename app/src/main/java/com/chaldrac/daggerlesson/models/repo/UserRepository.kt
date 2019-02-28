package com.chaldrac.daggerlesson.models.repo

import androidx.lifecycle.LiveData
import com.chaldrac.daggerlesson.models.disk.User

interface UserRepository {

    fun findById(login: String): User

    fun findAll(): LiveData<List<User>>

    fun insert(user: User)

    fun delete(user: User): Int

    fun update(user: User)
}