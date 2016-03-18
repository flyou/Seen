package com.flyou.seen.flyouseen.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.flyou.seen.flyouseen.R;
import com.flyou.seen.flyouseen.utils.SystemBarTintManager;



/**
 * ============================================================
 * 项目名称：HotWXReading
 * 包名称：com.liuyajuan.login.hotwxreading.base
 * 文件名：BaseActivity
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2016/3/3 16:48
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 **/
public abstract  class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());//把设置布局文件的操作交给继承的子类
    ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
    View parentView = contentFrameLayout.getChildAt(0);
    if (parentView != null && Build.VERSION.SDK_INT >= 14) {
        parentView.setFitsSystemWindows(true);
    }
    SystemBarTintManager tintManager = new SystemBarTintManager(this);
    // enable status bar tint
    tintManager.setStatusBarTintEnabled(true);
    // enable navigation bar tint
    tintManager.setNavigationBarTintEnabled(true);
    // set a custom tint color for all system bars
    tintManager.setTintColor(getResources().getColor(R.color.colorPrimary));
    // set a custom navigation bar resource
    tintManager.setNavigationBarTintColor(getResources().getColor(R.color.colorPrimary));
    initView();
    initDate();
    setListener();

}


    //传入当前布局文件的id 如R.layout.main
    protected abstract int getLayoutResId();
    //初始化view
    protected abstract void initView();

    //初始化date
    protected abstract void initDate();

    //设置adapter
    protected abstract void setListener();


    @Override
    protected void onDestroy() {


        super.onDestroy();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onResume() {



        super.onResume();
    }
}
