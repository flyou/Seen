package com.flyou.seen.flyouseen.imageDetial.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flyou.seen.flyouseen.R;
import com.flyou.seen.flyouseen.imageDetial.domain.ImageDetialDomain;
import com.flyou.seen.flyouseen.utils.ColorPhrase;

import java.util.ArrayList;

/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.imageDetial.adapter
 * 文件名：GalleryPagerAdapter
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/18 9:16
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public class GalleryPagerAdapter extends PagerAdapter {
    private ArrayList<ImageDetialDomain> mImageDetialDomains;
    private Context mContext;

    public GalleryPagerAdapter(Context context, ArrayList<ImageDetialDomain> imageDetialDomains) {
        mImageDetialDomains = imageDetialDomains;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImageDetialDomains.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View contentView = View.inflate(mContext, R.layout.view_image_gallery_item, null);
        ImageView imageView = (ImageView) contentView.findViewById(R.id.image);
        TextView imgaeDes = (TextView) contentView.findViewById(R.id.imageDesc);
        TextView pages= (TextView) contentView.findViewById(R.id .pages);
        CharSequence formatted = ColorPhrase.from("{"+(1+position+"}/"+mImageDetialDomains.size()))
                .withSeparator("{}")
                .innerColor(0xFF00ff1d)
                .outerColor(0xFFf40c10)
                .format();
        pages.setText(formatted);
        Glide.with(mContext)
                .load(mImageDetialDomains.get(position).getImageUrl())
                .placeholder(R.drawable.pic_loading)

                .into(imageView);
        imgaeDes.setText(mImageDetialDomains.get(position).getImageDesc());
        container.addView(contentView);
        return contentView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
}
