package com.orm;

import android.app.Application;

/**
 *         <p>记得添加以下标签</p>
 *         <meta-data
 *             android:name="DATABASE"
 *             android:value="yangtzeu.db" />
 *         <meta-data
 *             android:name="VERSION"
 *             android:value="1" />
 *         <meta-data
 *             android:name="QUERY_LOG"
 *             android:value="true" />
 */
public class SugarApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }

}
