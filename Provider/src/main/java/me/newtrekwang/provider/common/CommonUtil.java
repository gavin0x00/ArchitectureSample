package me.newtrekwang.provider.common;

import android.text.TextUtils;

import me.newtrekwang.baselibrary.common.BaseConstant;
import me.newtrekwang.baselibrary.utils.AppPrefsUtils;

/**
 * @author newtrekWang
 * @fileName CommonUtil
 * @createDate 2018/9/3 13:50
 * @email 408030208@qq.com
 * @desc 业务模块公用工具类
 */
public final class CommonUtil {
    private CommonUtil(){}
    /**
     * 判断是否已登录
     * @return
     */
    public static boolean isLogined(){
        String  result = AppPrefsUtils.getInstance().getString(BaseConstant.KEY_SP_TOKEN);
        return !TextUtils.isEmpty(result);
    }
}
