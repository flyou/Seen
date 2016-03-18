package com.flyou.seen.flyouseen.imageDetial.model;

import android.os.AsyncTask;
import android.util.Log;

import com.flyou.seen.flyouseen.imageDetial.domain.ImageDetialDomain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.imageDetial.model
 * 文件名：ImageDetialModelImpl
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/17 10:42
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class ImageDetialModelImpl implements ImageDetialModel {
    private onImageDetialPaserListenter listener;

    @Override
    public void getImageDetia(String url, onImageDetialPaserListenter listener) {
        this.listener = listener;
        new getImageDetialTask().execute(url);
    }

    public interface onImageDetialPaserListenter {
        void onSuccess(List<ImageDetialDomain> imageDetialDomainList, String article);

        void onFaild(String msg);
    }

    /*
    * 解析网页数据
    * */
    private class getImageDetialTask extends AsyncTask<String, List<ImageDetialDomain>, List<ImageDetialDomain>> {
        private String mArticle;

        @Override
        protected List<ImageDetialDomain> doInBackground(String... params) {
            List<ImageDetialDomain> imageDetialDomainList = new ArrayList<>();
            Document doc = null;
            try {
                doc = Jsoup.connect(params[0]).get();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                doc.charset(Charset.forName("gb2312"));
                //图片
                Elements elementsImage = doc.getElementsByClass("scroll-item");
                //图片描述
                Element elementsImageDesc = doc.getElementById("imageTextDesc");
                Elements elementsByTag = elementsImageDesc.getElementsByTag("p");
                //循环得到图片列表和图片描述
                for (int i = 0; i < elementsByTag.size(); i++) {
                    String imageDesc = elementsByTag.get(i).text();
                    String imageurl = elementsImage.get(i).getElementsByTag("img").first().attr("src");
                    imageDetialDomainList.add(new ImageDetialDomain(imageurl, imageDesc));

                }


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            try {
                //文章
                Element elementarticle = doc.getElementsByClass("article").first();
                mArticle = elementarticle.toString();
            } catch (Exception e) {
                mArticle = "<center>没有发现相关文章,试试图集吧！</center>";
            }
            return imageDetialDomainList;
        }

        @Override
        protected void onPostExecute(List<ImageDetialDomain> imageDetialDomainList) {

            if (null == imageDetialDomainList || imageDetialDomainList.size() == 0) {
                listener.onFaild("加载数据失败");
            } else {
                listener.onSuccess(imageDetialDomainList, mArticle);
                Log.e("flyou", mArticle);
            }

            super.onPostExecute(imageDetialDomainList);
        }
    }
}
