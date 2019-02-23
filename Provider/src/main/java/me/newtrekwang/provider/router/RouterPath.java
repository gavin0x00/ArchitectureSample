package me.newtrekwang.provider.router;

/**
 * @author newtrekWang
 * @fileName RouterPath
 * @createDate 2018/9/3 14:02
 * @email 408030208@qq.com
 * @desc 模块路由 路径定义
 */
public final class RouterPath {
    private RouterPath(){}

    /**
     * @className RouterPath
     * @createDate 2018/9/3 14:06
     * @author newtrekWang
     * @email 408030208@qq.com
     * @desc 用户中心业务模块
     *
     */
    public static final class UserCenterModule {


        private UserCenterModule(){}
        public static final String PATH_LOGIN = "/userCenterModule/login";
        public static final String PATH_REGISTER_VALIDATE = "/userCenter/registerValidate";
        public static final String PATH_RESETPWD = "/userCenterModule/resetPwd";
        public static final String PATH_USERINFO = "/userCenterModule/userInfo";
        public static final String PATH_FORGET_PWD = "/userCenterModule/forgetPwd";
    }
    /**
     * @className RouterPath
     * @createDate 2018/9/3 14:07
     * @author newtrekWang
     * @email 408030208@qq.com
     * @desc 主模块
     *
     */
    public static final class MainModule {
        private MainModule(){}
        public static final String PATH_MAIN = "/app/home";
    }
    /**
     * @className RouterPath
     * @createDate 2018/9/6 15:42
     * @author newtrekWang
     * @email 408030208@qq.com
     * @desc 业务模块1
     *
     */
    public static final class OneModule{
        private OneModule(){}
        public static final String PATH_FRAGMENT_ONE = "/oneModule/oneFragment";
    }
    /**
     * @className RouterPath
     * @createDate 2018/9/6 15:42
     * @author newtrekWang
     * @email 408030208@qq.com
     * @desc 业务模块2
     *
     */
    public static final class TwoModule{
        private TwoModule(){}
        public static final String PATH_FRAGMENT_TWO = "/twoModule/twoFragment";
    }


}
