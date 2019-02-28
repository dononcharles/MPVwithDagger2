package com.chaldrac.daggerlesson;

import com.chaldrac.daggerlesson.injection.AppComponent;
import com.chaldrac.daggerlesson.injection.CommonModule;
import com.chaldrac.daggerlesson.ui.MainActivity;
import dagger.Component;
import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AndroidModuleTest.class, CommonModule.class})
public interface TestAppComponent extends AppComponent {

    @Override
    void inject(@NotNull MainActivity mainActivity);
}
