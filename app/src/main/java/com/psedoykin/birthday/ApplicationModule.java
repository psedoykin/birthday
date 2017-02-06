package com.psedoykin.birthday;


import android.app.Application;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    PresenterManager providePresenterManager() {
        return new PresenterManager(10, 30, TimeUnit.SECONDS);
    }
}
