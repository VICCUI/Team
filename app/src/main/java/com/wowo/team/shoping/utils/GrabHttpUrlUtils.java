package com.wowo.team.shoping.utils;

/**
 * ******************************
 * pro_name:获取夺宝中的URL
 * author:marsens
 * time:2016.7.15
 * *****************************
 */
public class GrabHttpUrlUtils {
    public static String BASICURL = HomeHttpUrlUtils.BASEURL;

    /**
     * 人气 的URL
     */
    public static String getAttention = BASICURL + "yungou/list&";
    /**
     * 人气 点击每一项的URL
     */
    public static String getAttentionItem = BASICURL + "yungou/detail&";

    /**
     * 全部左侧列表的URL
     */
    public static String getAll = BASICURL + "miaosha_cate&json=";
    /**
     * 全部 每项列表的URL
     */
    public static String getAllItem = BASICURL + "yungou/list&";
    /**
     * 全部 每项列表详情的URL
     */
    public static String getAllItemDetail = BASICURL + "yungou/detail&";
    /**
     * 全部 全部项的URL
     */
    public static String getEveryDetail = BASICURL + "yungou/list&";
    /**
     * 剩余 的URL
     */
    public static String getRest = BASICURL + "yungou/list&";
    /**
     * 剩余 点击每一项的URL
     */
    public static String getRestItem = BASICURL + "yungou/detail&";

    /**
     * 计算规则
     */
    public static String jisuan = "http://www.wowozhe.com/app/miaosha/details/yid/";
}
