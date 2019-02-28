package com.chaldrac.daggerlesson.models;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.chaldrac.daggerlesson.models.dao.UserDao;
import com.chaldrac.daggerlesson.models.disk.User;

@Database(entities = {User.class}, version = 2)
public abstract class GithubRoomDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE d_users ADD COLUMN name TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN company TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN blog TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN location TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN email TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN hireable TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN bio TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN publicRepos TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN publicGists TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN following TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN followers TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN createdAt TEXT NOT NULL default ''");
            database.execSQL("ALTER TABLE d_users ADD COLUMN updatedAt TEXT NOT NULL default ''");

        }
    };

}