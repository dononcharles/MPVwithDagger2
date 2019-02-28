package com.chaldrac.daggerlesson;

import android.app.Application;
import com.chaldrac.daggerlesson.injection.*;

public class TestMyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Injector.Companion.getInstance().setAppComponent(
                DaggerTestAppComponent.builder()
                .androidModuleTest(new AndroidModuleTest(this))
                .commonModule(new CommonModule())
                .build()
        );
    }
}
