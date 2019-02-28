package com.chaldrac.daggerlesson.ui.splash.dagger;

import com.chaldrac.daggerlesson.application.builder.AppComponent;
import com.chaldrac.daggerlesson.ui.splash.SplashScreenActivity;
import dagger.Component;

@SplashScope
@Component(modules = {SplashContextModule.class, SplashModule.class}, dependencies = {AppComponent.class})
public interface SplashComponent {
    void inject(SplashScreenActivity activity);
}
