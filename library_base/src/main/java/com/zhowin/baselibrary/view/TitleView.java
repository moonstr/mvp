package com.zhowin.baselibrary.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhowin.baselibrary.R;

/**
 * Created by apple on 18/6/23.
 */

public class TitleView extends RelativeLayout {
    private View mRootView;
    private ImageView mBack;
    private TextView mTitle;
    private TextView mRightText;
    private ImageView mRightImage;
    private LinearLayout mRightLl;

    private int titleColor = Color.WHITE;
    private int mRightTextColor = Color.WHITE;
    private int mBackGroundColor = Color.WHITE;
    private float titleSize = 16;
    private String title;
    private Drawable ivRightSrc;
    private Drawable ivLeftSrc;
    private boolean showBack;
    String rightText;
    public TitleView(Context context) {
        super(context);
        initView(context);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray=context.obtainStyledAttributes(attrs, R.styleable.TitleView);
        titleColor = mTypedArray.getColor(R.styleable.TitleView_mTitleColor, Color.WHITE);
        titleSize = mTypedArray.getDimension(R.styleable.TitleView_mTitleSize, 16);
        title = mTypedArray.getString(R.styleable.TitleView_mTitle);
        ivRightSrc = mTypedArray.getDrawable(R.styleable.TitleView_mRightImage);
        ivLeftSrc = mTypedArray.getDrawable(R.styleable.TitleView_mLeftSrc);
        rightText = mTypedArray.getString(R.styleable.TitleView_mRightText);
        mRightTextColor = mTypedArray.getColor(R.styleable.TitleView_mRightTextColor, Color.WHITE);
        mBackGroundColor=mTypedArray.getColor(R.styleable.TitleView_mBackgroundColor, Color.WHITE);
        showBack=mTypedArray.getBoolean(R.styleable.TitleView_mLeftVisible,true);
        mTypedArray.recycle();
        initView(context);
    }
    private void initView(final Context context){
        mRootView= LayoutInflater.from(context).inflate(R.layout.view_title, this, true);
        mRootView.setBackgroundColor(mBackGroundColor);
        mBack = findViewById(R.id.back);
        mTitle = findViewById(R.id.title);
        mRightText = findViewById(R.id.ritht_tv);
        mRightLl = findViewById(R.id.ll_right);
        mRightImage = findViewById(R.id.ritht_iv);
        mBack.setVisibility(showBack?VISIBLE:GONE);

        mTitle.setText(title);
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,titleSize);
        mTitle.setTextColor(titleColor);

        mBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).finish();
            }
        });

        if (ivRightSrc!=null){
            mRightImage.setBackgroundDrawable(ivRightSrc);
        }

        if (rightText!=null){
            mRightText.setText(rightText);
            mRightText.setTextColor(mRightTextColor);
        }
        if (ivLeftSrc!=null){
            mBack.setImageDrawable(ivLeftSrc);
        }
    }

    public TextView setRightTextViewClick(OnClickListener listener){
        mRightText.setOnClickListener(listener);
        return mRightText;
    }

    public void setRightImageViewClick(OnClickListener listener)
    {
        mRightImage.setOnClickListener(listener);
    }
    public TextView getRightTextView(){
        return mRightText;
    }

    public TextView getTitle(){
        return mTitle;
    }

    public LinearLayout getRightLl(){
        return mRightLl;
    }
    public void setTitle(String title){
        mTitle.setText(title);
        this.title = title;
    }
    public void setBackListener(OnClickListener listener){
        mBack.setOnClickListener(listener);
    }
    public void setmRootViewBackGround(int color){
        mRootView.setBackgroundColor(color);
    }

}
