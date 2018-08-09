package com.wya.views.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 创建日期：2018/7/17 16:15
 * 作者： Mao Chunjiang
 * 文件名称：CornerImageView
 * 类说明：圆角ImageView
 */

@SuppressLint("AppCompatCustomView")
public class CornerImageView extends ImageView {
   public CornerImageView(Context context) {
       super(context);
   }

   public CornerImageView(Context context, AttributeSet attrs) {
       super(context, attrs);
   }

   public CornerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
       super(context, attrs, defStyleAttr);

   }

   @TargetApi(Build.VERSION_CODES.LOLLIPOP)
   public CornerImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
       super(context, attrs, defStyleAttr, defStyleRes);
   }

   @Override
   protected void onDraw(Canvas canvas) {
       Drawable drawable = getDrawable();
       if(drawable==null || getWidth()==0 || getHeight()==0) {
           return;
       }
       Bitmap b = ((BitmapDrawable)drawable).getBitmap();
       int size = Math.min(getWidth(), getHeight());
       canvas.drawBitmap(getRoundedBitmap(b, size), 0, 0, null);
   }
   public Bitmap getRoundedBitmap(Bitmap bitmap, int size){

       float perW = (float)size/bitmap.getWidth();
       float perH = (float)size/bitmap.getHeight();
       Matrix matrix = new Matrix();
       matrix.postScale(perW,perH); //长和宽放大缩小的比例
       Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
       Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
       Canvas canvas = new Canvas(output);
       final Paint paint = new Paint();
       paint.setAntiAlias(true);
       paint.setFilterBitmap(true);
       paint.setDither(true);
       final Rect rect = new Rect(0, 0, size, size);
       canvas.drawARGB(0, 0, 0, 0);
       canvas.drawCircle(size/2, size/2, size/2, paint);
       paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      canvas.drawBitmap(resizeBmp, rect, rect, paint);
       return output;
   }
}
