package com.flyou.seen.flyouseen.imageDetial.model;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.imageDetial.model
 * 文件名：ImageDetialModel
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/17 10:38
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public interface ImageDetialModel {
    void  getImageDetia(String url,ImageDetialModelImpl.onImageDetialPaserListenter listener);
}
