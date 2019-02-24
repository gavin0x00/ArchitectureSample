package me.newtrekwang.moduleone.business;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import me.newtrekwang.moduleone.R;
import me.newtrekwang.provider.router.RouterPath;


/**
 * @className OneFragment
 * @createDate 2019/2/23 17:27
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 碎片一
 *
 */
@Route(path = RouterPath.OneModule.PATH_FRAGMENT_ONE)
public class OneFragment extends Fragment {


    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

}
