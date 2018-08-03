package com.xiaojun.yunqiantai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.xiaojun.yunqiantai.beans.CeShi;
import com.xiaojun.yunqiantai.beans.CeShi_;

import java.util.List;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CeShi ceShi=new CeShi(123L,"ddd");

        Box<CeShi> beanBox = ((MyApplication)getApplication()).getBoxStore().boxFor(CeShi.class);
        beanBox.put(ceShi);
        //查询，名字为 T 开头或者 uom 为 kg 的数据
        List<CeShi> item = beanBox.query()
                .startsWith(CeShi_.name,"d")
               .build().find();
        Log.d("MainActivity", "item.size():" + item.size());
        Log.d("MainActivity", "beanBox.get(123):" + beanBox.get(123));


        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
