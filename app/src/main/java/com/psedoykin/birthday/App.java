package com.psedoykin.birthday;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static App mInstance;

    public App() {
        mInstance = this;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }
}
