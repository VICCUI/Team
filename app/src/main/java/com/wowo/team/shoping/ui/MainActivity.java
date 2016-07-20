package com.wowo.team.shoping.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wowo.team.shoping.R;
import com.wowo.team.shoping.fragment.FindFragment;
import com.wowo.team.shoping.fragment.HomeFragment;
import com.wowo.team.shoping.fragment.PersonFragment;
import com.wowo.team.shoping.fragment.SecFragment;
import com.wowo.team.shoping.fragment.ShopcartFragment;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private RadioGroup mainRadioGroup;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
        initFragment();
        setListener();
    }

    private void initView() {
        mainRadioGroup = (RadioGroup) findViewById(R.id.mainRadioGroup);
    }

    private void initFragment() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(R.id.content_fragment, mFragments.get(0)).commit();
    }

    private void initData() {
        mFragments.add(new HomeFragment());
        mFragments.add(new SecFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new ShopcartFragment());
        mFragments.add(new PersonFragment());
    }


    public void setListener() {
        mainRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                Log.i("mtag", "onCheckedChanged: index=="+index);
                if (!mFragments.get(index).isAdded()) {
                    mFragmentManager.beginTransaction().add(R.id.content_fragment, mFragments.get(index)).commit();
                }
                for (int i = 0; i < mFragments.size(); i++) {
                    if (i == index) {
                        mFragmentManager.beginTransaction().show(mFragments.get(i)).commit();
                    } else {
                        Log.i("mtag", "onCheckedChanged: i="+i);
                        mFragmentManager.beginTransaction().hide(mFragments.get(i)).commit();
                    }
                }
            }
        });
    }
}
