package com.wowo.team.shoping.adapter;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wowo.team.shoping.R;
import com.wowo.team.shoping.bean.RecOneBean;
import com.wowo.team.shoping.bean.RecTwoBean;
import com.wowo.team.shoping.fragment.RecTopOneFragment;

import java.util.List;

/**
 * author:  崔海
 * time:    2016/7/19 21:11
 * name:
 * overview:
 * usage:
 */
public class RecTopOneAdapter extends RecyclerView.Adapter<RecTopOneAdapter.RecTopOneHolder> {
    private Context mContext;
    public List<RecOneBean.DataBean> mDatas;
    private DisplayImageOptions mImageOptions;

    public RecTopOneAdapter(Context context, List<RecOneBean.DataBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mImageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

    }


    @Override
    public RecTopOneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rec_one, null);
        return new RecTopOneHolder(view);
    }

    @Override
    public void onBindViewHolder(RecTopOneHolder holder, int position) {
        ImageLoader.getInstance().displayImage(mDatas.get(position).photos, holder.iv_duobao, mImageOptions);
        holder.tv_duobao.setText(mDatas.get(position).name);
        holder.tv_states.setText("夺宝进度 " + mDatas.get(position).states + "%");
        holder.seekbar.setProgress(mDatas.get(position).states);

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class RecTopOneHolder extends RecyclerView.ViewHolder {
        private ImageView iv_duobao;
        private TextView tv_duobao;
        private TextView tv_states;
        private ProgressBar seekbar;

        public RecTopOneHolder(View itemView) {
            super(itemView);
            iv_duobao = (ImageView) itemView.findViewById(R.id.iv_duobao);
            tv_duobao = (TextView) itemView.findViewById(R.id.tv_duobao);
            tv_states = (TextView) itemView.findViewById(R.id.tv_states);
            seekbar = (ProgressBar) itemView.findViewById(R.id.seekbar);
        }
    }
}
