package me.newtrekwang.baselibrary.presenter;

import android.content.Context;

import me.newtrekwang.baselibrary.presenter.view.BaseView;
import me.newtrekwang.baselibrary.utils.NetWorkUtils;


/**
 * @className BasePresenter
 * @createDate 2018/7/15 23:34
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc presenter基类
 * @param <T>
 *
 */
public class BasePresenter<T extends BaseView> {
    /**
     * 视图引用
     */
    public T mView;

    /**
     * 检查网络是否可用
     * @param context
     * @return
     */
    protected   boolean canUseNetWork(Context context){
        if (NetWorkUtils.isNetWorkAvailable(context)){
            return true;
        }
        mView.onError("网络不可用！");
        return  false;
    }
}
