package me.newtrekwang.usercenter.data.service;

import me.newtrekwang.usercenter.data.protocal.RegisterValidateRes;
import me.newtrekwang.usercenter.data.protocal.TokenWrapper;
import io.reactivex.Observable;

/**
 * @author newtrekWang
 * @fileName UserCenterService
 * @createDate 2018/9/3 14:14
 * @email 408030208@qq.com
 * @desc 用户中心服务接口,包括本地和网络的
 */
public interface UserCenterService {
    /**
     * 获取验证码
     * @param phoneNum 手机号
     * @return
     */
    Observable<Boolean> sendCodeToPhone( String phoneNum);

    /**
     * 注册验证
     * @param phoneNum
     * @param code
     * @return
     */
    Observable<RegisterValidateRes>  registerValidate(String phoneNum,String code);

    /**
     * 注册设置密码
     * @param id
     * @param pwd
     * @param userName
     * @return
     */
    Observable<TokenWrapper>  registerSetPwd(String id, String pwd, String userName);

    /**
     * 登录
     * @param code
     * @param userName
     * @param pwd
     * @return
     */
    Observable<TokenWrapper> login(String code,String userName,String pwd);

    /**
     * 重置密码
     * @param code
     * @param pwd
     * @param id
     * @param token
     * @param phoneNumber
     * @return
     */
    Observable<Boolean>  resetPassword(String code,String pwd,String id,String token,String phoneNumber);
}
