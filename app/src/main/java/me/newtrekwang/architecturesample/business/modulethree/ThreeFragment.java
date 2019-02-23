package me.newtrekwang.architecturesample.business.modulethree;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.newtrekwang.architecturesample.R;

/**
 * @className ThreeFragment
 * @createDate 2019/2/23 17:09
 * @author newtrekWang
 * @email 408030208@qq.com
 * @desc 碎片三
 *
 */
public class ThreeFragment extends Fragment {


    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

}
