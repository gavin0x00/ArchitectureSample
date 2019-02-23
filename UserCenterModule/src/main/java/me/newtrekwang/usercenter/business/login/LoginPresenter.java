package me.newtrekwang.usercenter.business.login;

import com.trello.rxlifecycle2.LifecycleProvider;

import javax.inject.Inject;

import me.newtrekwang.baselibrary.common.BaseApplication;
import me.newtrekwang.baselibrary.ext.CommonExt;
import me.newtrekwang.baselibrary.presenter.BasePresenter;
import me.newtrekwang.baselibrary.rx.BaseSubscriber;
import me.newtrekwang.usercenter.data.protocal.TokenWrapper;
import me.newtrekwang.usercenter.data.service.UserCenterService;

/**
 * @author newtrekWang
 * @fileName LoginPresenter
 * @createDate 2018/9/3 14:28
 * @email 408030208@qq.com
 * @desc 登录界面业务处理者
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    @Inject
    public LoginPresenter(){}

    @Inject
    UserCenterService userCenterService;

    @Inject
    LifecycleProvider lifecycleProvider;

    @Inject
    BaseApplication baseApplication;

    /**
     * 登录
     * @param phone 手机号
     * @param pwd 密码
     */
    public void login(String phone,String pwd){
        if (!canUseNetWork(baseApplication)){
            return;
        }
        mView.showLoading();
        CommonExt.execute(userCenterService.login("0000", phone, pwd), new BaseSubscriber<TokenWrapper>(mView) {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(TokenWrapper tokenWrapper) {
                if (tokenWrapper!=null && tokenWrapper.getToken()!=null){
                    mView.loginSuccess(tokenWrapper.getToken());
                }
            }
        },lifecycleProvider);
    }
}
