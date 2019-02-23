package me.newtrekwang.usercenter.business.register;

import com.trello.rxlifecycle2.LifecycleProvider;

import javax.inject.Inject;

import me.newtrekwang.baselibrary.common.BaseApplication;
import me.newtrekwang.baselibrary.common.BaseConstant;
import me.newtrekwang.baselibrary.ext.CommonExt;
import me.newtrekwang.baselibrary.presenter.BasePresenter;
import me.newtrekwang.baselibrary.rx.BaseSubscriber;
import me.newtrekwang.baselibrary.utils.AppPrefsUtils;
import me.newtrekwang.baselibrary.utils.ResourceUtil;
import me.newtrekwang.usercenter.R;
import me.newtrekwang.usercenter.data.protocal.RegisterValidateRes;
import me.newtrekwang.usercenter.data.protocal.TokenWrapper;
import me.newtrekwang.usercenter.data.service.UserCenterService;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author newtrekWang
 * @fileName RegisterValidatePresenter
 * @createDate 2018/10/10 9:43
 * @email 408030208@qq.com
 * @desc 注册验证码验证业务处理类
 */
public class RegisterValidatePresenter extends BasePresenter<RegisterValidateView> {
    private static final String TAG = "RegisterValidatePresent";
    @Inject
    public RegisterValidatePresenter(){}

    @Inject
    UserCenterService userCenterService;
    @Inject
    LifecycleProvider lifecycleProvider;
    @Inject
    BaseApplication baseApplication;

    /**
     * 注册
     * @param phone
     * @param code
     * @param pwd
     */
    public void register(final String phone,final String code,final String pwd){
        if (!canUseNetWork(baseApplication)){
            return;
        }
        mView.showLoading();
        userCenterService.registerValidate(phone,code)
                .concatMap(new Function<RegisterValidateRes, ObservableSource<TokenWrapper>>() {
                    @Override
                    public ObservableSource<TokenWrapper> apply(RegisterValidateRes registerValidateRes) throws Exception {
                        if (registerValidateRes.isExist()){
                            // 已存在用户
                            return Observable.error(new Throwable("手机号已注册，请直接登录！"));
                        }else {
                            return userCenterService.registerSetPwd(registerValidateRes.getId(),pwd,phone);
                        }
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifecycleProvider.bindToLifecycle())
                .subscribe(new BaseSubscriber<TokenWrapper>(mView) {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onComplete() {
                super.onComplete();
            }

            @Override
            public void onNext(TokenWrapper  tokenWrapper) {
                if (tokenWrapper!=null && tokenWrapper.getToken() != null){
                    mView.registerSuccess(tokenWrapper.getToken());
                    AppPrefsUtils.getInstance().putString(BaseConstant.KEY_SP_TOKEN,tokenWrapper.getToken());
                }else {
                    mView.showToast("注册异常！没有token");
                }
            }
        });
    }

    /**
     * 获取验证码
     * @param phoneNumber
     */
    public void getValidationCode(String  phoneNumber){
        if (!canUseNetWork(baseApplication)){
            return;
        }
        mView.showLoading();
        CommonExt.execute(userCenterService.sendCodeToPhone(phoneNumber), new BaseSubscriber<Boolean>(mView) {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean){
                    mView.showToast("获取验证码成功！");
                    mView.starCountDown();
                }else {
                    mView.onError(ResourceUtil.getResString(R.string.validate_failed));
                }
            }
        }, lifecycleProvider);
    }

}
