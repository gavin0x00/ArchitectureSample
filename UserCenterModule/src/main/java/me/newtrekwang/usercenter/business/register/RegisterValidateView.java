package me.newtrekwang.usercenter.business.register;

import me.newtrekwang.baselibrary.presenter.view.BaseView;

/**
 * @author newtrekWang
 * @fileName LoginView
 * @createDate 2018/9/3 14:26
 * @email 408030208@qq.com
 * @desc 注册验证界面视图层接口
 */
public interface RegisterValidateView extends BaseView{
    /**
     * 开始倒计时
     */
    void starCountDown();

    /**
     * 注册成功
     * @param token
     */
    void registerSuccess(String token);

}
