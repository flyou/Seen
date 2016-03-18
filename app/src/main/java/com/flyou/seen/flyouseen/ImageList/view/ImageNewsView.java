package com.flyou.seen.flyouseen.ImageList.view;

import com.flyou.seen.flyouseen.ImageList.domain.ImageNews;

import java.util.List;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.ImageList.view
 * 文件名：ImageNewsView
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/16 15:48
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public interface ImageNewsView {
    void  addImage(List<ImageNews.DataEntity>imageNewList);
    void  showLoading();
    void  hideLoading();
    void  shwoLoadFaild();
}
