package com.example.dell.liugaungyan1210.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dell.liugaungyan1210.R;
import com.example.dell.liugaungyan1210.bean.NewBean;
import com.example.dell.liugaungyan1210.presenter.IPresentImfl;
import com.example.dell.liugaungyan1210.view.IView;
import com.example.dell.liugaungyan1210.view.LoginActivity;
import com.example.dell.liugaungyan1210.view.SaoActivity;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

public class FragmentShow extends Fragment implements View.OnClickListener,IView {
    private Button QR;
    private IPresentImfl miPresentImfl;
    private String url="http://www.zhaoapi.cn/home/getHome";
    private List<String> mList;
    private FlyBanner flyBanner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentshow,container,false);
       QR = view.findViewById(R.id.QR);
      flyBanner =   view.findViewById(R.id.flybaner);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       QR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SaoActivity.class);
                startActivity(intent);
            }
        });
       miPresentImfl = new IPresentImfl(this);
      miPresentImfl.requestData(url,NewBean.class);
      mList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void success(Object data) {
         NewBean bean = (NewBean) data;
        List<NewBean.DataBean.BannerBean> banner = bean.getData().getBanner();
       for (int i = 0; i<banner.size();i++){
           String icon = banner.get(i).getImage();
           mList.add(icon);
       }
       flyBanner.setImagesUrl(mList);
    }
}
