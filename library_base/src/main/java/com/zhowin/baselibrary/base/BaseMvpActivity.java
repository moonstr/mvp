package com.zhowin.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhowin.baselibrary.mvp.IPresenter;
import com.zhowin.baselibrary.mvp.IView;

public abstract class BaseMvpActivity<VIEW extends IView, PRESENTER extends IPresenter> extends BaseActivity {
    public PRESENTER mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {
        mPresenter = createPresenter();
        if (mPresenter!=null)
        mPresenter.attach(getIView());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null)
        mPresenter.detach();
    }

    protected PRESENTER getPresenter() {
        return mPresenter;
    }

    protected abstract PRESENTER createPresenter();

    protected abstract VIEW getIView();
}
