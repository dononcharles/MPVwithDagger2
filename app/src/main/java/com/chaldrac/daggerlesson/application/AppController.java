package com.chaldrac.daggerlesson.application;

import android.app.Application;
import com.chaldrac.daggerlesson.BuildConfig;
import com.chaldrac.daggerlesson.application.builder.*;
import com.squareup.leakcanary.LeakCanary;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

public class AppController extends Application {

    private static AppController mInstance;
    private Scheduler scheduler; //Rx object

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initialiseLogger();
        Injector.Companion.getInstance().setAppComponent(DaggerAppComponent.builder()
                .appContextModule(new AppContextModule(this))
                .roomModule(new RoomModule(this)).build());

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
                    // TODO decide what to load in release version
                }
            });
        }
    }

}
