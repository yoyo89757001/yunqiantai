package megvii.testfacepass.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;
import megvii.testfacepass.MyApplication;
import megvii.testfacepass.R;
import megvii.testfacepass.beans.BaoCunBean;
import megvii.testfacepass.dialog.BangDingDialog;
import megvii.testfacepass.dialog.XiuGaiDiZhiDialog;
import megvii.testfacepass.dialog.YuYingDialog;

public class SheZhiActivity extends Activity {
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.rl2)
    RelativeLayout rl2;

    private Box<BaoCunBean> baoCunBeanDao = null;
    private BaoCunBean baoCunBean = null;


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
            baoCunBeanDao.put(baoCunBean);
        }
        Log.d("SheZhiActivity", "baoCunBean:" + baoCunBean);

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


}
