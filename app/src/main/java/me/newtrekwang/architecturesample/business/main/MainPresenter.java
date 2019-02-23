package me.newtrekwang.architecturesample.business.main;

import com.trello.rxlifecycle2.LifecycleProvider;

import javax.inject.Inject;

import me.newtrekwang.baselibrary.common.BaseApplication;
import me.newtrekwang.baselibrary.presenter.BasePresenter;


/**
 * @author newtrekWang
 * @fileName MainPresenter
 * @createDate 2018/10/11 9:01
 * @email 408030208@qq.com
 * @desc 首页业务处理类
 */
public class MainPresenter extends BasePresenter<MainView> {
    @Inject
    public MainPresenter(){}
    @Inject
    BaseApplication baseApplication;
    @Inject
    LifecycleProvider lifecycleProvider;


}
