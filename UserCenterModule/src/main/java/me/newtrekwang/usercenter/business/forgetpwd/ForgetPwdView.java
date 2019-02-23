package me.newtrekwang.usercenter.business.forgetpwd;

import me.newtrekwang.baselibrary.presenter.view.BaseView;

/**
 * @author newtrekWang
 * @fileName LoginView
 * @createDate 2018/9/3 14:26
 * @email 408030208@qq.com
 * @desc 注册验证界面视图层接口
 */
public interface ForgetPwdView extends BaseView{
    /**
     * 开始倒计时
     */
    void starCountDown();

    /**
     * 修改密码成功
     */
    void setPwdSuccess();

}
