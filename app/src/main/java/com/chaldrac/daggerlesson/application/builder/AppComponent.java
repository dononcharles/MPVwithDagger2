package com.chaldrac.daggerlesson.application.builder;

import com.chaldrac.daggerlesson.api.HeroApi;
import com.chaldrac.daggerlesson.models.GithubRoomDatabase;
import com.chaldrac.daggerlesson.models.dao.UserDao;
import com.chaldrac.daggerlesson.models.repo.UserRepository;
import com.chaldrac.daggerlesson.utils.rx.RxSchedulers;
import dagger.Component;

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, HereosApiServiceModule.class, RoomModule.class})
public interface AppComponent {

    RxSchedulers rxSchedulers();

    HeroApi apiService();

    UserDao userDao();

    GithubRoomDatabase roomDatabase();

    UserRepository userRepository();
}
