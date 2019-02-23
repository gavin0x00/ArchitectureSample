package me.newtrekwang.baselibrary.common;
/**
 * @className BaseConstant
 * @createDate 2018/7/13 17:57
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 存放常量的基类
 *
 */
public class BaseConstant {
    /**
     * 是否为debug模式
     */
    public static boolean isDebug = true;

    /**
     * server ip
     */
    public static final String SERVER_ADDRESS = "http://yourhost/";
    /**
     * sharedPreferences file name
     */
    public static final String TABLE_PREFS = "appStore";

    /**
     * token key
     */
    public static final String KEY_SP_TOKEN = "token";
    /**
     * 成功返回
     */
    public static final int STATUS_OK = 200;
    /**
     * 访问正常
     */
    public static final int STATUS_ACESS_NOMAL = 201;
    /**
     * 请求要求用户的身份认证
     */
    public static final int STATUS_NEED_TOKEN = 401;
    /**
     *  服务拒绝请求
     */
    public static final int STATUS_REJECT = 403;
    /**
     *  找不到服务
     */
    public static final int STATUS_NOT_FOUND = 404;
    /**
     * 服务器内部错误
     */
    public static final int STATUS_SERVER_ERROR = 500;
    /**
     * 验证码过期
     */
    public static final int STATUS_CODE_TIME_OUT = 12;

}
