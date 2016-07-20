package com.wowo.team.shoping.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.wowo.team.shoping.R;
import com.wowo.team.shoping.adapter.RecTopOneAdapter;
import com.wowo.team.shoping.bean.RecOneBean;
import com.wowo.team.shoping.url.UrlString;
import com.wowo.team.shoping.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * author:  崔海
 * time:    2016/7/15 21:21
 * name:
 * overview:
 * usage:
 */
public class RecTopOneFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg_duobao;
    private RecyclerView re;
    private List<RecOneBean.DataBean> mDatas;
    private RecTopOneAdapter mAdapter;
    private PopupWindow popupWindow;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rec_top_one, null);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rg_duobao = (RadioGroup) view.findViewById(R.id.rg_duobao);
        rg_duobao.check(R.id.rb_renqi);
        loadData1();
        re = (RecyclerView) view.findViewById(R.id.recycler_duobao);

        mDatas = new ArrayList<>();
        mAdapter = new RecTopOneAdapter(getContext(), mDatas);
        re.setAdapter(mAdapter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        re.setLayoutManager(manager);

        rg_duobao.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        popupWindow = new PopupWindow();


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checked) {

        switch (checked) {
            case R.id.rb_quanbu:
                showPopuwindows();
                //Toast.makeText(getContext(), "这里应该有个popuwindows", Toast.LENGTH_SHORT).show();

                break;
            case R.id.rb_renqi:
                popupWindow.dismiss();
                mDatas.clear();
                mAdapter.notifyDataSetChanged();
                loadData1();
                break;
            case R.id.rb_shengyu:
                popupWindow.dismiss();
                mDatas.clear();
                mAdapter.notifyDataSetChanged();
                loadData2();
                break;

        }

    }

    private void showPopuwindows() {
        if (!popupWindow.isShowing()) {
            popupWindow.setWidth(RecyclerView.LayoutParams.MATCH_PARENT);
            popupWindow.setHeight(600);
            popupWindow.setOutsideTouchable(true);
            View view = LayoutInflater.from(getActivity()).inflate(
                    R.layout.popuwindowbar, null);
            popupWindow.setContentView(view);
            popupWindow.showAtLocation(
                    rg_duobao,
                    Gravity.TOP | Gravity.CENTER_VERTICAL, 0, 220);
        } else if (popupWindow.isShowing() && popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private void loadData2() {
        VolleyUtils.newInstance(getContext()).newGsonRequest(Request.Method.GET, UrlString.URL_SEC_ONE_SHNEGYU, new Response.Listener<RecOneBean>() {
            @Override
            public void onResponse(RecOneBean response) {
                mDatas.addAll(response.data);
                mAdapter.notifyDataSetChanged();
            }
        }, null, RecOneBean.class);
    }

    private void loadData1() {
        VolleyUtils.newInstance(getContext()).newGsonRequest(Request.Method.GET, UrlString.URL_SEC_ONE_RENQI, new Response.Listener<RecOneBean>() {
            @Override
            public void onResponse(RecOneBean response) {
                mDatas.addAll(response.data);
                mAdapter.notifyDataSetChanged();
            }
        }, null, RecOneBean.class);
    }


}
