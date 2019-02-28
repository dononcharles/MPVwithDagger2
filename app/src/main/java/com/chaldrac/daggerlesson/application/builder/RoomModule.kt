package com.chaldrac.daggerlesson.application.builder

import android.content.Context
import androidx.room.Room
import com.chaldrac.daggerlesson.models.GithubRoomDatabase
import com.chaldrac.daggerlesson.models.dao.UserDao
import com.chaldrac.daggerlesson.models.repo.UserDataSource
import com.chaldrac.daggerlesson.models.repo.UserRepository
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class RoomModule(mApplication: Context) {

    private val githubRoomDatabase: GithubRoomDatabase =
        Room.databaseBuilder(mApplication.applicationContext,
            GithubRoomDatabase::class.java, "github_db")
                .fallbackToDestructiveMigration()
            //.addMigrations(GithubRoomDatabase.MIGRATION_1_2)
            .build()

    @AppScope
    @Provides
    internal fun providesRoomDatabase(): GithubRoomDatabase {
        return githubRoomDatabase
    }

    @AppScope
    @Provides
    internal fun providesUserDao(roomDatabase: GithubRoomDatabase): UserDao {
        return roomDatabase.userDao
    }

    @AppScope
    @Provides
    internal fun userRepository(userDao: UserDao): UserRepository {
        return UserDataSource(userDao)
    }


}
