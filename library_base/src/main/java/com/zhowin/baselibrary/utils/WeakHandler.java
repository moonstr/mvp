package com.zhowin.baselibrary.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.zhowin.baselibrary.base.BaseActivity;

import java.lang.ref.WeakReference;

public class WeakHandler extends Handler {
    private final WeakReference<BaseActivity> mActivty;
    public Context context;
    public WeakHandler(BaseActivity mActivty) {
        this.mActivty = new WeakReference<BaseActivity>(mActivty);
        context= this.mActivty.get();
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        BaseActivity activity = mActivty.get();
        if (activity != null){
            // ....

        }
    }
}
