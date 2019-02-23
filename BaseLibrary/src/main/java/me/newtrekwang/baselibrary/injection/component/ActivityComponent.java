package me.newtrekwang.baselibrary.injection.component;

import com.trello.rxlifecycle2.LifecycleProvider;

import me.newtrekwang.baselibrary.common.BaseApplication;
import me.newtrekwang.baselibrary.injection.ActivityScope;
import me.newtrekwang.baselibrary.injection.module.LifeCycleComponentModule;
import dagger.Component;

/**
 * @className ActivityComponent
 * @createDate 2018/7/16 9:13
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc activity层级注射器
 *
 */
@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {LifeCycleComponentModule.class})
public interface ActivityComponent {
    /**
     * 暴露lifeCycle
     * @return
     */
    LifecycleProvider lifecycle();
    /**
     * 暴露application context
     * @return
     */
   BaseApplication baseApplication();
}
