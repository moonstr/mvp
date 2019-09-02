package com.zhowin.baselibrary.mvp;

import android.support.annotation.CallSuper;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<VIEW extends IView> implements   IPresenter<VIEW> {
    protected CompositeDisposable mCompositeDisposable=new CompositeDisposable();
    private WeakReference<VIEW> mView;

    /**
     * @param view 对的activity上下文对象，具体activtiy（view）实现了不同的接口，进行回调对应接口方法时候用到（接口子类对象类对象调用接口方法），
     *          activty退出了，某个接口进网络操作，存在对当前上下午引用，存在内存泄漏，使用WeakReference解决。
     */
    public void attach(VIEW view) {
        mView = new WeakReference<>(view);
    }

    @CallSuper
    public void detach() {
        if (mView != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable=null;
            mView.clear();
            mView = null;
        }
    }


    protected VIEW getView() {
        if (mView != null) {
            return mView.get();
        }
        return null;
    }
    public void addDisposable(Disposable disposable){
        mCompositeDisposable.add(disposable);
    }
}
