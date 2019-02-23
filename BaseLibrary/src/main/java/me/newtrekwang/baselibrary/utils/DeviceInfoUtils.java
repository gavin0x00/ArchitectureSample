package me.newtrekwang.baselibrary.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/**
 * @author newtrekWang
 * @fileName DeviceInfoUtils
 * @createDate 2018/7/25 11:45
 * @email 408030208@qq.com
 * @desc 设备信息工具类
 */
public final class DeviceInfoUtils {
    /**
     * 设备厂商
     * @return
     */
    public static String getPhoneBrand(){
        return Build.BOARD+" "+Build.MANUFACTURER;
    }

    /**
     * 设备名称
     * @return
     */
    public static String getPhoneModel(){
        return Build.MODEL;
    }

    /**
     * 获取屏幕分辨率
     * @param context
     * @return
     */
    public static int[] getMetrics(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int[] metrics = {width,height};
        return metrics;
    }

    /**
     * 当前软件版本号
     * @param context
     * @return
     */
    public static int getVersionCode(Context context){
        int versionCode =-1;
        String packageName = context.getPackageName();
        try {
            versionCode = context.getPackageManager()
                    .getPackageInfo(packageName,0)
                    .versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本名字
     * @param context
     * @return
     */
    public static String getVersionName(Context context){
        String versionName = null;
        String packageName = context.getPackageName();
        try {
            versionName = context.getPackageManager()
                    .getPackageInfo(packageName,0)
                    .versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
