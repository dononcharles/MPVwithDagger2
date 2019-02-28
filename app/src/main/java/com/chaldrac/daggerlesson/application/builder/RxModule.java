package com.chaldrac.daggerlesson.application.builder;

import com.chaldrac.daggerlesson.utils.rx.AppRxSchedulers;
import com.chaldrac.daggerlesson.utils.rx.RxSchedulers;
import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {
    @Provides
    RxSchedulers provideRxSchedulers(){
        return new AppRxSchedulers();
    }
}
