package com.flyou.seen.flyouseen.imageDetial.presenter;

import com.flyou.seen.flyouseen.imageDetial.domain.ImageDetialDomain;
import com.flyou.seen.flyouseen.imageDetial.model.ImageDetialModel;
import com.flyou.seen.flyouseen.imageDetial.model.ImageDetialModelImpl;
import com.flyou.seen.flyouseen.imageDetial.view.ImageDetialView;

import java.util.List;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.imageDetial.presenter
 * 文件名：ImageDetialListPersenterImol
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/17 11:53
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class ImageDetialListPersenterImol implements ImageDetialPersenter,ImageDetialModelImpl.onImageDetialPaserListenter {
    private ImageDetialView imageDetialView;
    private  ImageDetialModel imageDetialModel;

    public ImageDetialListPersenterImol(ImageDetialView imageDetialView) {
        this.imageDetialView = imageDetialView;
        this.imageDetialModel=new ImageDetialModelImpl();

    }
    @Override
    public void getImageDetialList(String url) {
        imageDetialModel.getImageDetia(url,this);
        imageDetialView.showLoading();
    }


    @Override
    public void onSuccess(List<ImageDetialDomain> imageDetialDomainList,String aticle) {
        imageDetialView.GetImageDetialList(imageDetialDomainList,aticle);
        imageDetialView.hideLoading();
    }

    @Override
    public void onFaild(String msg) {
        imageDetialView.hideLoading();
      imageDetialView.shwoLoadFaild();
    }


}
