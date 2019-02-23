package me.newtrekwang.usercenter.data.remote;



import java.util.Map;

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
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * @author newtrekWang
 * @fileName FlyAudioUserService
 * @createDate 2018/10/10 9:23
 * @email 408030208@qq.com
 * @desc 飞歌系统用户相关接口
 */
public  interface FlyAudioUserService {
    /**
     * 发送短信验证码
     * @param smsForm  表单
     * @return
     */
    @POST("sms/sendCodeToPhone")
    Observable<BaseResp> sendCodeToPhone(@Body SMSPhoneForm smsForm);

    /**
     * 校验短信验证码是否正确
     * @param smsPhoneForm
     * @return
     */
    @POST("sms/validationCode")
    Observable<BaseResp>  validatePhoneCode(@Body Map<String,String> smsPhoneForm);
    /**
     * 发送邮箱验证码
     * @param smsEmailForm
     * @return
     */
    @POST("sms/sendCodeToEmail")
    Observable<BaseResp>  sendCodeToEmail(@Body SMSEmailForm smsEmailForm);

    /**
    * 校验邮箱验证码是否正确
     * @param smsEmailForm
     * @return
     */
    @POST("sms/validationEmailCode")
    Observable<BaseResp> validateEmailCode(@Body Map<String,String> smsEmailForm);
    /**
     * 注册验证验证码
     * @param skipReqForm
     * @return
     */
    @POST("registerSkip")
    Observable<BaseResp<RegisterValidateRes>> registerValide(@Body SkipReqForm skipReqForm);

    /**
     * 注册设置密码
     * @param registerForm
     * @return
     */
    @POST("submitRegistered")
    Observable<BaseResp<TokenWrapper>> registerSetPwd(@Body RegisterForm registerForm);

    /**
     * 登录
     * @param loginForm
     * @return
     */
    @POST("login")
    Observable<BaseResp<TokenWrapper>> login(@Body LoginForm loginForm);

    /**
     * 重置密码
     * @param resetPwdForm
     * @return
     */
    @POST("resetPassword")
    Observable<BaseResp> resetPassword(@Body ResetPwdForm resetPwdForm);

    /**
     * 获取用户信息
     * @param token
     * @param language
     * @return
     */
    @POST("getUserInfo/{token}/{language}")
    Observable<BaseResp> getUserInfo(@Path("token")String token,@Path("language") String language);

    /**
     * 更新用户信息
     * @param baseUserInfo
     * @return
     */
    @POST("updateUserMsg")
    Observable<BaseResp> updateUserInfo(@Body BaseUserInfo baseUserInfo);

    /**
     * 更改邮箱
     * @param modifyEmailForm
     * @return
     */
    @POST("modifyEmailById")
    Observable<BaseResp> modifyEmailById(@Body Map<String,String>  modifyEmailForm);

    /**
     * 更改手机号
     * @param modifyPhoneForm
     * @return
     */
    @POST("modifyPhoneById")
    Observable<BaseResp> modifyPhoneById(@Body Map<String,String>  modifyPhoneForm);

    /**
     * 上传用户头像
     * @param file
     * @return
     */
    @Multipart
    @POST("uploadUserHeahImag")
    Observable<BaseResp> uploadUserHeadImg(@Part MultipartBody.Part file);
}
