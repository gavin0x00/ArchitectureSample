package me.newtrekwang.usercenter.business.login;

import me.newtrekwang.baselibrary.presenter.view.BaseView;

/**
 * @author newtrekWang
 * @fileName LoginView
 * @createDate 2018/9/3 14:26
 * @email 408030208@qq.com
 * @desc 登录界面视图层接口
 */
public interface LoginView extends BaseView{

    /**
     * 登录成功
     * @param token
     */
    void loginSuccess(String token);
}
