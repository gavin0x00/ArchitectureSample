package me.newtrekwang.baselibrary.utils;

import java.util.Locale;


/**
 * @author newtrekWang
 * @fileName SystemUtil
 * @createDate 2018/9/25 16:06
 * @email 408030208@qq.com
 * @desc 系统工具
 */
public final class SystemUtil {

    public static String getCurrentLauguage(){
        // 获取系统当前使用的语言
        String mCurrentLanguage = Locale.getDefault().getLanguage();
        //设置成简体中文的时候，getLanguage()返回的是zh
        return mCurrentLanguage;
    }

    /**
     * 是否为英文
     * @return
     */
    public static boolean isEnglish(){
        // 获取系统当前使用的语言
        String mCurrentLanguage = Locale.getDefault().getLanguage();
        if ("zh".equals(mCurrentLanguage)){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 对应接口的语言标识
     * @return
     */
    public static String getLanguageSt(){
        return isEnglish()?"en":"ch";
    }
}
