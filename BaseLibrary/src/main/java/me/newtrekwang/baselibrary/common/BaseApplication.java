package me.newtrekwang.baselibrary.common;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.alibaba.android.arouter.launcher.ARouter;

import me.newtrekwang.baselibrary.injection.component.AppComponent;
import me.newtrekwang.baselibrary.injection.component.DaggerAppComponent;
import me.newtrekwang.baselibrary.injection.module.AppModule;
import me.newtrekwang.baselibrary.utils.AppUtils;

/**
 * @author newtrekWang
 * @fileName BaseApplication
 * @createDate 2018/9/3 11:43
 * @email 408030208@qq.com
 * @desc 基础Application类，用来暴露一些全局对象，或者基础配置
 */
public class BaseApplication extends Application {

    /**
     * vector兼容5.0以下系统
     */
    static {
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion < 21){
            //适配android5.0以下
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }
    }

    private static BaseApplication baseApplication;
    /**
     * app层级注入器
     */
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(this);
        initAppInjection();
        initARouter();
        baseApplication = this;
    }

    /**
     * 初始化ARouter
     */
    private void initARouter() {
        if (BaseConstant.isDebug){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }

    /**
     * 初始化app层级注入器
     */
    private void initAppInjection() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(BaseApplication.this))
                .build();
    }

    /**
     * 获取application单例
     * @return baseApplication
     */
    public static BaseApplication getBaseApplication(){
        return baseApplication;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
