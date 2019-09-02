package com.zhowin.baselibrary.base;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.zhowin.baselibrary.utils.ActivityManager;
import com.zhowin.baselibrary.utils.ExecutorsUtils;

public class BaseApplication extends MultiDexApplication {
    private static BaseApplication application;
    private static ExecutorsUtils mAppExecutors;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        mAppExecutors = new ExecutorsUtils();
    }
    public ActivityManager getActivityManager(){
        return ActivityManager.getAppInstance();
    }
    public static BaseApplication getInstance() {
        return application;
    }
    public static ExecutorsUtils getExecutorsUtils() {
        return mAppExecutors;
    }
}
