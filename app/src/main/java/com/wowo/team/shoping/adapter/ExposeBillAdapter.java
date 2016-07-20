package com.wowo.team.shoping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wowo.team.shoping.R;
import com.wowo.team.shoping.bean.ExposeBillBean;
import com.wowo.team.shoping.view.CircleImageView;

import java.util.List;

/**
 * Created by marsens on 2016/7/20.
 */
public class ExposeBillAdapter extends BaseAdapter{
    private List<ExposeBillBean.GrabSDData> mlist;
    private Context mContext;
    public ExposeBillAdapter(Context context,List<ExposeBillBean.GrabSDData> list){
        this.mlist=list;
        this.mContext=context;
    }


    @Override
    public int getCount() {
        return mlist==null?0:mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.list_item_exposebill_fragment,parent,false);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        ExposeBillBean.GrabSDData bean=mlist.get(position);
        ImageLoader.getInstance().displayImage(bean.avatar128,viewHolder.civAvatar);
        ImageLoader.getInstance().displayImage(bean.getImg().get(0),viewHolder.ivImg);
        viewHolder.tvContent.setText(bean.content);
        viewHolder.tvTitle.setText(bean.title);
        viewHolder.tvCreateTime.setText(bean.create_time);
        viewHolder.tvNickname.setText(bean.nickname);
        return convertView;
    }
    class ViewHolder{
        private CircleImageView civAvatar;
        private ImageView ivImg;
        private TextView tvNickname,tvCreateTime,tvTitle,tvContent;

        public ViewHolder(View itemView){
            civAvatar= (CircleImageView) itemView.findViewById(R.id.civ_avatar);
            ivImg= (ImageView) itemView.findViewById(R.id.iv_img);
            tvNickname= (TextView) itemView.findViewById(R.id.tv_nickname);
            tvCreateTime= (TextView) itemView.findViewById(R.id.tv_create_time);
            tvTitle= (TextView) itemView.findViewById(R.id.tv_title);
            tvContent= (TextView) itemView.findViewById(R.id.tv_content);
        }



    }
}
