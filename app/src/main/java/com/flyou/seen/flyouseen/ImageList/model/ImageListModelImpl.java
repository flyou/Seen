package com.flyou.seen.flyouseen.ImageList.model;

import com.google.gson.Gson;
import com.flyou.seen.flyouseen.ImageList.domain.ImageNews;
import com.flyou.seen.flyouseen.comm.APi;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.ImageList.model
 * 文件名：ImageListModelImpl
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/15 15:36
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class ImageListModelImpl implements ImageListModel {

    @Override
    public void getImageNewList(int page, final OnImageNewLoadListenter listenter) {
        OkHttpUtils
                .get()
                .url(APi.IMAGE_NEW_LIST_URL + "page=" + page)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        listenter.onFailed(e.getMessage(), e);
                    }

                    @Override
                    public void onResponse(String response) {
                        try {
                            String json = response.split("\\(")[1].split("\\)")[0];
                            ImageNews imageNews = new Gson().fromJson(json, ImageNews.class);
                            listenter.onSuccess(imageNews.getData());
                        }
                       catch (Exception e){

                       }

                    }
                });
    }

    public interface OnImageNewLoadListenter {
        void onSuccess(List<ImageNews.DataEntity> imageNews);
        void onFailed(String msg, Exception e);
    }
}
