package com.example.dell.liugaungyan1210.adpter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dell.liugaungyan1210.fragment.FragmentElse;
import com.example.dell.liugaungyan1210.fragment.FragmentShow;

public class MyPageradpter extends FragmentPagerAdapter {
    String[] pager = new String[]{
      "首页","其他" ,"其他","其他","其他",
    };
    public MyPageradpter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new FragmentShow();
                default:
                    return new FragmentElse();

        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pager[position];
    }

    @Override
    public int getCount() {
        return pager.length;
    }
}
