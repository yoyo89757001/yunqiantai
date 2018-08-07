package megvii.testfacepass;

import android.app.Application;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

import cn.jpush.android.api.JPushInterface;
import io.objectbox.BoxStore;
import megvii.testfacepass.beans.MyObjectBox;

/**
 * Created by Administrator on 2018/8/3.
 */

public class MyApplication extends Application {

    private static BoxStore mBoxStore;
    public static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        mBoxStore = MyObjectBox.builder().androidContext(this).build();
        //适配
        ScreenAdapterTools.init(this);
        JPushInterface.setDebugMode(false); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }

    public BoxStore getBoxStore(){
        return mBoxStore;
    }

}
