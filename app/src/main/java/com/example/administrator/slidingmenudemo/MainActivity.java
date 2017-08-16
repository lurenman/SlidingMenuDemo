package com.example.administrator.slidingmenudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_tabhost)
    TextView tv_Tabhost;
    @BindView(R.id.tv_fragment_radio)
    TextView tv_FragmentRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RxView.clicks(tv_Tabhost).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Intent intent = new Intent(MainActivity.this, TabHostActivity.class);
                startActivity(intent);

            }
        });
        RxView.clicks(tv_FragmentRadio).throttleFirst(500,TimeUnit.MILLISECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {

            }
        });

    }
}
