package com.flyou.seen.flyouseen.ImageList.presenter;

import com.flyou.seen.flyouseen.ImageList.domain.ImageNews;
import com.flyou.seen.flyouseen.ImageList.model.ImageListModelImpl;
import com.flyou.seen.flyouseen.ImageList.view.ImageNewsView;

import java.util.List;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.ImageList.presenter
 * 文件名：ImageNewPresenterImpl
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/16 15:57
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class ImageNewPresenterImpl implements ImgaeNewPresenter, ImageListModelImpl.OnImageNewLoadListenter {
    private ImageNewsView mImageNews;
    private ImageListModelImpl mImageListModel;


    public ImageNewPresenterImpl(ImageNewsView imageNews) {
        this.mImageListModel = new ImageListModelImpl();
        this.mImageNews = imageNews;

    }



    @Override
    public void getImageList(int page) {
        if (page==1) {
            mImageNews.showLoading();
        }
        mImageListModel.getImageNewList(page, this);
    }

    @Override
    public void onSuccess(List<ImageNews.DataEntity> imageNews) {
        mImageNews.hideLoading();
        mImageNews.addImage(imageNews);
    }

    @Override
    public void onFailed(String msg, Exception e) {
        mImageNews.hideLoading();
        mImageNews.shwoLoadFaild();
    }

}
