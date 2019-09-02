package com.zhowin.baselibrary.mvp;

public interface IPresenter <VIEW extends IView>{
    void attach(VIEW view);
    void detach();
}
