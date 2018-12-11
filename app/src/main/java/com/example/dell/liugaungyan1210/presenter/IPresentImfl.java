package com.example.dell.liugaungyan1210.presenter;

import com.example.dell.liugaungyan1210.call.MyCallBack;
import com.example.dell.liugaungyan1210.model.IModelImpl;
import com.example.dell.liugaungyan1210.view.IView;

public class IPresentImfl implements  IPresenter{
    private IView miView;
    private IModelImpl miModel;
    public IPresentImfl(IView iView){
        miView = iView;
        miModel = new IModelImpl();
    }
    @Override
    public void requestData(String url, Class clazz) {
          miModel.requestData(url, clazz, new MyCallBack() {
              @Override
              public void setData(Object data) {
                  miView.success(data);
              }
          });
    }
    public void  des(){
        if (miModel!=null){
            miModel=null;
        }
        if (miView!=null){
            miView=null;
        }
    }
}
