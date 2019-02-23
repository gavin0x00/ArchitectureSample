package me.newtrekwang.baselibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * @author newtrekWang
 * @fileName ToastUtils
 * @createDate 2018/10/9 9:46
 * @email 408030208@qq.com
 * @desc Toast封装，适配尺寸
 */
public final class ToastUtils {
    /**
     * 默认背景颜色
     */
    private static final int COLOR_DEFAULT = 0xFEFFFFFF;
    /**
     * UI线程中的Handler
     */
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    /**
     * 字符串常量
     */
    private static final String NULL = "null";
    /**
     * toast接口引用
     */
    private static IToast sToast;
    /**
     * 位置
     */
    private static int    sGravity     = -1;
    /**
     * x方向留空
     */
    private static int    sXOffset     = -1;
    /**
     * y方向留空
     */
    private static int    sYOffset     = -1;
    /**
     * toast背景颜色
     */
    private static int    sBgColor     = COLOR_DEFAULT;
    /**
     * toast背景资源id
     */
    private static int    sBgResource  = -1;
    /**
     * toast 消息字符串颜色
     */
    private static int    sMsgColor    = COLOR_DEFAULT;
    /**
     * toast 消息字符串字体大小
     */
    private static int    sMsgTextSize = -1;

    /**
     * 防止被实例
     */
    private ToastUtils(){
        throw new UnsupportedOperationException("u can't touch me!");
    }
    /**
     * Set the gravity.设置位置
     *
     * @param gravity The gravity.位置
     * @param xOffset X-axis offset, in pixel.x轴留空多少像素
     * @param yOffset Y-axis offset, in pixel.y轴留空多少像素
     */
    public static void setGravity(final int gravity, final int xOffset, final int yOffset) {
        sGravity = gravity;
        sXOffset = xOffset;
        sYOffset = yOffset;
    }

    /**
     * Set the color of background.设置背景颜色
     *
     * @param backgroundColor The color of background.颜色值
     */
    public static void setBgColor(@ColorInt final int backgroundColor) {
        sBgColor = backgroundColor;
    }

    /**
     * Set the resource of background.设置背景drawable资源
     *
     * @param bgResource The resource of background. drawable资源id
     */
    public static void setBgResource(@DrawableRes final int bgResource) {
        sBgResource = bgResource;
    }

    /**
     * Set the color of message. 设置msg字符串颜色
     *
     * @param msgColor The color of message.颜色值
     */
    public static void setMsgColor(@ColorInt final int msgColor) {
        sMsgColor = msgColor;
    }

    /**
     * Set the text size of message. 设置msg字符串字体大小
     *
     * @param textSize The text size of message. 字体大小
     */
    public static void setMsgTextSize(final int textSize) {
        sMsgTextSize = textSize;
    }

    /**
     * Show the sToast for a short period of time. 短时间显示Toast
     *
     * @param text The text. msg字符串
     */
    public static void showShort(final CharSequence text) {
        show(text == null ? NULL : text, Toast.LENGTH_SHORT);
    }

    /**
     * Show the sToast for a short period of time.短时间显示Toast
     *
     * @param resId The resource id for text. 字符串资源id
     */
    public static void showShort(@StringRes final int resId) {
        show(resId, Toast.LENGTH_SHORT);
    }

    /**
     * Show the sToast for a short period of time.短时间显示Toast
     *
     * @param resId The resource id for text. msg字符串
     * @param args  The args. 参数
     */
    public static void showShort(@StringRes final int resId, final Object... args) {
        show(resId, Toast.LENGTH_SHORT, args);
    }

    /**
     * Show the sToast for a short period of time. 短时间显示Toast
     *
     * @param format The format.格式
     * @param args   The args. 参数
     */
    public static void showShort(final String format, final Object... args) {
        show(format, Toast.LENGTH_SHORT, args);
    }

    /**
     * Show the sToast for a long period of time. 长时间显示Toast
     *
     * @param text The text. msg字符串
     */
    public static void showLong(final CharSequence text) {
        show(text == null ? NULL : text, Toast.LENGTH_LONG);
    }
    /**
     * Show the sToast for a long period of time.长时间显示Toast
     *
     * @param resId The resource id for text. msg字符串资源id
     */
    public static void showLong(@StringRes final int resId) {
        show(resId, Toast.LENGTH_LONG);
    }

    /**
     * Show the sToast for a long period of time.长时间显示Toast
     *
     * @param resId The resource id for text. msg字符串资源id
     * @param args  The args. 参数
     */
    public static void showLong(@StringRes final int resId, final Object... args) {
        show(resId, Toast.LENGTH_LONG, args);
    }

    /**
     * Show the sToast for a long period of time.长时间显示Toast
     *
     * @param format The format. 格式
     * @param args   The args. 参数
     */
    public static void showLong(final String format, final Object... args) {
        show(format, Toast.LENGTH_LONG, args);
    }

    /**
     * Show custom sToast for a short period of time. 短时间显示自定义的Toast
     *
     * @param layoutId ID for an XML layout resource to load. 布局资源id
     */
    public static View showCustomShort(@LayoutRes final int layoutId) {
        final View view = getView(layoutId);
        show(view, Toast.LENGTH_SHORT);
        return view;
    }

    /**
     * Show custom sToast for a long period of time. 长时间显示自定义的Toast
     *
     * @param layoutId ID for an XML layout resource to load. 布局资源id
     */
    public static View showCustomLong(@LayoutRes final int layoutId) {
        final View view = getView(layoutId);
        show(view, Toast.LENGTH_LONG);
        return view;
    }

    /**
     * Cancel the sToast.取消Toast显示
     */
    public static void cancel() {
        if (sToast != null) {
            sToast.cancel();
        }
    }

    /**
     * 恢复默认设置
     */
    public static void resetToast() {
        ToastUtils.setMsgColor(0xFEFFFFFF);
        ToastUtils.setBgColor(0xFEFFFFFF);
        ToastUtils.setBgResource(-1);
        ToastUtils.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, -1, -1);
    }

    /**
     * 显示Toast
     * @param resId 字符串资源id
     * @param duration 显示停留时间
     */
    private static void show(final int resId, final int duration) {
        try {
            CharSequence text = AppUtils.getApp().getResources().getText(resId);
            show(text, duration);
        } catch (Exception ignore) {
            show(String.valueOf(resId), duration);
        }
    }

    /**
     * 显示Toast
     * @param resId  字符串资源id
     * @param duration 显示停留时间
     * @param args 参数
     */
    private static void show(final int resId, final int duration, final Object... args) {
        try {
            CharSequence text = AppUtils.getApp().getResources().getText(resId);
            String format = String.format(text.toString(), args);
            show(format, duration);
        } catch (Exception ignore) {
            show(String.valueOf(resId), duration);
        }
    }

    /**
     * 显示Toast
     * @param format 格式
     * @param duration 显示停留时间
     * @param args 参数
     */
    private static void show(final String format, final int duration, final Object... args) {
        String text;
        if (format == null) {
            text = NULL;
        } else {
            text = String.format(format, args);
            if (text == null) {
                text = NULL;
            }
        }
        show(text, duration);
    }

    /**
     * 显示Toast
     * @param text msg字符串
     * @param duration 显示停留时间
     */
    private static void show(final CharSequence text, final int duration) {
        HANDLER.post(new Runnable() {
            @SuppressLint("ShowToast")
            @Override
            public void run() {
                cancel();
                sToast = ToastFactory.makeToast(AppUtils.getApp(), text, duration);
                final TextView tvMessage = sToast.getView().findViewById(android.R.id.message);
                if (sMsgColor != COLOR_DEFAULT) {
                    tvMessage.setTextColor(sMsgColor);
                }
                if (sMsgTextSize != -1) {
                    tvMessage.setTextSize(sMsgTextSize);
                }
                if (sGravity != -1 || sXOffset != -1 || sYOffset != -1) {
                    sToast.setGravity(sGravity, sXOffset, sYOffset);
                }
                setBg(tvMessage);
                sToast.show();
            }
        });
    }

    /**
     * 显示Toast
     * @param view view
     * @param duration 显示停留时间
     */
    private static void show(final View view, final int duration) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                cancel();
                sToast = ToastFactory.newToast(AppUtils.getApp());
                sToast.setView(view);
                sToast.setDuration(duration);
                if (sGravity != -1 || sXOffset != -1 || sYOffset != -1) {
                    sToast.setGravity(sGravity, sXOffset, sYOffset);
                }
                setBg();
                sToast.show();
            }
        });
    }

    /**
     * 设置背景
     */
    private static void setBg() {
        if (sBgResource != -1) {
            final View toastView = sToast.getView();
            toastView.setBackgroundResource(sBgResource);
        } else if (sBgColor != COLOR_DEFAULT) {
            final View toastView = sToast.getView();
            Drawable background = toastView.getBackground();
            if (background != null) {
                background.setColorFilter(
                        new PorterDuffColorFilter(sBgColor, PorterDuff.Mode.SRC_IN)
                );
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    toastView.setBackground(new ColorDrawable(sBgColor));
                } else {
                    toastView.setBackgroundDrawable(new ColorDrawable(sBgColor));
                }
            }
        }
    }

    private static void setBg(final TextView tvMsg) {
        if (sBgResource != -1) {
            final View toastView = sToast.getView();
            toastView.setBackgroundResource(sBgResource);
            tvMsg.setBackgroundColor(Color.TRANSPARENT);
        } else if (sBgColor != COLOR_DEFAULT) {
            final View toastView = sToast.getView();
            Drawable tvBg = toastView.getBackground();
            Drawable msgBg = tvMsg.getBackground();
            if (tvBg != null && msgBg != null) {
                tvBg.setColorFilter(new PorterDuffColorFilter(sBgColor, PorterDuff.Mode.SRC_IN));
                tvMsg.setBackgroundColor(Color.TRANSPARENT);
            } else if (tvBg != null) {
                tvBg.setColorFilter(new PorterDuffColorFilter(sBgColor, PorterDuff.Mode.SRC_IN));
            } else if (msgBg != null) {
                msgBg.setColorFilter(new PorterDuffColorFilter(sBgColor, PorterDuff.Mode.SRC_IN));
            } else {
                toastView.setBackgroundColor(sBgColor);
            }
        }
    }

    /**
     * 获取View
     * @param layoutId
     * @return
     */
    private static View getView(@LayoutRes final int layoutId) {
        LayoutInflater inflate =
                (LayoutInflater) AppUtils.getApp().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //noinspection ConstantConditions
        return inflate.inflate(layoutId, null);
    }

    /**
     * Toast工厂类，因为在Android N系统版本的Toast有点不一样，所以需要区分Toast
     */
    static class ToastFactory {

        static IToast makeToast(Context context, CharSequence text, int duration) {
            if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return new SystemToast(makeNormalToast(context, text, duration));
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) {
                return new ToastWithoutNotification(makeNormalToast(context, text, duration));
            }
            // 适配Android N
            Log.e("ToastUtils", "Toast is GG. In fact, next step is useless.");
            return new SystemToast(makeNormalToast(context, text, duration));
        }

        static IToast newToast(Context context) {
            if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return new SystemToast(new Toast(context));
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) {
                return new ToastWithoutNotification(new Toast(context));
            }
            // 适配Android N
            Log.e("ToastUtils", "Toast is GG. In fact, next step is useless.");
            return new SystemToast(new Toast(context));
        }

        private static Toast makeNormalToast(Context context, CharSequence text, int duration) {
            @SuppressLint("ShowToast")
            Toast toast = Toast.makeText(context, "", duration);
            toast.setText(text);
            return toast;
        }
    }

    /**
     * IToast接口的实现之一SystemToast
     */
    static class SystemToast implements IToast {

        Toast mToast;

        private static Field sField_mTN;
        private static Field sField_TN_Handler;

        SystemToast(@NonNull Toast toast) {
            mToast = toast;
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1) {
                try {
                    //noinspection JavaReflectionMemberAccess 通过反射获取默认Toast的handler
                    sField_mTN = Toast.class.getDeclaredField("mTN");
                    sField_mTN.setAccessible(true);
                    Object mTN = sField_mTN.get(toast);
                    sField_TN_Handler = sField_mTN.getType().getDeclaredField("mHandler");
                    sField_TN_Handler.setAccessible(true);
                    Handler tnHandler = (Handler) sField_TN_Handler.get(mTN);
                    sField_TN_Handler.set(mTN, new SafeHandler(tnHandler));
                } catch (Exception ignored) { /**/ }
            }
        }

        @Override
        public void show() {
            mToast.show();
        }

        @Override
        public void cancel() {
            mToast.cancel();
        }

        @Override
        public void setView(View view) {
            mToast.setView(view);
        }

        @Override
        public View getView() {
            return mToast.getView();
        }

        @Override
        public void setDuration(int duration) {
            mToast.setDuration(duration);
        }

        @Override
        public void setGravity(int gravity, int xOffset, int yOffset) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }

        @Override
        public void setText(int resId) {
            mToast.setText(resId);
        }

        @Override
        public void setText(CharSequence s) {
            mToast.setText(s);
        }

        static class SafeHandler extends Handler {
            private Handler impl;

            SafeHandler(Handler impl) {
                this.impl = impl;
            }

            @Override
            public void handleMessage(Message msg) {
                try {
                    impl.handleMessage(msg);
                } catch (Exception e) {
                    Log.e("SafeHandler",e.toString());
                }
            }

            @Override
            public void dispatchMessage(Message msg) {
                impl.dispatchMessage(msg);
            }
        }
    }

    /**
     * 没有通知的Toast
     */
    static class ToastWithoutNotification implements IToast {

        private Toast mToast;

        private WindowManager mWM;

        private View mView;

        private WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();

        private Handler mHandler = new Handler(Looper.myLooper());

        ToastWithoutNotification(@NonNull Toast toast) {
            mToast = toast;

            mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            mParams.format = PixelFormat.TRANSLUCENT;
            mParams.windowAnimations = android.R.style.Animation_Toast;
            mParams.type = WindowManager.LayoutParams.TYPE_TOAST;
            mParams.setTitle("ToastWithoutNotification");
            mParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        }

        @Override
        public void show() {
            mView = mToast.getView();
            if (mView == null) {return;}
            Context context = mToast.getView().getContext();
            mWM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

            final Configuration config = context.getResources().getConfiguration();
            final int gravity;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                gravity = Gravity.getAbsoluteGravity(mToast.getGravity(), config.getLayoutDirection());
            } else {
                gravity = mToast.getGravity();
            }
            mParams.gravity = gravity;
            if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.FILL_HORIZONTAL) {
                mParams.horizontalWeight = 1.0f;
            }
            if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.FILL_VERTICAL) {
                mParams.verticalWeight = 1.0f;
            }
            mParams.x = mToast.getXOffset();
            mParams.y = mToast.getYOffset();

            mParams.packageName = AppUtils.getApp().getPackageName();

            try {
                mWM.addView(mView, mParams);
            } catch (Exception ignored) { /**/ }

            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    cancel();
                }
            }, mToast.getDuration() == Toast.LENGTH_SHORT ? 2000 : 3500);
        }

        @Override
        public void cancel() {
            try {
                mWM.removeView(mView);
            } catch (IllegalArgumentException ignored) { /**/ }
            mView = null;
            mHandler = null;
            mToast = null;
        }

        @Override
        public void setView(View view) {
            mToast.setView(view);
        }

        @Override
        public View getView() {
            return mToast.getView();
        }

        @Override
        public void setDuration(int duration) {
            mToast.setDuration(duration);
        }

        @Override
        public void setGravity(int gravity, int xOffset, int yOffset) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }

        @Override
        public void setText(int resId) {
            mToast.setText(resId);
        }

        @Override
        public void setText(CharSequence s) {
            mToast.setText(s);
        }
    }

    /**
     * toast抽象接口
     */
    interface IToast {

        void show();

        void cancel();

        void setView(View view);

        View getView();

        void setDuration(int duration);

        void setGravity(int gravity, int xOffset, int yOffset);

        void setText(@StringRes int resId);

        void setText(CharSequence s);
    }
}
