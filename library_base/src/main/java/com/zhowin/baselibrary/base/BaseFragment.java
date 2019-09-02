package com.zhowin.baselibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gyf.barlibrary.ImmersionBar;
import com.zhowin.baselibrary.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseFragment extends SupportFragment {

    //
    public BaseActivity mActivity;
    public View rootView;
    Unbinder unbinder;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = View.inflate(mActivity, getLayoutId(), null);
        unbinder= ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    public void initTitleBar(){
                ImmersionBar.with(this)
                .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
                .statusBarColor(R.color.white)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }


    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView();

    public void initListener(){}

    public  <E extends View> E get(int id) {
        return (E) rootView.findViewById(id);
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        initTitleBar();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ImmersionBar.with(this).destroy();
    }

    public void startActivity(Class clazz) {
        startActivity(clazz, null);
    }

    public void startActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(mActivity, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
