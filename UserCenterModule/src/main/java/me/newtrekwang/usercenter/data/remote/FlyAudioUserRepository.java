package me.newtrekwang.usercenter.data.remote;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import me.newtrekwang.baselibrary.data.net.RetrofitFactory;
import me.newtrekwang.baselibrary.data.protocal.BaseResp;
import me.newtrekwang.usercenter.data.protocal.BaseUserInfo;
import me.newtrekwang.usercenter.data.protocal.LoginForm;
import me.newtrekwang.usercenter.data.protocal.RegisterForm;
import me.newtrekwang.usercenter.data.protocal.RegisterValidateRes;
import me.newtrekwang.usercenter.data.protocal.ResetPwdForm;
import me.newtrekwang.usercenter.data.protocal.SMSEmailForm;
import me.newtrekwang.usercenter.data.protocal.SMSPhoneForm;
import me.newtrekwang.usercenter.data.protocal.SkipReqForm;
import me.newtrekwang.usercenter.data.protocal.TokenWrapper;
import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author newtrekWang
 * @fileName FlyAudioUserRepository
 * @createDate 2018/10/10 9:51
 * @email 408030208@qq.com
 * @desc 飞歌系统用户接口数据仓库
 */
public final class FlyAudioUserRepository {
    @Inject
    public FlyAudioUserRepository(){}

    /**
     * 发送短信验证码
     * @param language
     * @param phoneNum
     * @return
     */
    public Observable<BaseResp> sendCodeToPhone(String language,String phoneNum){
        SMSPhoneForm smsForm = new SMSPhoneForm(language,phoneNum);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .sendCodeToPhone(smsForm);
    }

    /**
     * 校验短信验证码
     * @param phone
     * @param code
     * @param language
     * @return
     */
    public Observable<BaseResp> validatePhoneCode(String phone,String code,String language){
        Map<String ,String > form = new HashMap<>(3);
        form.put("code",code);
        form.put("language",language);
        form.put("phone",phone);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .validatePhoneCode(form);
    }
    /**
     * 发送邮箱验证码
     * @param language
     * @param email
     * @return
     */
    public Observable<BaseResp>  sendCodeToEmail(String language,String email){
        SMSEmailForm smsEmailForm = new SMSEmailForm(language,email);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .sendCodeToEmail(smsEmailForm);
    }

    /**
     * 发送邮箱验证码
     * @param email
     * @param code
     * @param language
     * @return
     */
    public Observable<BaseResp> validateEmailCode(String email,String code,String language){
        Map<String,String > form = new HashMap<>(3);
        form.put("code",code);
        form.put("email",email);
        form.put("language",language);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .validateEmailCode(form);
    }

    /**
     * 注册验证
     * @param language
     * @param phoneNum
     * @param code
     * @return
     */
    public Observable<BaseResp<RegisterValidateRes>> registerValide(String language,String phoneNum,String code){
        SkipReqForm skipReqForm = new SkipReqForm(code,language,phoneNum);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .registerValide(skipReqForm);
    }

    /**
     * 注册设置用户信息
     * @param id
     * @param language
     * @param pwd
     * @param userName
     * @return
     */
    public Observable<BaseResp<TokenWrapper>> registerSetPwd(String id, String language, String pwd, String userName){
        RegisterForm registerForm = new RegisterForm(id,language,pwd,pwd,userName);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .registerSetPwd(registerForm);
    }

    /**
     * 登录
     * @param code
     * @param language
     * @param pwd
     * @param userName
     * @return
     */
    public Observable<BaseResp<TokenWrapper>> login(String code,String language,String pwd,String userName){
        LoginForm loginForm = new LoginForm(code,language,pwd,userName);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .login(loginForm);
    }

    /**
     *  重置密码
     * @param code 验证码
     * @param language 语言
     * @param pwd
     * @param phone
     * @param userId
     * @return
     */
    public Observable<BaseResp>  resetPwd(String code,String language,String pwd,String phone,String token,String userId){
        ResetPwdForm resetPwdForm = new ResetPwdForm(code,language,pwd,phone,pwd,token,userId);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .resetPassword(resetPwdForm);
    }

    /**
     * 获取用户信息
     * @param token
     * @param language
     * @return
     */
    public Observable<BaseResp> getUserInfo(String token,String language){
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .getUserInfo(token,language);
    }

    /**
     * 更新用户信息
     * @param address
     * @param birthday
     * @param id
     * @param language
     * @param sex
     * @param token
     * @param userName
     * @return
     */
    public Observable<BaseResp> updateUserInfo(String address,String birthday,String id,String language,int sex,String token,String userName){
        BaseUserInfo baseUserInfo = new BaseUserInfo(address, birthday, id, language, sex, token, userName);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .updateUserInfo(baseUserInfo);
    }

    /**
     * 更改邮箱
     * @param code
     * @param language
     * @param newEmail
     * @param token
     * @param userId
     * @return
     */
    public Observable<BaseResp>  modifyEmailById(String code,String language,String newEmail,String token,String userId){
        Map<String,String>  form = new HashMap<>(5);
        form.put("code",code);
        form.put("language",language);
        form.put("newEmail",newEmail);
        form.put("token",token);
        form.put("userId",userId);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .modifyEmailById(form);
    }

    /**
     * 更改手机号
     * @param code
     * @param language
     * @param newPhone
     * @param token
     * @param userId
     * @return
     */
    public Observable<BaseResp>  modifyPhoneById(String code,String language,String newPhone,String token,String userId){
        Map<String,String>  form = new HashMap<>(5);
        form.put("code",code);
        form.put("language",language);
        form.put("newPhone",newPhone);
        form.put("token",token);
        form.put("userId",userId);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .modifyPhoneById(form);
    }

    /**
     * 上传头像
     * @param iconFile
     * @return
     */
    public Observable<BaseResp>  uploadUserIcon(File iconFile){
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"),iconFile);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file",iconFile.getName(),requestFile);
        return RetrofitFactory.getRetrofit().create(FlyAudioUserService.class)
                .uploadUserHeadImg(body);
    }
}
