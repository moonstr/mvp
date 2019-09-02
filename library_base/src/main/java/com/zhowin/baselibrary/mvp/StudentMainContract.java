package com.zhowin.baselibrary.mvp;

/**
 * Created by ljp on 2018/9/20.
 * <p>
 * model和view接口基础接口管理
 */
public interface StudentMainContract {

    /**
     * mode和present交互接口，具体网络操作
     */
    interface Model extends IModel {

        /**
         * 学段选择数据请求接口
         */

    }

    /**
     * 负责更新ui接口
     */
    interface View extends IView {
        /**
         * 更新学段ui接口
         */
    }

    /**
     * view和present交互接口，view中调用，present实现
     */
    interface Presenter extends IPresenter<View> {
        /**
         * 获取学段网络接口
         */
        void getHttpStudentSectionData();
    }
}
