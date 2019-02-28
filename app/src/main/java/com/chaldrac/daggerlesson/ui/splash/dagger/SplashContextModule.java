package com.chaldrac.daggerlesson.ui.splash.dagger;

import com.chaldrac.daggerlesson.ui.splash.SplashScreenActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class SplashContextModule {
    private SplashScreenActivity splashContext;

    public SplashContextModule(SplashScreenActivity context){
        this.splashContext = context;
    }

    @SplashScope
    @Provides
    SplashScreenActivity provideSplashContext(){
        return splashContext;
    }
}
