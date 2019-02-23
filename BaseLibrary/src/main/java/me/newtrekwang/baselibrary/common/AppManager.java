package me.newtrekwang.baselibrary.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * @className AppManager
 * @createDate 2018/7/13 17:43
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc activity 栈管理类
 *
 */
public final class AppManager {
    /**
     * 构造方法私有
     */
    private AppManager(){}

    /**
     * activity管理栈
     */
    private Stack<Activity> activityStack = new Stack<>();
    /**
     * @className AppManagerHolder
     * @createDate 2018/7/13 17:56
     * @author newtrekWang
     * @email 408030208@qq.com
     * @desc 内部静态类
     *
     */
    static class AppManagerHolder{
        private static final AppManager INSTANCE = new AppManager();
    }

    /**
     * 单例
     * @return
     */
    public static AppManager getInstance(){
        return AppManagerHolder.INSTANCE;
    }

    /**
     * 入栈
     * @param activity
     */
    public void addActivity(Activity activity){
        activityStack.add(activity);
    }

    /**
     * 出栈
     */
    public void finishAcitivity(Activity activity){
        activity.finish();
        activityStack.remove(activity);
    }

    /**
     * 当前Activity,也就是栈的最后一位元素
     * @return 当前Activity实例
     */
    public Activity currentActivity(){
        return activityStack.lastElement();
    }

    /**
     * 清理栈
     */
    public void finishAllActivity(){
        for (Activity activity : activityStack){
            activity.finish();
        }
        activityStack.clear();
    }

    /**
     * 退出应用
     * @param context
     */
    @SuppressLint("MissingPermission")
    public void exitApplication(Context context){
        finishAllActivity();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.killBackgroundProcesses(context.getPackageName());
        System.exit(0);
    }
}
