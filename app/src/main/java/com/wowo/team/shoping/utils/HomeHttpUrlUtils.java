package com.wowo.team.shoping.utils;

/**
 * ******************************
 * pro_name:获取首页的URL
 * author:marsens
 * time:2016.7.15
 * *****************************
 */
public class HomeHttpUrlUtils {
    /**
     * 几乎所有的URL都是由http://a.wowozhe.com/home/m?target=android&v=291&act=为前缀
     * 中间加上一部分,有page改变的单独处理最后补加   "}}   就构成了完整的URL
     */
    public static final String BASEURL="http://a.wowozhe.com/home/m?target=android&v=291&act=";
//home/data_v2_6&json={"pagination":{"page":"1"}}


    /**广告时间点击的URL*/
    /**首页界面的URL*/
    public static String getHomeUrl=BASEURL+"home/data_v2_6&";

    /**广告时间点击的URL*/
    public static final String getFirstTouch=BASEURL+"yungou/detail&";


    /**现金抢红包的URL*/
    public static final String getSecondTouch=BASEURL+"get%2Fwave%2Ftips&json=";

    /**9.9元包邮的URL*/
    public static final String getThirdTouch=BASEURL+"home/data&";

    /**点击iphone6s的URL*/
    public static final String getfouthTouch=BASEURL+"yungou/detail&";


    /**商品分类的URL*/
    public static final String getCartClassifyUrl="http://www.wowozhe.com/home/m?target=ios&act=get_cate&json=";

    /**首页接口的URL(和第一个URL重复了)*/
    public static final String getEveryListview=BASEURL+"home/data_v2_6&";
    /**
     * 搜索跳转的url
     */
    //女装
    public static String getSearchUrlgirl=BASEURL+"home/data_v2_6&";
//    json={"pagination":{"page":"1"},"search":{"cid":"1"}}

    public static String zhinan = "http://www.wowozhe.com/app/miaosha/faq_phone";
    //首页图片
    public static String img = "http://a.wowozhe.com/home/m?target=android&v=291&act=wallpaper_v2_6&json=";
    //用户协议
    public static String xieyi = "http://www.wowozhe.com/home/m/app_zhuce/target/android/v/291";

}
