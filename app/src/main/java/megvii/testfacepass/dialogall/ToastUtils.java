package megvii.testfacepass.dialogall;

/**
 * Created by 于德海 on 2016/9/8.
 *
 * @version ${VERSION}
 * @decpter
 */
public class ToastUtils {

    private static ToastUtils instances;
    private static CommonDialogListener mListener;

    private ToastUtils(){

    }

    public void setListener(CommonDialogListener listener){
        this.mListener = listener;
    }

    public static  ToastUtils getInstances(){
        if (instances == null)
        {
            synchronized (ToastUtils.class)
            {
                if (instances == null)
                {
                    instances = new ToastUtils();
                }
            }
        }
        return instances;
    }


    public void showDialog(String a, String t, int p){
        if(mListener!=null){
            mListener.show(a,t,p);
        }
    }

    public void cancel(){
        if(mListener!=null){
            mListener.cancel();
        }
    }
}
