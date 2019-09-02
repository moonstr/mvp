package com.zhowin.baselibrary.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhowin.baselibrary.mvp.IPresenter;
import com.zhowin.baselibrary.mvp.IView;

public abstract class BaseMvpFragment<VIEW extends IView, PRESENTER extends IPresenter> extends BaseFragment {

    public PRESENTER mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attach(getIView());
    }

    @Override
    public void initData() {

    }

    protected PRESENTER getPresenter() {
        return mPresenter;
    }

    protected abstract PRESENTER createPresenter();

    protected abstract VIEW getIView();
}
