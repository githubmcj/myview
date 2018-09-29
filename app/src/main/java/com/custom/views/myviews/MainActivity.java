package com.custom.views.myviews;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wya.views.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {
    private BottomTabBar mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager())
                .setImgSize(60,60)//设置图片尺寸
                .setFontSize(12)//设置字体尺寸
                .setTabPadding(10,6,10)
                .setVisibility(false)
                .setChangeColor(Color.BLUE,Color.GRAY)//设置选中和未选中的颜色
                .addTabItem("标题1",R.mipmap.my_select,R.mipmap.my_normal, Fragment1.class)
                .addTabItem("标题2",R.mipmap.mystudy_select,R.mipmap.mystudy_normal, Fragment2.class)
                .isShowDivider(true)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {

                    }
                });
    }
}
