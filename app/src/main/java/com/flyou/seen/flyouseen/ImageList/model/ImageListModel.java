package com.flyou.seen.flyouseen.ImageList.model;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.ImageList.model
 * 文件名：ImageListModel
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/15 15:35
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public interface ImageListModel {
    void getImageNewList(int page,ImageListModelImpl.OnImageNewLoadListenter listenter);
}
