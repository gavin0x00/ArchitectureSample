package me.newtrekwang.baselibrary.widgets;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import me.newtrekwang.baselibrary.R;

/**
 * @author newtrekWang
 * @fileName LoadingDialog
 * @createDate 2018/10/9 10:12
 * @email 408030208@qq.com
 * @desc LoadingDialog 统一Loading加载框
 */
public class LoadingDialog extends Dialog{
    /**
     * 动画
     */
    private Animation rotateAnimation;
    /**
     * loading图片
     */
    private ImageView imageView;

    /**
     * 构造
     * @param context
     */
    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.LightProgressDialog);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        setContentView(R.layout.progress_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);

        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        // 背景黑暗度
        attributes.dimAmount = 0f;
        // 居中
        attributes.gravity = Gravity.CENTER;
        // 宽度
        attributes.width = 200;
        // 高度
        attributes.height = 200;
        getWindow().setAttributes(attributes);
        imageView = findViewById(R.id.iv_loading);

        // 自旋转动画
        if (rotateAnimation == null){
            rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            rotateAnimation.setDuration(5000);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setRepeatMode(Animation.RESTART);
            rotateAnimation.setRepeatCount(Animation.INFINITE);
        }
    }

    /**
     * 显示Loading
     */
    public void showLoading(){
        imageView.startAnimation(rotateAnimation);
        super.show();
    }


    /**
     * 隐藏loading
     */
    public void hideLoading(){
        if(imageView.getAnimation() != null){
            imageView.getAnimation().cancel();
        }
        super.dismiss();
    }
}
