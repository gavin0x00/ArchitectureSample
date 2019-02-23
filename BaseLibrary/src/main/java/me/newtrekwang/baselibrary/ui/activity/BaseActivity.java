package me.newtrekwang.baselibrary.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import me.newtrekwang.baselibrary.common.AppManager;

/**
 * @author newtrekWang
 * @fileName BaseActivity
 * @createDate 2018/9/3 11:55
 * @email 408030208@qq.com
 * @desc activity基类
 */
public class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().finishAcitivity(this);
    }
}
