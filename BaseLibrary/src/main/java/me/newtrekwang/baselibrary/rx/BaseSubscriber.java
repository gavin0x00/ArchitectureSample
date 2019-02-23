package me.newtrekwang.baselibrary.rx;


import me.newtrekwang.baselibrary.presenter.view.BaseView;
import me.newtrekwang.baselibrary.utils.ExceptionHandle;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * @className BaseSubscriber
 * @createDate 2018/7/15 23:32
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 基础的订阅类
 * @param <T>
 *
 */
public abstract class BaseSubscriber<T> implements Observer<T> {
    /**
     * view层的引用，可以做一些通用的view显示
     */
    public BaseView baseView;

    public BaseSubscriber(BaseView baseView){
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
    public void onComplete() {
        // 关闭loading
        baseView.hideLoading();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }
}
