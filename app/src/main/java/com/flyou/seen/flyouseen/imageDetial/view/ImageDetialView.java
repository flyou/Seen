package com.flyou.seen.flyouseen.imageDetial.view;

import com.flyou.seen.flyouseen.imageDetial.domain.ImageDetialDomain;

import java.util.List;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.imageDetial.view
 * 文件名：ImageDetialView
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/17 11:50
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public interface ImageDetialView {
    void  GetImageDetialList(List<ImageDetialDomain>imageDetialDomainList,String article);
    void  showLoading();
    void  hideLoading();
    void  shwoLoadFaild();
}
