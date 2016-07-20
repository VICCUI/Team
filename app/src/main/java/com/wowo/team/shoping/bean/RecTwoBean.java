package com.wowo.team.shoping.bean;

import java.util.List;

/**
 * author:  崔海
 * time:    2016/7/15 22:06
 * name:
 * overview:
 * usage:
 */
public class RecTwoBean {
    public List<DataBean> data;

    public class DataBean {
        public String photos;//图片
        public String name;//标题
        public String join_num;//参与人次
        public String winnumber;// 夺宝号
        public String status;//判断是否已开过奖
        public long btime;//距离开奖剩余时间
        public long etime;//
        public InfoBean winner_info;
        public class InfoBean {
            public String win_nickname;
            public long etime;

        }

    }

}
