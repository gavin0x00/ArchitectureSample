package me.newtrekwang.baselibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

import me.newtrekwang.baselibrary.common.BaseApplication;
import me.newtrekwang.baselibrary.common.BaseConstant;

/**
 * @className AppPrefsUtils
 * @createDate 2018/7/15 23:37
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc SharedPreferences 工具类
 *
 */
public final class AppPrefsUtils {

    private SharedPreferences sharedPreferences ;
    private SharedPreferences.Editor editor;
    private AppPrefsUtils(){
        sharedPreferences = BaseApplication.getBaseApplication().getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    /**
     * put boolean
     * @param key
     * @param value
     */
    public void putBoolean(String key,Boolean value){
        editor.putBoolean(key,value);
        editor.commit();
    }

    /**
     * get boolean
     * @param key
     * @return value
     */
    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }

    /**
     * put str
     * @param key
     * @param value
     */
    public void putString(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }

    /**
     * get str
     * @param key
     * @return
     */
    public String getString(String key){
        return sharedPreferences.getString(key,"");
    }

    /**
     * put int
     * @param key
     * @param value
     */
    public void putInt(String key,int value){
        editor.putInt(key,value)
                .commit();
    }

    /**
     * get int
     * @param key
     * @return
     */
    public int getInt(String key){
        return sharedPreferences.getInt(key,-1);
    }

    /**
     * put long
     * @param key
     * @param value
     */
    public void putLong(String key,long value){
        editor.putLong(key,value)
                .commit();
    }

    /**
     * get long
     * @param key
     * @return
     */
    public long getLong(String key){
        return sharedPreferences.getLong(key,-1);
    }

    /**
     * set StSet
     * @param key
     * @param set
     */
    public void putStringSet(String key,Set<String> set){
        Set<String> localSet = getStringSet(key);
        localSet.addAll(set);
        editor.putStringSet(key,localSet)
                .commit();
    }

    /**
     * get strSet
     * @param key
     * @return
     */
    public Set<String > getStringSet(String key){
        Set<String > set = new HashSet<>();
        return sharedPreferences.getStringSet(key,set);
    }

    /**
     * 删除键值对
     * @param key
     */
    public void remove(String key){
        editor.remove(key)
                .commit();
    }

   private static class AppPrefsUtilsHolder{
        private static final AppPrefsUtils INSTANCE = new AppPrefsUtils();
    }
    public static AppPrefsUtils getInstance(){
        return AppPrefsUtilsHolder.INSTANCE;
    }


}
