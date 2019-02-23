package me.newtrekwang.usercenter.business.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import me.newtrekwang.baselibrary.ui.activity.BaseMvpActivity;
import me.newtrekwang.baselibrary.utils.ButtonUtil;
import me.newtrekwang.provider.router.RouterPath;
import me.newtrekwang.usercenter.R;
import me.newtrekwang.usercenter.inject.DaggerUserCenterComponent;
import me.newtrekwang.usercenter.inject.UserCenterModule;

/**
 * @className LoginActivity
 * @createDate 2018/9/3 14:09
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 登录界面
 *
 */
@Route(path = RouterPath.UserCenterModule.PATH_LOGIN)
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView, View.OnClickListener ,ButtonUtil.ButtonEnable{
    private static final String TAG = "LoginActivity";
    /**
     * 登录提交按钮
     */
    private Button btnLogin;
    /**
     * 注册按钮
     */
    private Button btnRegister;
    /**
     * 忘记密码链接文本
     */
    private TextView tvForgetPwd;
    /**
     * 手机号输入框
     */
    private EditText etPhoneNum;
    /**
     * 密码输入框
     */
    private EditText etPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        btnLogin = findViewById(R.id.login_btn_login);
        btnRegister = findViewById(R.id.login_btn_register);
        etPhoneNum = findViewById(R.id.login_et_phone);
        etPwd = findViewById(R.id.login_et_pwd);
        tvForgetPwd = findViewById(R.id.login_tv_forget_pwd);
        // 监听编辑框，自动更新登录按钮可点击状态
        ButtonUtil.enable(etPhoneNum,this);
        ButtonUtil.enable(etPwd,this);
        // 点击事件
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        tvForgetPwd.setOnClickListener(this);
    }

    @Override
    protected void initInjection() {
        DaggerUserCenterComponent.builder()
                .activityComponent(activityComponent)
                .userCenterModule(new UserCenterModule())
                .build()
                .inject(this);
        mPresenter.mView =this;
    }


    /**
     * 点击事件处理
     * @param v 控件
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn_login){
            mPresenter.login(etPhoneNum.getText().toString(),etPwd.getText().toString());
        }else if (v.getId() == R.id.login_btn_register){
            // 跳转到注册验证界面
            ARouter.getInstance()
                    .build(RouterPath.UserCenterModule.PATH_REGISTER_VALIDATE)
                    .navigation();
        }else if (v.getId() == R.id.login_tv_forget_pwd){
            ARouter.getInstance()
                    .build(RouterPath.UserCenterModule.PATH_FORGET_PWD)
                    .navigation();
        }
    }

    /**
     * 更新按钮可点击状态
     */
    @Override
    public void buttonEnable() {
        btnLogin.setEnabled(isButtonEnable());
    }

    /**
     * 当前按钮是否可以点击
     * @return 当前按钮是否可以点击
     */
    private boolean isButtonEnable(){
        String phone = etPhoneNum.getText().toString();
        if (TextUtils.isEmpty(phone)){
            return false;
        }
        String pwd =etPwd.getText().toString();
        if (TextUtils.isEmpty(pwd)){
            return false;
        }
        return true;
    }

    /**
     * 登录成功
     * @param token token
     */
    @Override
    public void loginSuccess(String token) {
       ARouter.getInstance().build(RouterPath.MainModule.PATH_MAIN).navigation();
       finish();
    }
}
