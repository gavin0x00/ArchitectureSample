package me.newtrekwang.usercenter.inject;

import me.newtrekwang.baselibrary.injection.PerComponentScope;
import me.newtrekwang.baselibrary.injection.component.ActivityComponent;
import me.newtrekwang.usercenter.business.forgetpwd.ForgetPwdActivity;
import me.newtrekwang.usercenter.business.login.LoginActivity;
import me.newtrekwang.usercenter.business.register.RegisterValidateActivity;
import dagger.Component;

/**
 * @author newtrekWang
 * @fileName UserCenterComponent
 * @createDate 2018/9/3 14:11
 * @email 408030208@qq.com
 * @desc 用户中心模块注入器
 */
@PerComponentScope
@Component(dependencies = {ActivityComponent.class},modules = {UserCenterModule.class})
public interface UserCenterComponent {
    /**
     * 注入LoginActivity
     * @param loginActivity
     */
    void inject(LoginActivity loginActivity);

    /**
     * 注入到RegisterValidateActivity
     * @param registerValidateActivity
     */
    void inject(RegisterValidateActivity registerValidateActivity);

    /**
     * 注入到ForgetPwdActivity
     * @param forgetPwdActivity
     */
    void inject(ForgetPwdActivity forgetPwdActivity);
}
