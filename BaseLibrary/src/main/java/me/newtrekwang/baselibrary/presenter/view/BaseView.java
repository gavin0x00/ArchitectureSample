package me.newtrekwang.baselibrary.presenter.view;


 /**
  * @className BaseView
  * @createDate 2018/7/15 23:33
  * @author newtrekWang
  * @email 408030208@qq.com
  * @desc 基础的View接口
  *
  */
public interface BaseView {
     /**
      * 显示loading
      */
    void showLoading();

     /**
      * 隐藏loading
      */
    void hideLoading();

     /**
      * 显示异常信息
      * @param error 异常信息
      */
    void onError(String error);

     /**
      * 显示Toast消息
      * @param msg
      */
    void showToast(String msg);
}
