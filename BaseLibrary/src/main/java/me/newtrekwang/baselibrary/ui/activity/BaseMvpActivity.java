package me.newtrekwang.baselibrary.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import me.newtrekwang.baselibrary.common.BaseApplication;
import me.newtrekwang.baselibrary.injection.component.ActivityComponent;
import me.newtrekwang.baselibrary.injection.component.AppComponent;
import me.newtrekwang.baselibrary.injection.component.DaggerActivityComponent;
import me.newtrekwang.baselibrary.injection.module.LifeCycleComponentModule;
import me.newtrekwang.baselibrary.presenter.BasePresenter;
import me.newtrekwang.baselibrary.presenter.view.BaseView;
import me.newtrekwang.baselibrary.utils.ToastUtils;
import me.newtrekwang.baselibrary.widgets.LoadingDialog;

/**
 * @className BaseMvpActivity
 * @createDate 2018/7/16 9:16
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc mvpActivity基类
 *
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {
    /**
     * presenter
     */
    @Inject
    public T mPresenter;
    /**
     * activity的注入器
     */
   protected ActivityComponent activityComponent;
    /**
     * loading对话框
     */
   protected LoadingDialog loadingDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityInjection();
        initInjection();
        loadingDialog = new LoadingDialog(this);
    }

    /**
     * 初始化activity级别的注入器
     */
    private void initActivityInjection() {
        AppComponent appComponent =((BaseApplication) getApplication()).getAppComponent();
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .lifeCycleComponentModule(new LifeCycleComponentModule(this))
                .build();
    }

    /**
     * 让子类记得实现注入
     */
    protected abstract void initInjection();

    @Override
    public void onError(String error) {
        ToastUtils.showShort(error);
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showShort(msg);
    }

    @Override
    public void showLoading() {
        loadingDialog.showLoading();
    }

    @Override
    public void hideLoading() {
        loadingDialog.hideLoading();
    }
}
