package com.xiaojun.yunqiantai;

import android.app.Application;

import com.xiaojun.yunqiantai.beans.MyObjectBox;

import io.objectbox.BoxStore;

/**
 * Created by Administrator on 2018/8/3.
 */

public class MyApplication extends Application {

    private static BoxStore mBoxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        mBoxStore = MyObjectBox.builder().androidContext(this).build();

    }

    public BoxStore getBoxStore(){
        return mBoxStore;
    }
}
