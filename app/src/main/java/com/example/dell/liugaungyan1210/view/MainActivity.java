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
import com.example.dell.liugaungyan1210.bean.UserBean;
import com.example.dell.liugaungyan1210.presenter.IPresentImfl;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private String url="http://www.zhaoapi.cn/user/login?mobile=%s&password=%s";
    private EditText phonenum , pwssword;
    private Button login,threelogin;
    private TextView reg;
    private IPresentImfl miPresentImfl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        phonenum = findViewById(R.id.phonnum);
        pwssword = findViewById(R.id.password);
        login = findViewById(R.id.login);
        threelogin = findViewById(R.id.threelogin);
        reg = findViewById(R.id.reg);
        login.setOnClickListener(this);
        reg.setOnClickListener(this);
        threelogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.login:
                  miPresentImfl.requestData(String.format(url,phonenum.getText().toString(),pwssword.getText().toString()),UserBean.class);
                break;
            case R.id.reg:
                Intent intent = new Intent(MainActivity.this,RegActivity.class);
                startActivity(intent);
                break;
            case R.id.threelogin:
                UMShareAPI umShareAPI =  UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        miPresentImfl.requestData(String.format(url,phonenum.getText().toString(),pwssword.getText().toString()),UserBean.class);
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });

                default:
                    break;
        }
    }

    @Override
    public void success(Object data) {
          UserBean bean = (UserBean) data;
          if (bean.getCode().equals("0")){
              Intent intent = new Intent(MainActivity.this,LoginActivity.class);
              startActivity(intent);
          }
          else {
              Toast.makeText(MainActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
          }
    }
}
