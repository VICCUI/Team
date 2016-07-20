package com.wowo.team.shoping.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wowo.team.shoping.R;
import com.wowo.team.shoping.bean.RecTwoBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author:  崔海
 * time:    2016/7/15 21:53
 * name:
 * overview:
 * usage:
 */
public class RecTopTwoAdapter extends RecyclerView.Adapter<RecTopTwoAdapter.RecViewHolder> {
    private List<RecTwoBean.DataBean> mDatas;
    private Context mContext;
    private DisplayImageOptions mImageOptions;

    public RecTopTwoAdapter(Context context, List<RecTwoBean.DataBean> datas) {
        mContext = context;
        mDatas = datas;
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
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rec_two_layout, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(mDatas.get(position).photos, holder.item_rec_iv, mImageOptions);
        holder.item_rec_tv1.setText(mDatas.get(position).name);//标题
        if (mDatas.get(position).status.equals("OPENING")) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            long etime = mDatas.get(position).etime;
            long btime = mDatas.get(position).btime;
            long t = (etime - btime)*100;//剩余时间

            String formal2 = format.format(new Date(t));
            holder.item_rec_tv6.setText("即将揭晓:剩余时间" + formal2);
            holder.item_rec_tv6.setTextColor(Color.RED);
            holder.item_rec_tv6.setTextSize(18);
        } else if (mDatas.get(position).status.equals("END")) {
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            holder.item_rec_tv6.setText("");
            holder.item_rec_tv2.setText("夺宝号: " + mDatas.get(position).winnumber);//夺宝号
            holder.item_rec_tv3.setText("参与人次: " + mDatas.get(position).join_num);
            holder.item_rec_tv4.setText("获奖者: " + mDatas.get(position).winner_info.win_nickname);
            long etime = mDatas.get(position).winner_info.etime;
            String format1 = format.format(new Date(etime));
            holder.item_rec_tv5.setText("揭晓时间" + format1);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class RecViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_rec_iv;
        private TextView item_rec_tv1;
        private TextView item_rec_tv2;
        private TextView item_rec_tv3;
        private TextView item_rec_tv4;
        private TextView item_rec_tv5;
        private TextView item_rec_tv6;

        public RecViewHolder(View itemView) {
            super(itemView);
            item_rec_iv = (ImageView) itemView.findViewById(R.id.item_rec_iv);
            item_rec_tv1 = (TextView) itemView.findViewById(R.id.item_rec_tv1);
            item_rec_tv2 = (TextView) itemView.findViewById(R.id.item_rec_tv2);
            item_rec_tv3 = (TextView) itemView.findViewById(R.id.item_rec_tv3);
            item_rec_tv4 = (TextView) itemView.findViewById(R.id.item_rec_tv4);
            item_rec_tv5 = (TextView) itemView.findViewById(R.id.item_rec_tv5);
            item_rec_tv6 = (TextView) itemView.findViewById(R.id.item_rec_tv6);
        }
    }

}
