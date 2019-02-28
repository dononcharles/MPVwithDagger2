package com.chaldrac.daggerlesson.models.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.chaldrac.daggerlesson.models.disk.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Long

    @Query("SELECT * FROM d_users ORDER BY login ASC")
    fun getAllUsers(): LiveData<List<User>>

    @Delete
    fun delete(user: User): Int

    @Query("SELECT * FROM d_users WHERE login =:login")
    fun findById(login: String): User

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: User)

}