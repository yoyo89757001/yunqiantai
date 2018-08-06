package megvii.testfacepass.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import megvii.testfacepass.R;


/**
 * @Function: 自定义对话框
 * @Date: 2013-10-28
 * @Time: 下午12:37:43
 * @author Tom.Cai
 */
public class XiuGaiGaoKuanDialog extends Dialog {
    private TextView title2;
    private Button l1,l2;
    private EditText jiudianname,idid;
    public XiuGaiGaoKuanDialog(Context context) {
        super(context, R.style.dialog_style2);
        setCustomDialog();
    }

    private void setCustomDialog() {
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.xiugaidialog3, null);

        jiudianname= (EditText) mView.findViewById(R.id.xiangce);
        idid= (EditText)mView.findViewById(R.id.idid);
        title2= (TextView) mView.findViewById(R.id.title2);
        l1= (Button)mView. findViewById(R.id.queren);
        l2= (Button) mView.findViewById(R.id.quxiao);

        super.setContentView(mView);
    }

    public void setContents(String title,String kuan, String gao){
        if (title2!=null)
        title2.setText(title);
       if (gao!=null)
           idid.setText(gao);
        if (kuan!=null)
            jiudianname.setText(kuan);

    }

    public String getGao(){
        return jiudianname.getText().toString().trim();
    }

    public String getKuan(){
        return idid.getText().toString().trim();
    }


    @Override
    public void setContentView(int layoutResID) {
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
    }

    @Override
    public void setContentView(View view) {
    }

    /**
     * 确定键监听器
     * @param listener
     */
    public void setOnQueRenListener(View.OnClickListener listener){
        l1.setOnClickListener(listener);
    }
    /**
     * 取消键监听器
     * @param listener
     */
    public void setQuXiaoListener(View.OnClickListener listener){
        l2.setOnClickListener(listener);
    }


}
