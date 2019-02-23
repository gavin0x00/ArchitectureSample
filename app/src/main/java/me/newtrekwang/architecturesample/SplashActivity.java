package me.newtrekwang.architecturesample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

import me.newtrekwang.provider.router.RouterPath;


/**
 * @author newtrekWang
 * @fileName SplashActivity
 * @createDate 2018/9/3 16:26
 * @email 408030208@qq.com
 * @desc Splash界面
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 根据项目开发情况调整入口

        // 直接去首页
        ARouter.getInstance().build(RouterPath.MainModule.PATH_MAIN).navigation();
//        // 去登录界面
//        ARouter.getInstance().build(RouterPath.UserCenterModule.PATH_LOGIN)
//                .navigation();
        finish();
    }
}
