package com.chaldrac.daggerlesson.models.repo;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.chaldrac.daggerlesson.models.dao.UserDao;
import com.chaldrac.daggerlesson.models.disk.User;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserDataSource implements UserRepository {

    private UserDao userDao;

    @Inject
    public UserDataSource(UserDao u) {
        this.userDao = u;
    }

    @NotNull
    @Override
    public User findById(@NotNull String login) {
       //return userDao.findById(login);


        try {
           return new findAsyncTask(userDao).execute(login).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @NotNull
    @Override
    public LiveData<List<User>> findAll() {
        return userDao.getAllUsers();
    }

    @Override
    public void insert(@NotNull User user) {
        new insertAsyncTask(userDao).execute(user);
    }

    @Override
    public void update(@NotNull User user) {
        new updateAsyncTask(userDao).execute(user);
       // userDao.updateUser(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        updateAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.updateUser(params[0]);
            return null;
        }
    }

    private static class findAsyncTask extends AsyncTask<String, Void, User> {

        private UserDao mAsyncTaskDao;

        findAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        protected User doInBackground(final String... login) {
           return  mAsyncTaskDao.findById(login[0]);
        }

    }

    @Override
    public int delete(@NotNull User user) {
        return 0;
    }
}
