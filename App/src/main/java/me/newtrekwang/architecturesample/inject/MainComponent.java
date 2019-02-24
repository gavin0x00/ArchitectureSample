package me.newtrekwang.architecturesample.inject;


import dagger.Component;
import me.newtrekwang.architecturesample.business.main.MainActivity;
import me.newtrekwang.baselibrary.injection.PerComponentScope;
import me.newtrekwang.baselibrary.injection.component.ActivityComponent;

/**
 * @author newtrekWang
 * @fileName MainComponent
 * @createDate 2018/9/3 15:07
 * @email 408030208@qq.com
 * @desc 主模块注入器
 */
@PerComponentScope
@Component(dependencies = {ActivityComponent.class},modules = {MainModule.class})
public interface MainComponent {
    /**
     * 注入到MainActivity
     * @param mainActivity
     */
    void inject(MainActivity mainActivity);
}
