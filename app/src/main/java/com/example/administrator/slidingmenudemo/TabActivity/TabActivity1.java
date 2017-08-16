package com.example.administrator.slidingmenudemo.TabActivity;

import android.view.View;
import android.widget.TextView;

import com.example.administrator.slidingmenudemo.BaseActivity;
import com.example.administrator.slidingmenudemo.R;
import com.example.administrator.slidingmenudemo.TabHostActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Administrator on 2017/8/15.
 */

public class TabActivity1 extends BaseActivity {
    private TextView tv_toggle;

    @Override
    protected void initVariables() {


    }

    @Override
    protected void initViews() {
      setContentView(R.layout.activity_tab1);
        tv_toggle = (TextView) findViewById(R.id.tv_toggle);
        tv_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TabHostActivity.toggle();
            }
        });

    }

    @Override
    protected void loadData() {

    }
}
