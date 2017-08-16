package com.example.administrator.slidingmenudemo;

import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.example.administrator.slidingmenudemo.TabActivity.TabActivity1;
import com.example.administrator.slidingmenudemo.TabActivity.TabActivity2;
import com.example.administrator.slidingmenudemo.TabActivity.TabActivity3;
import com.example.administrator.slidingmenudemo.TabActivity.TabActivity4;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Administrator on 2017/8/15.
 */

public class TabHostActivity extends TabActivity {
    public static TabHost mth;
    public static final String TAB_1 = "主页";
    public static final String TAB_2 = "帅哥";
    public static final String TAB_3 = "美女";
    public static final String TAB_4 = "我的";

    public static RadioGroup radioGroup;
    public static RadioButton radio_button0;
    public static RadioButton radio_button1;
    public static RadioButton radio_button2;
    public static RadioButton radio_button3;
    private ImageView iv_tab_center;
    private static Context mContext;
    private leftMenuFragment mLeftMenuFragment;
    private static SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        mContext = this;
        initViews();
        initSlidingMenu();
    }

    private void initSlidingMenu() {
        mLeftMenuFragment = new leftMenuFragment();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_leftmenu, mLeftMenuFragment).commit();


        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
//        menu.setShadowWidthRes(R.dimen.shadow_width);
//        menu.setShadowDrawable(R.drawable.shadow);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置宽度
        // menu.setBehindWidth(500);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.leftmenu);

//        menu.setOnClosedListener(new SlidingMenu.OnClosedListener() {
//            @Override
//            public void onClosed() {
//
//            }
//        });
//
//
//
//        menu.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
//            @Override
//            public void onOpened() {
//
//            }
//        });


    }

    private void initViews() {
        //中间按钮
        iv_tab_center = (ImageView) this.findViewById(R.id.iv_tab_center);
        tabCenterClick();
        mth = this.getTabHost();

        TabHost.TabSpec ts1 = mth.newTabSpec(TAB_1).setIndicator(TAB_1);

        ts1.setContent(new Intent(TabHostActivity.this, TabActivity1.class));
        mth.addTab(ts1);

        TabHost.TabSpec ts2 = mth.newTabSpec(TAB_2).setIndicator(TAB_2);
        ts2.setContent(new Intent(TabHostActivity.this, TabActivity2.class));// .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        mth.addTab(ts2);

        TabHost.TabSpec ts3 = mth.newTabSpec(TAB_3).setIndicator(TAB_3);
        ts3.setContent(new Intent(TabHostActivity.this, TabActivity3.class));
        mth.addTab(ts3);

        TabHost.TabSpec ts4 = mth.newTabSpec(TAB_4).setIndicator(TAB_4);
        ts4.setContent(new Intent(TabHostActivity.this, TabActivity4.class));
        mth.addTab(ts4);

        radioGroup = (RadioGroup) findViewById(R.id.main_radio);

        radio_button0 = (RadioButton) radioGroup.findViewById(R.id.radio_button0);
        radio_button1 = (RadioButton) radioGroup.findViewById(R.id.radio_button1);
        radio_button2 = (RadioButton) radioGroup.findViewById(R.id.radio_button2);
        radio_button3 = (RadioButton) radioGroup.findViewById(R.id.radio_button3);

        checkMenuStyle(R.drawable.icon_zy_4, radio_button0, this.getResources().getColor(R.color.sy_color4));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkMenuStyle_Reduction();
                switch (checkedId) {
                    case R.id.radio_button0:
                        mth.setCurrentTabByTag(TAB_1);
                        checkMenuStyle(R.drawable.icon_zy_4, radio_button0, getResources().getColor(R.color.sy_color4));
                        break;
                    case R.id.radio_button1:
                        mth.setCurrentTabByTag(TAB_2);
                        checkMenuStyle(R.drawable.icon_hz_4, radio_button1, getResources().getColor(R.color.sy_color4));
                        break;
                    case R.id.radio_button2:
                        mth.setCurrentTabByTag(TAB_3);
                        checkMenuStyle(R.drawable.icon_mgc_4, radio_button2, getResources().getColor(R.color.sy_color4));
                        break;
                    case R.id.radio_button3:
                        mth.setCurrentTabByTag(TAB_4);
                        checkMenuStyle(R.drawable.icon_wd_4, radio_button3, getResources().getColor(R.color.sy_color4));
                        break;
                }
            }
        });
    }

    /**
     * 选中
     */
    public static void checkMenuStyle(int id, RadioButton radio_button, int textColor) {
        Drawable lightDrawable = mContext.getResources().getDrawable(id);
        lightDrawable.setBounds(0, 0, lightDrawable.getMinimumWidth(), lightDrawable.getMinimumHeight());
        radio_button.setCompoundDrawables(null, lightDrawable, null, null);
        radio_button.setTextColor(textColor);
    }

    /**
     * 还原
     */
    public static void checkMenuStyle_Reduction() {
        checkMenuStyle(R.drawable.icon_zy_3, radio_button0, mContext.getResources().getColor(R.color.sy_color3));
        checkMenuStyle(R.drawable.icon_hz_3, radio_button1, mContext.getResources().getColor(R.color.sy_color3));
        checkMenuStyle(R.drawable.icon_mgc_3, radio_button2, mContext.getResources().getColor(R.color.sy_color3));
        checkMenuStyle(R.drawable.icon_wd_3, radio_button3, mContext.getResources().getColor(R.color.sy_color3));
    }

    private void tabCenterClick() {

    }

    public static void toggle() {
        menu.toggle();
    }
}
