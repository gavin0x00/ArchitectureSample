package me.newtrekwang.usercenter.business.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import me.newtrekwang.baselibrary.ui.activity.BaseMvpActivity;
import me.newtrekwang.baselibrary.utils.ButtonUtil;
import me.newtrekwang.baselibrary.widgets.ValidateButton;
import me.newtrekwang.provider.router.RouterPath;
import me.newtrekwang.usercenter.R;
import me.newtrekwang.usercenter.inject.DaggerUserCenterComponent;
import me.newtrekwang.usercenter.inject.UserCenterModule;

/**
 * @author newtrekWang
 * @fileName RegisterValidateActivity
 * @createDate 2018/10/10 9:43
 * @email 408030208@qq.com
 * @desc 注册验证码验证界面
 */
@Route(path = RouterPath.UserCenterModule.PATH_REGISTER_VALIDATE)
public class RegisterValidateActivity extends BaseMvpActivity<RegisterValidatePresenter> implements RegisterValidateView, ButtonUtil.ButtonEnable {

    private EditText etPhoneNum;
    private EditText etCode;
    private EditText etPwd;
    private EditText etPwdAgain;
    private ValidateButton validateButton;
    private Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_validate_activity);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        etPhoneNum = findViewById(R.id.register_et_phone);
        etCode = findViewById(R.id.register_et_code);
        etPwd = findViewById(R.id.register_et_pwd);
        etPwdAgain = findViewById(R.id.register_et_pwd_again);
        validateButton = findViewById(R.id.register_btn_get_code);
        btnRegister = findViewById(R.id.register_btn_register);

        ButtonUtil.enable(etPhoneNum,this);
        ButtonUtil.enable(etCode,this);
        ButtonUtil.enable(etPwd,this);
        ButtonUtil.enable(etPwdAgain,this);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone =etPhoneNum.getText().toString();
                if (phone.length()!= 11){
                    showToast("手机号位数有误！");
                    return;
                }
                mPresenter.getValidationCode(phone);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 先判断一下密码对不对应
                String phone = etPhoneNum.getText().toString();
                if (phone.length()!=11){
                    showToast("手机号位数有误！");
                    return;
                }
                String code = etCode.getText().toString();
                String pwd =etPwd.getText().toString();
                String pwdAgain =etPwdAgain.getText().toString();
                if (!pwd.equals(pwdAgain)){
                    showToast("两次输入密码不相同！");
                    return;
                }
                mPresenter.register(phone,code,pwd);
            }
        });
    }

    /**
     * 注入实例
     */
    @Override
    protected void initInjection() {
        DaggerUserCenterComponent.builder()
                .activityComponent(activityComponent)
                .userCenterModule(new UserCenterModule())
                .build()
                .inject(this);
        mPresenter.mView = this;
    }

    /**
     * 开始倒计时
     */
    @Override
    public void starCountDown() {
        validateButton.startCount();
    }

    @Override
    public void registerSuccess(String token) {
        showToast("注册成功！");
        ARouter.getInstance().build(RouterPath.UserCenterModule.PATH_LOGIN)
                .navigation();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        validateButton.removeRunnable();
    }

    /**
     * 更新注册按钮点击状态
     */
    @Override
    public void buttonEnable() {
        btnRegister.setEnabled(isButtonEnable());
    }


    /**
     * 当前注册按钮是否可以点击
     * @return 当前按钮是否可以点击
     */
    private boolean isButtonEnable(){
        String phone = etPhoneNum.getText().toString();
        if (TextUtils.isEmpty(phone)){
            return false;
        }
        String code = etCode.getText().toString();
        if (TextUtils.isEmpty(code)){
            return false;
        }
        String pwd =etPwd.getText().toString();
        if (TextUtils.isEmpty(pwd)){
            return false;
        }
        String pwdAgain = etPwdAgain.getText().toString();
        if (TextUtils.isEmpty(pwdAgain)){
            return false;
        }
        return true;
    }
}
