package com.wowo.team.shoping.bean;

import java.util.List;

/**
 * author:  崔海
 * time:    2016/7/19 21:16
 * name:
 * overview:
 * usage:
 */
public class RecOneBean {
    public List<DataBean> data;

    public class DataBean {
        public String photos;//图片
        public String name;//名字
        public int states;
        public int usedcount;
        public int allcount;
    }
}
