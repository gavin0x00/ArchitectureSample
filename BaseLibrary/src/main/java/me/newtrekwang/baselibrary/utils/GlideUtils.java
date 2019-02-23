package me.newtrekwang.baselibrary.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @className GlideUtils
 * @createDate 2018/7/15 23:39
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc Glide封装
 *
 */
public final class GlideUtils {
    private GlideUtils(){}
    public static void loadImage(Context context, String url, int placeHolderDrawableID,ImageView imageView){
        Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(placeHolderDrawableID)
                .dontAnimate()
                .into(imageView);
    }

    public static void loadImageFitCenter(Context context,String  url,int placeHolderDrawableID,ImageView imageView){
        Glide.with(context)
                .load(url)
                .fitCenter()
                .placeholder(placeHolderDrawableID)
                .dontAnimate()
                .into(imageView);
    }
}
