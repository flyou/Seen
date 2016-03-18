package com.flyou.seen.flyouseen.imageDetial.widget;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.flyou.seen.flyouseen.R;
import com.flyou.seen.flyouseen.imageDetial.adapter.GalleryPagerAdapter;
import com.flyou.seen.flyouseen.imageDetial.domain.ImageDetialDomain;

import java.util.ArrayList;

public class ImageGalleryActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private  ArrayList<ImageDetialDomain> mImageNewList;
    private PagerAdapter mAdapter;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image_gallery);

        initView();

        initDate();

        setListener();
    }



    protected void initView() {
        mToolBar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mViewPager= (ViewPager) findViewById(R.id.viewpager);

    }


    protected void initDate() {
         mImageNewList = getIntent().getParcelableArrayListExtra("imageNewList");

    }


    protected void setListener() {
        mAdapter=new GalleryPagerAdapter(ImageGalleryActivity.this,mImageNewList);
        mViewPager.setAdapter(mAdapter);
    }
}
