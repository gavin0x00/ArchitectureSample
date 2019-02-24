package me.newtrekwang.moduletwo.business;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import me.newtrekwang.moduletwo.R;
import me.newtrekwang.provider.router.RouterPath;


/**
 * @className TwoFragment
 * @createDate 2019/2/24 14:32
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 碎片二
 *
 */
@Route(path = RouterPath.TwoModule.PATH_FRAGMENT_TWO)
public class TwoFragment extends Fragment {


    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

}
