package me.newtrekwang.baselibrary.injection.module;


import javax.inject.Singleton;

import me.newtrekwang.baselibrary.common.BaseApplication;
import dagger.Module;
import dagger.Provides;

/**
 * @className AppModule
 * @createDate 2018/7/16 9:08
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc app module
 *
 */
@Module
public class AppModule {
    /**
     * application实例
     */
    private BaseApplication baseApplication;

    /**
     * 注入application实例
     * @param baseApplication
     */
    public AppModule(BaseApplication baseApplication){
        this.baseApplication = baseApplication;
    }

    /**
     * 提供application实例
     * @return application实例
     */
    @Provides
    @Singleton
    public BaseApplication providesContext(){
        return this.baseApplication;
    }
}
