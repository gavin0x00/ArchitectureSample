package me.newtrekwang.baselibrary.ext;

import com.trello.rxlifecycle2.LifecycleProvider;

import me.newtrekwang.baselibrary.data.protocal.BaseResp;
import me.newtrekwang.baselibrary.rx.BaseFunc;
import me.newtrekwang.baselibrary.rx.BaseFuncBoolean;
import me.newtrekwang.baselibrary.rx.BaseSubscriber;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @className CommonExt
 * @createDate 2018/7/16 9:05
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 扩展工具类
 *
 */
public final class CommonExt {
    /**
     * 执行订阅，并绑定生命周期
     * @param observable 被观察者
     * @param subscriber 观察者
     * @param lifecycleProvider 生命周期提供者
     */
    public static  void execute(Observable observable, BaseSubscriber subscriber, LifecycleProvider lifecycleProvider){
        observable.observeOn(AndroidSchedulers.mainThread())
                .compose(lifecycleProvider.bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }
    /**
     * 将Observable<BaseResp<T>>变换为Observable<T>
     */
    public static <T> Observable<T> convert (Observable<BaseResp<T>> observable){
       return observable.flatMap(new BaseFunc<T>());
    }
    /**
     * 将Observable<BaseResp<T>>变换为Observable<Boolean>
     */
    public static <T> Observable<Boolean> convertBoolean(Observable<BaseResp> observable){
        return observable.flatMap(new BaseFuncBoolean());
    }


}
