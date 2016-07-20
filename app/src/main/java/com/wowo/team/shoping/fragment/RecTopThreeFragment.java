package com.wowo.team.shoping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wowo.team.shoping.R;

/**
 * author:  崔海
 * time:    2016/7/15 21:22
 * name:
 * overview:
 * usage:
 */
public class RecTopThreeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rec_top_three,null);
    }
}
