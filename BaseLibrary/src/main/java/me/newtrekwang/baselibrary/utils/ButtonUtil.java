package me.newtrekwang.baselibrary.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @author newtrekWang
 * @fileName ButtonUtil
 * @createDate 2018/10/9 17:48
 * @email 408030208@qq.com
 * @desc 设置按钮点击状态工具类
 */
public final class ButtonUtil {
    /**
     * 监听编辑框的变化，更新按钮可点击状态
     * @param editText 需要监听的编辑框
     * @param buttonEnable 更新接口
     */
    public static void enable(EditText editText,final ButtonEnable buttonEnable){
        if (buttonEnable == null){
            return;
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                buttonEnable.buttonEnable();
            }
        });
    }



    public interface ButtonEnable{
        /**
         * 更新按钮状态接口
         */
        void buttonEnable();
    }
}
