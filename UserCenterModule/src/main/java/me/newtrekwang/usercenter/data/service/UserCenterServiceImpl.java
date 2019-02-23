package me.newtrekwang.usercenter.data.service;

import javax.inject.Inject;

import me.newtrekwang.baselibrary.ext.CommonExt;
import me.newtrekwang.baselibrary.utils.SystemUtil;
import me.newtrekwang.usercenter.data.protocal.RegisterValidateRes;
import me.newtrekwang.usercenter.data.protocal.TokenWrapper;
import me.newtrekwang.usercenter.data.remote.FlyAudioUserRepository;
import io.reactivex.Observable;

/**
 * @author newtrekWang
 * @fileName UserCenterServiceImpl
 * @createDate 2018/9/3 14:17
 * @email 408030208@qq.com
 * @desc 用户中心服务一个具体实现
 */
public final class UserCenterServiceImpl implements UserCenterService{
    @Inject
    public UserCenterServiceImpl(){}
    @Inject
    FlyAudioUserRepository flyAudioUserRepository;

    @Override
    public Observable<Boolean> sendCodeToPhone(String phoneNum) {
        return CommonExt.convertBoolean(flyAudioUserRepository.sendCodeToPhone(SystemUtil.getLanguageSt(),phoneNum));
    }

    @Override
    public Observable<RegisterValidateRes> registerValidate(String phoneNum, String code) {
        return CommonExt.convert(flyAudioUserRepository.registerValide(SystemUtil.getLanguageSt(),phoneNum,code));
    }

    @Override
    public Observable<TokenWrapper> registerSetPwd(String id, String pwd, String userName) {
        return CommonExt.convert(flyAudioUserRepository.registerSetPwd(id,SystemUtil.getLanguageSt(),pwd,userName));
    }

    @Override
    public Observable<TokenWrapper> login(String code, String userName, String pwd) {
        return CommonExt.convert(flyAudioUserRepository.login(code,SystemUtil.getLanguageSt(),pwd,userName));
    }

    @Override
    public Observable<Boolean> resetPassword(String code, String pwd, String id, String token, String phoneNumber) {
        return CommonExt.convertBoolean(flyAudioUserRepository.resetPwd(code,SystemUtil.getLanguageSt(),pwd,phoneNumber,token,id));
    }
}
