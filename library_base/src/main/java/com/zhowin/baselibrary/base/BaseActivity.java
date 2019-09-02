package com.zhowin.baselibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhowin.baselibrary.R;
import com.zhowin.baselibrary.utils.ActivityManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseActivity extends SupportActivity {
    Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ActivityManager.getAppInstance().addActivity(this);
        unbinder= ButterKnife.bind(this);
        initImmersionBar();
        initView();
        initData();
        initListener();
    }

    public abstract int getLayoutId();
    public abstract void initView();
    public abstract void initData();
    public void initListener(){}

    public  <E extends View> E get(int id) {
        return (E) findViewById(id);
    }

    public void startActivity(Class clazz) {
        startActivity(clazz, null);
    }

    public void startActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void initImmersionBar(){
        ImmersionBar.with(this)
                .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
                .statusBarColor(R.color.white)
                .keyboardEnable(true)
                .statusBarDarkFont(true, 0.2f)
                .init();
//        ImmersionBar.with(this).navigationBarColor(R.color.white).init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
        ActivityManager.getAppInstance().removeActivity(this);
        unbinder.unbind();
    }
    public View getEmptyView(int resId,String desc){
        View view=View.inflate(this,R.layout.view_empty,null);
        ImageView image=view.findViewById(R.id.image);
        TextView text=view.findViewById(R.id.text);
        image.setImageResource(resId);
        text.setText(desc);
        return view;
    }
}
