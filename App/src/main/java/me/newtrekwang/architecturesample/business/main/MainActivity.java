package me.newtrekwang.architecturesample.business.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import me.newtrekwang.architecturesample.R;
import me.newtrekwang.architecturesample.business.modulethree.ThreeFragment;
import me.newtrekwang.architecturesample.inject.DaggerMainComponent;
import me.newtrekwang.architecturesample.inject.MainModule;
import me.newtrekwang.baselibrary.ui.activity.BaseMvpActivity;
import me.newtrekwang.baselibrary.utils.BottomNavigationViewHelper;
import me.newtrekwang.provider.router.RouterPath;

/**
 * @className MainActivity
 * @createDate 2019/2/23 16:46
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 首页
 *
 */
@Route(path = RouterPath.MainModule.PATH_MAIN)
public class MainActivity extends BaseMvpActivity<MainPresenter> implements  MainView {

    /**
     * 底部导航栏
     */
    private BottomNavigationView mBottomNavigationView;
    /**
     * 装碎片的容器
     */
    private FrameLayout mFrameLayout;
    /**
     * 当前显示碎片
     */
    private Fragment mCurrentFragment;
    /**
     * 碎片1
     */
    private Fragment mOneFragment;
    /**
     * 碎片2
     */
    private Fragment mTwoFragment;
    /**
     * 碎片3
     */
    private Fragment mThreeFragment;
    /**
     * 个人中心碎片
     */
    private Fragment mUserInfoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        changeToFragment(mOneFragment);
    }

    @Override
    protected void initInjection() {
        DaggerMainComponent.builder()
                .activityComponent(activityComponent)
                .mainModule(new MainModule())
                .build()
                .inject(this);
        mPresenter.mView = this;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        // module one 里的碎片，隐式获取
        mOneFragment = (Fragment) ARouter.getInstance().build(RouterPath.OneModule.PATH_FRAGMENT_ONE).navigation();
        // module two 里的碎片，隐式获取
        mTwoFragment = (Fragment) ARouter.getInstance().build(RouterPath.TwoModule.PATH_FRAGMENT_TWO).navigation();
        // 本Module里的碎片，直接获取，也可以隐式获取
        mThreeFragment = new ThreeFragment();
        // 用户中心的碎片，隐式获取，与用户中心Module解耦
        mUserInfoFragment = (Fragment) ARouter.getInstance().build(RouterPath.UserCenterModule.PATH_USERINFO).navigation();
    }

    /**
     * 初始化View
     */
    private void initView(){
        mBottomNavigationView = findViewById(R.id.main_bottom_nv);
        mFrameLayout = findViewById(R.id.main_fy_container);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.main_bottom_nav_module_one:
                        return changeToFragment(mOneFragment);
                    case R.id.main_bottom_nav_module_two:
                        return changeToFragment(mTwoFragment);
                    case R.id.main_bottom_nav_module_three:
                        return  changeToFragment(mThreeFragment);
                    case R.id.main_bottom_nav_personal:
                        return changeToFragment(mUserInfoFragment);
                    default:
                        break;
                }
                return false;
            }
        });
    }


    /**
     * 切换显示碎片
     * @param to 切换到哪个碎片
     * @return 是否能切换
     */
    private boolean changeToFragment(Fragment to){
        if (to == null){
            showToast("碎片为null！");
            return false;
        }
        Fragment from = mCurrentFragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (from == null){
            fragmentTransaction.add(R.id.main_fy_container,to).commit();
            mCurrentFragment = to;
        }else {
            if (from!=to){
                if (!to.isAdded()){
                    // 先判断是否被add过
                    fragmentTransaction.hide(from).add(R.id.main_fy_container,to).commit();
                }else {
                    // 隐藏当前的fragment，显示下一个
                    fragmentTransaction.hide(from).show(to).commit();
                }
                mCurrentFragment = to;
            }
        }
        return true;
    }
}
