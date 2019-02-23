package me.newtrekwang.baselibrary.utils;

import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;

import me.newtrekwang.baselibrary.common.BaseApplication;

/**
 * @author newtrekWang
 * @fileName ResourceUtil
 * @createDate 2018/8/20 14:56
 * @email 408030208@qq.com
 * @desc 资源工具类
 */
public final class ResourceUtil {
    private ResourceUtil(){}

    /**
     * 获取字符串数组
     * @param id id
     * @return 字符串数组
     */
    public static String[] getStringList(@ArrayRes int id){
       return BaseApplication.getBaseApplication().getResources().getStringArray(id);
    }

    /**
     * 获取字符串
     * @param id id
     * @return 字符串
     */
    public static String getResString(@StringRes int id){
        return BaseApplication.getBaseApplication().getResources().getString(id);
    }
}
