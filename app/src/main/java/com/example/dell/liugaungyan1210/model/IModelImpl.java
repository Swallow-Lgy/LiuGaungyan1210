package com.example.dell.liugaungyan1210.model;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.example.dell.liugaungyan1210.call.MyCallBack;
import com.example.dell.liugaungyan1210.util.ICallBack;
import com.example.dell.liugaungyan1210.util.NetUtil;
import com.example.dell.liugaungyan1210.util.OkHttp;
import com.google.gson.Gson;

import java.util.HashMap;

public class IModelImpl implements  IModel{
    @SuppressLint("StaticFieldLeak")
    @Override
    public void requestData(final String url, final Class clazz, final MyCallBack callBack) {
         /* new AsyncTask<String, Void, Object>() {
              @Override
              protected Object doInBackground(String... strings) {
                  return getGson(strings[0],calzz);
              }

              @Override
              protected void onPostExecute(Object o) {
                  callBack.setData(o);
              }
          }.execute(url);*/
        OkHttp.getmInstance().postEnqueue(url, new HashMap<String, String>(), new ICallBack() {
            @Override
            public void success(Object obj) {
                callBack.setData(obj);
            }

            @Override
            public void failed(Exception e) {
                callBack.setData(e.getMessage());
            }
        },clazz);
    }

  /*  public <T> T getGson(String url,Class calzz){
        return (T) new Gson().fromJson(NetUtil.getData(url),calzz);
    }*/

}
