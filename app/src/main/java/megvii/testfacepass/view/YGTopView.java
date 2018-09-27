package megvii.testfacepass.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import megvii.testfacepass.R;

public class YGTopView extends View {
    private int hight=0,width=0;
    private String name=null,bumen=null;
    private Bitmap bitmapTX=null;
    private Paint namePaint=new Paint();
    private Paint yPaint=new Paint();
    private RectF rectF=new RectF();
    private RectF rectF2=new RectF();
    private Bitmap bitmapHG=null;
    private Context context;


    public YGTopView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public YGTopView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }


    public YGTopView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        init();
    }

    public void setHight(int hight,int width){
        this.hight=hight;
        this.width=width;
        float bitmapR=((float) width*0.2f)/2;
        rectF.set(width/2-bitmapR,120,width/2+bitmapR,120+bitmapR*2);
    }
    public void setBitmapTX(Bitmap bitmapTX){
        this.bitmapTX=bitmapTX;
    }

    public void setBitmapHG(){
        bitmapHG= BitmapFactory.decodeResource(context.getResources(), R.drawable.huangguan_tx);
        rectF2.set(width/2-20,30,width/2+190,164);

    }

    private void init(){
        namePaint.setAntiAlias(true);
        namePaint.setColor(Color.WHITE);

        yPaint.setAntiAlias(true);
        yPaint.setColor(Color.WHITE);
        yPaint.setStrokeWidth(2);
        yPaint.setStyle(Paint.Style.STROKE);

    }
    public void setName(String name,String bumen){
        this.name=name;
        if (bumen==null || bumen.equals("")){
            this.bumen="未知部门";
        }else
        this.bumen=bumen;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (bitmapTX!=null){
            canvas.drawBitmap(bitmapTX,null,rectF,null);
            canvas.drawCircle(width/2,120+((float) width*0.2f)/2,((float) width*0.2f)/2,yPaint);
        }
        if (name!=null && rectF.bottom>0){
            namePaint.setTextSize(50);
            float jj=namePaint.measureText(name);
            canvas.drawText(name,width/2-jj/2,rectF.bottom+150,namePaint);
            namePaint.setTextSize(40);
            float kk=namePaint.measureText(bumen);
            canvas.drawText(bumen,width/2-kk/2,rectF.bottom+220,namePaint);
        }
        canvas.save();
        canvas.rotate(1);
        if (bitmapHG!=null){
            canvas.drawBitmap(bitmapHG,null,rectF2,null);
        }

        canvas.restore();


    }



}
