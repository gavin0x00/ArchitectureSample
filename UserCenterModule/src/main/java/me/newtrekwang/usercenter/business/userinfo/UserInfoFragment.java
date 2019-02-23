package me.newtrekwang.usercenter.business.userinfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import me.newtrekwang.provider.router.RouterPath;
import me.newtrekwang.usercenter.R;

/**
 * @className UserInfoFragment
 * @createDate 2018/9/6 15:57
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 个人中心界面
 *
 */
@Route(path = RouterPath.UserCenterModule.PATH_USERINFO)
public class UserInfoFragment extends Fragment {
    public UserInfoFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

}
