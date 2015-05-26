package com.example.administrator.dynamicblockview.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.dynamicblockview.R;

/**
 * Created by Administrator on 15-5-26.
 */
public class DynamicBlockView extends View {
    private Paint paint;
    private static int null_block=1;
    private final static int WIDTH = 30;
    private float center_point_x,center_point_y;
    private ValueAnimator valueAnimator;
    @SuppressLint("ResourceAsColor")
    public DynamicBlockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
     }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(getMeasuredHeight()==0){
            setMeasuredDimension(150,150);
        }
        center_point_x=getMeasuredWidth()/2;
        center_point_y=getMeasuredHeight()/2;
    }
    public void startMove(){
        valueAnimator = ValueAnimator.ofInt(1,9);
        valueAnimator.setDuration(5000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                null_block = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }
    public void stopMove(){
        valueAnimator.cancel();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(int i=1;i<10;i++){
          if(i!=null_block) {
              switch (i) {
                  case 1:
                      canvas.drawRect(center_point_x - WIDTH * 1.5f, center_point_y - WIDTH * 1.5f
                              , center_point_x - WIDTH * 0.5f, center_point_y - WIDTH * 0.5f, paint);
                      break;
                  case 2:
                      canvas.drawRect(center_point_x - WIDTH * 0.4f, center_point_y - WIDTH * 1.5f
                              , center_point_x + WIDTH * 0.6f, center_point_y - WIDTH * 0.5f, paint);
                      break;
                  case 3:
                      canvas.drawRect(center_point_x + WIDTH * 0.7f, center_point_y - WIDTH * 1.5f
                              , center_point_x + WIDTH * 1.7f, center_point_y - WIDTH * 0.5f, paint);
                      break;
                  case 4:
                      canvas.drawRect(center_point_x + WIDTH * 0.7f, center_point_y - WIDTH * 0.4f
                              , center_point_x + WIDTH * 1.7f, center_point_y + WIDTH * 0.6f, paint);
                      break;

                  case 5:
                      canvas.drawRect(center_point_x + WIDTH * 0.7f, center_point_y + WIDTH * 0.7f
                              , center_point_x + WIDTH * 1.7f, center_point_y + WIDTH * 1.7f, paint);
                      break;
                  case 6:
                      canvas.drawRect(center_point_x - WIDTH * 0.4f, center_point_y + WIDTH * 0.7f
                              , center_point_x + WIDTH * 0.6f, center_point_y + WIDTH * 1.7f, paint);
                      break;
                  case 7:
                      canvas.drawRect(center_point_x - WIDTH * 1.5f, center_point_y + WIDTH * 0.7f
                              , center_point_x - WIDTH * 0.5f, center_point_y + WIDTH * 1.7f, paint);
                      break;
                  case 8:
                  canvas.drawRect(center_point_x - WIDTH * 1.5f, center_point_y - WIDTH * 0.4f
                          , center_point_x - WIDTH * 0.5f, center_point_y + WIDTH * 0.6f, paint);
                  break;
                  case 9:
                      canvas.drawRect(center_point_x - WIDTH * 0.4f, center_point_y - WIDTH * 0.4f
                          , center_point_x + WIDTH * 0.6f, center_point_y + WIDTH * 0.6f, paint);
                      break;
              }
          }
        }

    }
}
