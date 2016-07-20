package com.wowo.team.shoping.adapter;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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

import java.text.DecimalFormat;
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
        double c = (mDatas.get(position).usedcount * 1.0 / mDatas.get(position).allcount * 1.0) * 100;
        DecimalFormat df = new DecimalFormat("0");//格式化小数
        String s = df.format(c);
        int ss = Integer.parseInt(df.format(c));
        //Log.i("HAHAHA", "" + c);
        SpannableString spannableString = new SpannableString("夺宝进度 " + s + "%");
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(75,75,75)), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.tv_jindu.setText(spannableString);

        holder.seekbar.setProgress(ss);


    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class RecTopOneHolder extends RecyclerView.ViewHolder {
        private ImageView iv_duobao;
        private TextView tv_duobao;
        private TextView tv_jindu;
        private ProgressBar seekbar;
        private ImageView shop_cart;

        public RecTopOneHolder(View itemView) {
            super(itemView);
            iv_duobao = (ImageView) itemView.findViewById(R.id.iv_duobao);
            tv_duobao = (TextView) itemView.findViewById(R.id.tv_duobao);
            tv_jindu = (TextView) itemView.findViewById(R.id.tv_jindu);
            seekbar = (ProgressBar) itemView.findViewById(R.id.seekbar);
            shop_cart = (ImageView) itemView.findViewById(R.id.shop_cart);
        }
    }
}
