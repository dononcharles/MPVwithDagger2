package com.chaldrac.daggerlesson.ui.splash.core;

import com.chaldrac.daggerlesson.R;
import com.chaldrac.daggerlesson.ui.splash.SplashScreenActivity;
import com.chaldrac.daggerlesson.utils.UiUtils;
import com.chaldrac.daggerlesson.utils.rx.RxSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class SplashPresenter {
    private SplashModel model;
    private CompositeDisposable subscriptions;
    private RxSchedulers rxSchedulers;
    private SplashView view;
    private SplashScreenActivity splashContext;


    public SplashPresenter(SplashModel m, RxSchedulers rx, SplashView v, SplashScreenActivity c, CompositeDisposable compositeDisposable) {
        this.model = m;
        this.rxSchedulers = rx;
        this.subscriptions = compositeDisposable;
        this.view = v;
        this.splashContext = c;
    }

    public void onCreate() {
        subscriptions.add(checkNetworkState());
        subscriptions.add(responseToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }

    private Disposable responseToClick() {
        return view.enterSplashOnClick()
                .flatMap(isAvailable -> model.isNetworkAvailable())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        model.gotoHeroesListActivity();
                    } else {
                        UiUtils.INSTANCE.showSnackbar(view.constructView(), splashContext.getString(R.string.error_network), 0);
                    }

                }, UiUtils.INSTANCE::handleThrowable);
    }

    private Disposable checkNetworkState() {
        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                UiUtils.INSTANCE.showSnackbar(view.constructView(), splashContext.getString(R.string.error_network), 0);
            }
        }).
                filter(isNetworkAvailable -> true)
                .flatMap(isAvailable -> model.isNetworkAvailable())
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(aBoolean -> {
                }, UiUtils.INSTANCE::handleThrowable);
    }

}
