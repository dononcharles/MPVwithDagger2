package com.chaldrac.daggerlesson.ui.splash.core;

import com.chaldrac.daggerlesson.api.HeroApi;
import com.chaldrac.daggerlesson.models.cloud.Heroes;
import com.chaldrac.daggerlesson.ui.splash.SplashScreenActivity;
import com.chaldrac.daggerlesson.utils.NetworkUtils;
import io.reactivex.Observable;

public class SplashModel {
    private HeroApi heroApi;
    private SplashScreenActivity splashContext;

    public SplashModel(HeroApi api, SplashScreenActivity cxt){
        this.heroApi = api;
        this.splashContext = cxt;
    }

    Observable<Heroes> provideListHeroes(){
        return heroApi.getHeroes();
    }

    Observable<Boolean> isNetworkAvailable(){
        return NetworkUtils.isNetworkAvailableObservable(splashContext);
    }

    void gotoHeroesListActivity() {
        splashContext.showHeroesListActivity();
    }

}
