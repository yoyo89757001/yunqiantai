package megvii.testfacepass.view;

/**
 * Created by chenjun on 2017/4/5.
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

/**
 * Glide 圆形图片 Transform
 */

public class GlideCircleTransform extends BitmapTransformation {
    private Paint mBorderPaint;
    private float mBorderWidth;

    public GlideCircleTransform(Context context) {
        super(context);
    }

    public GlideCircleTransform(Context context, int borderWidth, int borderColor) {

        mBorderWidth = Resources.getSystem().getDisplayMetrics().density * borderWidth;

        mBorderPaint = new Paint();
    //    mBorderPaint.setDither(true);
        mBorderPaint.setAntiAlias(true);
        mBorderPaint.setColor(borderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);
        mBorderPaint.setStyle(Paint.Style.STROKE);

        Log.d("GlideCircleTransform", "mBorderWidth:" + mBorderWidth);
    }


    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool, toTransform);
    }

    private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        int height2 = source.getHeight();
        int width2 = source.getWidth();
        float scaleWidth =  200f / width2;
        float scaleHeight =  200f / height2;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);// 使用后乘
        Bitmap newBM = Bitmap.createBitmap(source, 0, 0, width2, height2, matrix, false);

        int size = (int) (Math.min(newBM.getWidth(), newBM.getHeight()) - (mBorderWidth / 2));
        int x = (200 - size) / 2;
        int y = (200 - size) / 2;
        // TODO this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(newBM, x, y, size, size);
        Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size / 2f-1;
        canvas.drawCircle(r, r, r, paint);

        if (mBorderPaint != null) {
            float borderRadius = r - mBorderWidth/2f;
            canvas.drawCircle(r, r, borderRadius, mBorderPaint);
            Log.d("GlideCircleTransform", "画圈"+borderRadius);
            Log.d("GlideCircleTransform", "r:" + r);
        }

        canvas.save(Canvas.ALL_SAVE_FLAG);//保存   
        //store   
        canvas.restore();//存储 

        return result;
    }



    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {

    }
}