package com.flyou.seen.flyouseen.imageDetial.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.imageDetial.domain
 * 文件名：ImageDetialDomain
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/17 10:36
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class ImageDetialDomain implements Parcelable {
    private String imageUrl;
    private String imageDesc;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageDesc() {
        return imageDesc;
    }

    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }

    public ImageDetialDomain(String imageUrl, String imageDesc) {
        this.imageUrl = imageUrl;
        this.imageDesc = imageDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeString(this.imageDesc);
    }

    protected ImageDetialDomain(Parcel in) {
        this.imageUrl = in.readString();
        this.imageDesc = in.readString();
    }

    public static final Parcelable.Creator<ImageDetialDomain> CREATOR = new Parcelable.Creator<ImageDetialDomain>() {
        @Override
        public ImageDetialDomain createFromParcel(Parcel source) {
            return new ImageDetialDomain(source);
        }

        @Override
        public ImageDetialDomain[] newArray(int size) {
            return new ImageDetialDomain[size];
        }
    };
}
