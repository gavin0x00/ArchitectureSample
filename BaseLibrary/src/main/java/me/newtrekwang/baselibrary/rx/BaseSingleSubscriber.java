package me.newtrekwang.baselibrary.rx;

import me.newtrekwang.baselibrary.presenter.view.BaseView;
import me.newtrekwang.baselibrary.utils.ExceptionHandle;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * @author newtrekWang
 * @fileName BaseSingleSubscriber
 * @createDate 2018/7/25 18:08
 * @email 408030208@qq.com
 * @desc 基础的Single订阅类
 * @param <T>
 */
public abstract class BaseSingleSubscriber<T> implements SingleObserver<T> {
    /**
     * view层的引用，可以做一些通用的view显示
     */
    public BaseView baseView;

    public BaseSingleSubscriber(BaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public void onError(Throwable e) {
        // 关闭loading
        baseView.hideLoading();
        // 异常处理
        ExceptionHandle.ResponseException exception = ExceptionHandle.handleException(e);
        baseView.onError(exception.message);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(T t) {
        // 关闭loading
        baseView.hideLoading();
    }


}
