package com.flyou.seen.flyouseen.imageDetial.widget;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.flyou.seen.flyouseen.R;
import com.flyou.seen.flyouseen.base.BaseActivity;
import com.flyou.seen.flyouseen.imageDetial.domain.ImageDetialDomain;
import com.flyou.seen.flyouseen.imageDetial.presenter.ImageDetialListPersenterImol;
import com.flyou.seen.flyouseen.imageDetial.presenter.ImageDetialPersenter;
import com.flyou.seen.flyouseen.imageDetial.view.ImageDetialView;
import com.wang.avi.AVLoadingIndicatorView;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.List;

public class ImageNewDetialActivity extends BaseActivity implements ImageDetialView {
    private ImageView mCoverImage;
    private CollapsingToolbarLayout mCollapsing_toolbar;
    private Toolbar mToolbar;
    private ImageDetialPersenter mImageDetialPersenter;
    private HtmlTextView mHtNewsContent;
    private AVLoadingIndicatorView mLoadingView;
    private FloatingActionButton mFloatBuuton;

    ArrayList<ImageDetialDomain> mIageDetialDomainList;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_image_new_detial;
    }

    @Override
    protected void initView() {
        mLoadingView = (AVLoadingIndicatorView) findViewById(R.id.loadingView);
        mHtNewsContent = (HtmlTextView) findViewById(R.id.htNewsContent);
        mCoverImage = (ImageView) findViewById(R.id.coverImage);
        mCollapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFloatBuuton = (FloatingActionButton) findViewById(R.id.floatBuuton);

    }

    @Override
    protected void initDate() {
        String imgaeNewUrl = getIntent().getStringExtra("image_new_url");
        String imageUrl = getIntent().getStringExtra("image_url");
        String imageNewTitle = getIntent().getStringExtra("image_new_title");

        mCollapsing_toolbar.setTitle(imageNewTitle);
        Glide.with(ImageNewDetialActivity.this)
                .load(imageUrl)
                .into(mCoverImage);

        mImageDetialPersenter = new ImageDetialListPersenterImol(this);
        mImageDetialPersenter.getImageDetialList(imgaeNewUrl);
    }

    @Override
    protected void setListener() {
        try {

            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
        catch (Exception e){

        }
        //返回按钮

        //floatActionButton
        mFloatBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null == mIageDetialDomainList) {
                    return;
                }

                Intent intent = new Intent(ImageNewDetialActivity.this, ImageGalleryActivity.class);
                intent.putParcelableArrayListExtra("imageNewList",mIageDetialDomainList);
                startActivity(intent);
            }
        });

    }

    @Override
    public void GetImageDetialList(List<ImageDetialDomain> imageDetialDomainList, String aticle) {
        mIageDetialDomainList = (ArrayList)imageDetialDomainList;
        mHtNewsContent.setHtmlFromString(aticle, new HtmlTextView.RemoteImageGetter());

    }

    @Override
    public void showLoading() {
        mLoadingView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        mLoadingView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void shwoLoadFaild() {
        mLoadingView.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        mHtNewsContent.destroyDrawingCache();
        mHtNewsContent=null;
        super.onDestroy();
    }
}
