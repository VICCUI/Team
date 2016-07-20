package com.wowo.team.shoping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wowo.team.shoping.R;
import com.wowo.team.shoping.adapter.ExposeBillAdapter;
import com.wowo.team.shoping.app.IApp;
import com.wowo.team.shoping.bean.ExposeBillBean;
import com.wowo.team.shoping.url.ExposeBillUrl;
import com.wowo.team.shoping.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by marsens on 2016/7/20.
 */
public class ExposeBillFragment extends Fragment {
    private ListView lv_exposebill;
    private List<ExposeBillBean.GrabSDData> list;
    private ExposeBillAdapter exposeBillAdapter;
    private RequestQueue queue;
    private ImageLoader loader;

    public ExposeBillFragment() {
    }

    private PullToRefreshListView mPullListView;
    private int page = 1;//页数


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        queue = Volley.newRequestQueue(getActivity());
        return inflater.inflate(R.layout.fragment_exposebill, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();

        mPullListView = (PullToRefreshListView) view.findViewById(R.id.ptr_fl);
        mPullListView.setMode(PullToRefreshBase.Mode.BOTH);
        exposeBillAdapter = new ExposeBillAdapter(getActivity(), list);
        mPullListView.setAdapter(exposeBillAdapter);
        initData();
        bindListeners();
        loader = ((IApp) (getActivity().getApplication())).getLoader();
    }

    private void bindListeners() {
        mPullListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉数据
                page = 1;
                list.clear();
                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载
                page++;
                initData();
            }
        });
    }

    private void initData() {
        /*final GsonRequest<ExposeBillBean> request=new GsonRequest<ExposeBillBean>(
                Request.Method.GET,ExposeBillBean.class, ExposeBillUrl.getShow,
                new Response.Listener<ExposeBillBean>() {
                    @Override
                    public void onResponse(ExposeBillBean response) {
                        if (response != null) {
                            list.addAll(response.data);
                            exposeBillAdapter.notifyDataSetChanged();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(request);*/
        VolleyUtils.newInstance(getContext()).newGsonRequest(Request.Method.GET, ExposeBillUrl.getShow, new Response.Listener<ExposeBillBean>() {
            @Override
            public void onResponse(ExposeBillBean response) {
                list.addAll(response.data);
                exposeBillAdapter.notifyDataSetChanged();
            }
        }, null, ExposeBillBean.class);
    }

}

