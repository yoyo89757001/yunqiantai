package megvii.testfacepass.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

import megvii.facepass.ruitong.FaceInit;
import megvii.testfacepass.MyApplication;
import megvii.testfacepass.R;
import megvii.testfacepass.beans.BaoCunBean;
import megvii.testfacepass.dialog.BangDingDialog;
import megvii.testfacepass.dialog.XiuGaiDiZhiDialog;
import megvii.testfacepass.dialog.YuYingDialog;

import okhttp3.OkHttpClient;


public class SheZhiActivity extends Activity {
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.rl2)
    RelativeLayout rl2;

    private Box<BaoCunBean> baoCunBeanDao = null;
    private BaoCunBean baoCunBean = null;
    public OkHttpClient okHttpClient=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        ButterKnife.bind(this);
        //ScreenAdapterTools.getInstance().reset(this);//如果希望android7.0分屏也适配的话,加上这句
        //在setContentView();后面加上适配语句
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());
        baoCunBeanDao = MyApplication.myApplication.getBoxStore().boxFor(BaoCunBean.class);
        baoCunBean = baoCunBeanDao.get(123456L);
        if (baoCunBean == null) {
            baoCunBean = new BaoCunBean();
            baoCunBean.setId(123456L);
            baoCunBean.setHoutaiDiZhi("http://192.168.2.187:8980/js/f");
            baoCunBeanDao.put(baoCunBean);
        }
        EventBus.getDefault().register(this);//订阅

    }



    @OnClick({R.id.rl1, R.id.rl2,R.id.rl3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl1:
                final XiuGaiDiZhiDialog diZhiDialog = new XiuGaiDiZhiDialog(SheZhiActivity.this);
                diZhiDialog.setCanceledOnTouchOutside(false);
                diZhiDialog.setContents(baoCunBean.getHoutaiDiZhi(), null);
                diZhiDialog.setOnQueRenListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        baoCunBean.setHoutaiDiZhi(diZhiDialog.getUrl());
                        baoCunBeanDao.put(baoCunBean);
                        diZhiDialog.dismiss();
                    }
                });
                diZhiDialog.setQuXiaoListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        diZhiDialog.dismiss();
                    }
                });
                diZhiDialog.show();

                break;
            case R.id.rl2:
                final BangDingDialog bangDingDialog = new BangDingDialog(SheZhiActivity.this);
                bangDingDialog.setCanceledOnTouchOutside(false);
                bangDingDialog.setOnQueRenListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        link_uplodexiazai(bangDingDialog.getZhuCeMa());
                        FaceInit init=new FaceInit(getApplicationContext());
                        init.init(bangDingDialog.getZhuCeMa(),baoCunBean.getHoutaiDiZhi());

                        bangDingDialog.dismiss();
                    }
                });
                bangDingDialog.setQuXiaoListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bangDingDialog.dismiss();
                    }
                });
                bangDingDialog.show();

                break;
            case R.id.rl3:
                YuYingDialog yuYingDialog=new YuYingDialog(SheZhiActivity.this);
                yuYingDialog.show();
                break;

        }
    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//解除订阅
        startActivity(new Intent(SheZhiActivity.this,MainActivity.class));
    }

//    //绑定
//    private void link_uplodexiazai(String zhucema){
//        //	final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
//        OkHttpClient okHttpClient= new OkHttpClient();
//        //RequestBody requestBody = RequestBody.create(JSON, json);
//        RequestBody body = new FormBody.Builder()
//                .add("registerCode",zhucema)
//                .add("machineCode", FileUtil.getSerialNumber(this) == null ? FileUtil.getIMSI() : FileUtil.getSerialNumber(this))
//                .build();
//        Request.Builder requestBuilder = new Request.Builder()
////				.header("Content-Type", "application/json")
////				.header("user-agent","Koala Admin")
//                //.post(requestBody)
//                //.get()
//                .post(body)
//                .url(baoCunBean.getHoutaiDiZhi()+"/app/machineSave");
//
//        // step 3：创建 Call 对象
//        Call call = okHttpClient.newCall(requestBuilder.build());
//        //step 4: 开始异步请求
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d("AllConnects", "请求失败"+e.getMessage());
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast tastyToast= TastyToast.makeText(SheZhiActivity.this,"请求失败，请检查地址和网络",TastyToast.LENGTH_LONG,TastyToast.ERROR);
//                        tastyToast.setGravity(Gravity.CENTER,0,0);
//                        tastyToast.show();
//                    }
//                });
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                Log.d("AllConnects", "请求成功"+call.request().toString());
//                //获得返回体
//                try{
//
//                    ResponseBody body = response.body();
//                    String ss=body.string().trim();
//                    Log.d("AllConnects", "注册码"+ss);
//					final JsonObject jsonObject= GsonUtil.parse(ss).getAsJsonObject();
//					Gson gson=new Gson();
//					runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast tastyToast= TastyToast.makeText(SheZhiActivity.this,jsonObject.get("message").getAsString(),TastyToast.LENGTH_LONG,TastyToast.INFO);
//                            tastyToast.setGravity(Gravity.CENTER,0,0);
//                            tastyToast.show();
//
//                        }
//                    });
//					//final HuiYiInFoBean renShu=gson.fromJson(jsonObject,HuiYiInFoBean.class);
//
//
//                }catch (Exception e){
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast tastyToast= TastyToast.makeText(SheZhiActivity.this,"返回数据异常",TastyToast.LENGTH_LONG,TastyToast.ERROR);
//                            tastyToast.setGravity(Gravity.CENTER,0,0);
//                            tastyToast.show();
//
//                        }
//                    });
//                    Log.d("WebsocketPushMsg", e.getMessage()+"ttttt");
//                }
//
//            }
//        });
//    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(String event) {
        Toast tastyToast= TastyToast.makeText(SheZhiActivity.this,event,TastyToast.LENGTH_LONG,TastyToast.INFO);
        tastyToast.setGravity(Gravity.CENTER,0,0);
        tastyToast.show();
    }

}
