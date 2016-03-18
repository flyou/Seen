package com.flyou.seen.flyouseen.ImageList.widget;


import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flyou.seen.flyouseen.ImageList.adapter.ImageNewsRecycleViewAdapter;
import com.flyou.seen.flyouseen.ImageList.domain.ImageNews;
import com.flyou.seen.flyouseen.ImageList.presenter.ImageNewPresenterImpl;
import com.flyou.seen.flyouseen.ImageList.presenter.ImgaeNewPresenter;
import com.flyou.seen.flyouseen.ImageList.view.ImageNewsView;
import com.flyou.seen.flyouseen.R;
import com.flyou.seen.flyouseen.base.BaseActivity;
import com.flyou.seen.flyouseen.imageDetial.widget.ImageNewDetialActivity;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MainActivity extends BaseActivity implements ImageNewsView, SwipeRefreshLayout.OnRefreshListener {

    private ImgaeNewPresenter mImageNewPresenter;
    private int currentPage = 1;
    private AVLoadingIndicatorView loadingView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private Toolbar toolbar;
    private TextView title;


    private LinearLayoutManager layoutManager;
    private ImageNewsRecycleViewAdapter adapter;

    private List<ImageNews.DataEntity> mImageNewsList;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;//把设置布局文件的操作交给继承的子类;
    }

    @Override
    protected void initView() {
        title = (TextView) findViewById(R.id.title);
        title.setText("看见");
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        loadingView = (AVLoadingIndicatorView) findViewById(R.id.loadingView);


        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }


    @Override
    protected void initDate() {
        mImageNewPresenter = new ImageNewPresenterImpl(this);
        mImageNewPresenter.getImageList(currentPage);
    }

    @Override
    protected void setListener() {
        mSwipeRefreshLayout.setOnRefreshListener(this);

        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

    }


    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void addImage(List<ImageNews.DataEntity> imageNewList) {

        if (currentPage == 1) {
            mImageNewsList = imageNewList;

                adapter = new ImageNewsRecycleViewAdapter(MainActivity.this, mImageNewsList);
                mRecyclerView.setItemAnimator(new SlideInLeftAnimator());
                mRecyclerView.setAdapter(new ScaleInAnimationAdapter(adapter));
                mRecyclerView.addOnScrollListener(mOnScrollListener);
                adapter.setOnItemClickLitener(new onItiemClickListener());


        } else {
            int lastPosition = mImageNewsList.size() - 1;
            mImageNewsList.addAll(imageNewList);
            adapter.notifyItemRangeInserted(lastPosition, imageNewList.size());
        }

    }


    @Override
    public void hideLoading() {
        loadingView.setVisibility(View.INVISIBLE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void shwoLoadFaild() {
        loadingView.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "shwoLoadFaild", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        currentPage = 1;
        mImageNewPresenter.getImageList(currentPage);
    }

    public class onItiemClickListener implements ImageNewsRecycleViewAdapter.OnItemClickLitener {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(MainActivity.this, ImageNewDetialActivity.class);
            View transitionView = view.findViewById(R.id.imageView);

            intent.putExtra("image_new_url", mImageNewsList.get(position).getUrl());
            intent.putExtra("image_url", mImageNewsList.get(position).getCover_thumb_url());
            intent.putExtra("image_new_title", mImageNewsList.get(position).getName());
            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                            transitionView, getString(R.string.transition_news_img));

            ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());

        }

        @Override
        public void onItemLongClick(View view, int position) {

        }
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = layoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == adapter.getItemCount()
                    && adapter.isShowFooter()) {
                currentPage++;
                mImageNewPresenter.getImageList(currentPage);
            }
        }
    };
}
