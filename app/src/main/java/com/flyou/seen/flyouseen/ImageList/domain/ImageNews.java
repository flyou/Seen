package com.flyou.seen.flyouseen.ImageList.domain;

import java.util.List;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.ImageList.domain
 * 文件名：ImageNewsView
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/15 15:27
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class ImageNews{

    private StatusEntity status;
    private String total;
    private String count;
    private String page;
    private String photo_col_id;

    private List<DataEntity> data;

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPhoto_col_id() {
        return photo_col_id;
    }

    public void setPhoto_col_id(String photo_col_id) {
        this.photo_col_id = photo_col_id;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class StatusEntity {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class DataEntity {
        private String id;
        private String sid;
        private String name;
        private String short_name;
        private String url;
        private String img_url;
        private String cover_thumb_url;
        private String createtime;
        private String lead;
        private String short_intro;
        private String uni_intro;
        private String sub_ch;
        private String channel;
        private String newsid;
        private String img_count;
        private String ch_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getCover_thumb_url() {
            return cover_thumb_url;
        }

        public void setCover_thumb_url(String cover_thumb_url) {
            this.cover_thumb_url = cover_thumb_url;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getLead() {
            return lead;
        }

        public void setLead(String lead) {
            this.lead = lead;
        }

        public String getShort_intro() {
            return short_intro;
        }

        public void setShort_intro(String short_intro) {
            this.short_intro = short_intro;
        }

        public String getUni_intro() {
            return uni_intro;
        }

        public void setUni_intro(String uni_intro) {
            this.uni_intro = uni_intro;
        }

        public String getSub_ch() {
            return sub_ch;
        }

        public void setSub_ch(String sub_ch) {
            this.sub_ch = sub_ch;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getNewsid() {
            return newsid;
        }

        public void setNewsid(String newsid) {
            this.newsid = newsid;
        }

        public String getImg_count() {
            return img_count;
        }

        public void setImg_count(String img_count) {
            this.img_count = img_count;
        }

        public String getCh_id() {
            return ch_id;
        }

        public void setCh_id(String ch_id) {
            this.ch_id = ch_id;
        }
    }
}
