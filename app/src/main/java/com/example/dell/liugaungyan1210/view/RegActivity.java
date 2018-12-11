package com.example.dell.liugaungyan1210.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.liugaungyan1210.R;
import com.example.dell.liugaungyan1210.bean.RegBean;
import com.example.dell.liugaungyan1210.presenter.IPresentImfl;

public class RegActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private String url="http://www.zhaoapi.cn/user/reg?mobile=%s&password=%s";
    private EditText regphonenum , regpwssword;
    private Button reglter;
    private IPresentImfl miPresentImfl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        init();
        initData();
    }
    //互绑
    public void initData(){
        miPresentImfl = new IPresentImfl(this);
    }
    //解绑

    @Override
    protected void onDestroy() {
        super.onDestroy();
        miPresentImfl.des();
    }

    private void init() {
        regphonenum = findViewById(R.id.regphonnum);
        regpwssword= findViewById(R.id.regpassword);
        reglter = findViewById(R.id.reglter);
        reglter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.reglter:
                miPresentImfl.requestData(String.format(url,regphonenum.getText().toString(),regpwssword.getText().toString()),RegBean.class);
                break;
                default:
                    break;
        }
    }

    @Override
    public void success(Object data) {
          RegBean bean = (RegBean) data;
          if (bean.getCode().equals("0")){
              Intent intent = new Intent(RegActivity.this,MainActivity.class);
              startActivity(intent);
          }
          else {
              Toast.makeText(RegActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
          }
    }
}
