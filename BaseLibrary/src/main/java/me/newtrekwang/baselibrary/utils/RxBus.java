package me.newtrekwang.baselibrary.utils;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import io.reactivex.Observable;

/**
 * @className RxBus
 * @createDate 2018/7/15 23:40
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 事件总线,用于模块间通信
 *
 */
public final class RxBus {

    private static volatile RxBus instance;

    private final Relay<Object> mBus;

    private RxBus(){
        this.mBus = PublishRelay.create().toSerialized();
    }

    public static RxBus getDefault(){
        if (instance == null){
            synchronized (RxBus.class){
            if (instance == null){
                instance = new RxBus();
            }
            }
        }
        return instance;
    }
    /**
     * post
     * @param obj
     */
    public void post(Object obj){
        mBus.accept(obj);
    }

    public <T> Observable<T> toObservable(Class<T> tClass){
        return mBus.ofType(tClass);
    }

    public Observable<Object>  toObservable(){
        return mBus;
    }

    public boolean hasObservers(){
        return mBus.hasObservers();
    }
}
