package com.chaldrac.daggerlesson;

import dagger.Module;
import dagger.Provides;
import org.mockito.Mockito;

import javax.inject.Singleton;

@Module
public class AndroidModuleTest {
    private final TestMyApplication application;

    public AndroidModuleTest(TestMyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    StringFactory provideStringFactory() {
        StringFactory mockStringFactory = Mockito.mock(StringFactory.class);
        Mockito.when(mockStringFactory.makeText()).thenReturn("Hello Komi!");
        return mockStringFactory;
    }
}
