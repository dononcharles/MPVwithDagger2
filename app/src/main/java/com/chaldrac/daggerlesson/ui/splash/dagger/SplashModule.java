package com.chaldrac.daggerlesson.ui.splash.dagger;

import com.chaldrac.daggerlesson.api.HeroApi;
import com.chaldrac.daggerlesson.ui.splash.SplashScreenActivity;
import com.chaldrac.daggerlesson.ui.splash.core.SplashModel;
import com.chaldrac.daggerlesson.ui.splash.core.SplashPresenter;
import com.chaldrac.daggerlesson.ui.splash.core.SplashView;
import com.chaldrac.daggerlesson.utils.rx.RxSchedulers;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class SplashModule {

    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers, SplashModel model, SplashView v, SplashScreenActivity context){
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        return new SplashPresenter(model, schedulers, v, context, compositeDisposable);
    }

    @SplashScope
    @Provides
    SplashView provideSplashview(SplashScreenActivity context){
        return new SplashView(context);
    }

    @SplashScope
    @Provides
    SplashModel provideSplashModel(HeroApi api, SplashScreenActivity context){
        return new SplashModel(api, context);
    }
}
