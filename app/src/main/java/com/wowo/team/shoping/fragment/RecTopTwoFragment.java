package com.wowo.team.shoping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.wowo.team.shoping.R;
import com.wowo.team.shoping.adapter.RecTopTwoAdapter;
import com.wowo.team.shoping.bean.RecTwoBean;
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
public class RecTopTwoFragment extends Fragment {
    private RecyclerView rec_recyclerview;
    private List<RecTwoBean.DataBean> mDatas;
    private RecTopTwoAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rec_top_two, null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rec_recyclerview = (RecyclerView) view.findViewById(R.id.rec_recyclerview);

        mDatas = new ArrayList<>();
        mAdapter = new RecTopTwoAdapter(getContext(), mDatas);
        rec_recyclerview.setAdapter(mAdapter);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rec_recyclerview.setLayoutManager(manager);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadDatas();
    }

    private void loadDatas() {
        VolleyUtils.newInstance(getContext()).newGsonRequest(Request.Method.GET, UrlString.URL_SEC_TWO, new Response.Listener<RecTwoBean>() {
            @Override
            public void onResponse(RecTwoBean response) {
                mDatas.addAll(response.data);
                mAdapter.notifyDataSetChanged();

            }
        }, null, RecTwoBean.class);
    }
}

