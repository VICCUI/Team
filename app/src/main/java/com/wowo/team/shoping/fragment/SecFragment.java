package com.wowo.team.shoping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wowo.team.shoping.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flips on 2016/7/15.
 */
public class SecFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private ViewPager rec_vp;
    private RadioGroup rec_rg;
    private List<Fragment> mList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sec, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rec_vp = (ViewPager) view.findViewById(R.id.rec_vp);
        rec_rg = (RadioGroup) view.findViewById(R.id.rec_rg);
        mList = new ArrayList<>();
        initFragment();
        initAdapter();

        rec_rg.check(R.id.rb_duobao);//默认选择"夺宝"

        rec_rg.setOnCheckedChangeListener(this);

        rec_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
                //viewpager监听
                switch (position) {
                    case 0:
                        rec_rg.check(R.id.rb_duobao);
                        break;
                    case 1:
                        rec_rg.check(R.id.rb_jiexiao);
                        break;
                    case 2:
                        rec_rg.check(R.id.rb_shaidan);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initFragment() {
        //添加碎片
        mList.add(new RecTopOneFragment());
        mList.add(new RecTopTwoFragment());
        mList.add(new RecTopThreeFragment());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int position) {
        int i = position - 2131492954;
        rec_vp.setCurrentItem(i);

        //Log.i("TTT",""+i);

    }

    private void initAdapter() {
        MyFragmentPagerAdapter mAdapter = new MyFragmentPagerAdapter(getFragmentManager());
        rec_vp.setAdapter(mAdapter);
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

    }
}
