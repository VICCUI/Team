package com.wowo.team.shoping.bean;

import java.util.List;


public class ExposeBillBean {
    public List<GrabSDData> data;

    public static class GrabSDData{
        public String id;
        public String title;
        public String content;
        private List<String> img;
        public String create_time;
        public String uid;
        public String pid;
        public String level;
        public String level_img;
        public String level_img_a;
        public String nickname;
        public String avatar128;
        public String winnumber;
        public String url;
        public List<String> getImg() {
            return img;
        }

        public void setImg(List<String> img) {
            this.img = img;
        }
    }

}
