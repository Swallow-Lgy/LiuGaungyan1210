package com.example.dell.liugaungyan1210.view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dell.liugaungyan1210.R;
import com.example.dell.liugaungyan1210.adpter.MyPageradpter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyPageradpter pageradpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewPager = findViewById(R.id.viewpager);

        tabLayout = findViewById(R.id.tab);
        pageradpter = new MyPageradpter(getSupportFragmentManager());

        viewPager.setAdapter(pageradpter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {


    }

    @Override
    public void success(Object data) {

    }
}
