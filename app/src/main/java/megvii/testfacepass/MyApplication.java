package megvii.testfacepass;

import android.app.Application;
import android.util.Log;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

import butterknife.internal.Utils;
import cn.jpush.android.api.JPushInterface;
import io.objectbox.BoxStore;
import megvii.testfacepass.beans.MyObjectBox;
import megvii.testfacepass.utils.FileUtil;

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
        JPushInterface.init(getApplicationContext());
        JPushInterface.setAlias(getApplicationContext(),1, FileUtil.getSerialNumber(this)==null?FileUtil.getIMSI():FileUtil.getSerialNumber(this));

    }

    public BoxStore getBoxStore(){
        return mBoxStore;
    }

}
