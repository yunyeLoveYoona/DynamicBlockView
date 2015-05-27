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
    private static int null_block=15;
    private final static int WIDTH = 15;
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
        valueAnimator = ValueAnimator.ofInt(1,17);
        valueAnimator.setDuration(700);
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
            for (int i = 1; i < 10; i++) {
                if (i !=(null_block/2==0?1:null_block/2)) {
                    switch (i) {
                        case 1:
                            if(null_block==1){
                                canvas.drawRect(center_point_x - WIDTH * 1.5f, center_point_y - WIDTH * 0.75f
                                        , center_point_x - WIDTH * 0.5f, center_point_y + WIDTH * 0.25f, paint);
                            }else{
                                canvas.drawRect(center_point_x - WIDTH * 1.5f, center_point_y - WIDTH * 1.5f
                                        , center_point_x - WIDTH * 0.5f, center_point_y - WIDTH * 0.5f, paint);
                            }
                            break;
                        case 2:
                            if(null_block==3){
                                canvas.drawRect(center_point_x - WIDTH * 0.6f, center_point_y - WIDTH * 1.5f
                                        , center_point_x + WIDTH * 0.4f, center_point_y - WIDTH * 0.5f, paint);
                            }else{
                                canvas.drawRect(center_point_x - WIDTH * 0.4f, center_point_y - WIDTH * 1.5f
                                        , center_point_x + WIDTH * 0.6f, center_point_y - WIDTH * 0.5f, paint);
                            }
                            break;
                        case 3:
                            if(null_block==5){
                                canvas.drawRect(center_point_x + WIDTH * 0.35f, center_point_y - WIDTH * 1.5f
                                        , center_point_x + WIDTH * 1.35f, center_point_y - WIDTH * 0.5f, paint);
                            }else {
                                canvas.drawRect(center_point_x + WIDTH * 0.7f, center_point_y - WIDTH * 1.5f
                                        , center_point_x + WIDTH * 1.7f, center_point_y - WIDTH * 0.5f, paint);
                            }
                            break;
                        case 4:
                            if(null_block==7){
                                canvas.drawRect(center_point_x + WIDTH * 0.7f, center_point_y - WIDTH * 0.6f
                                        , center_point_x + WIDTH * 1.7f, center_point_y + WIDTH * 0.2f, paint);
                            }else{
                                canvas.drawRect(center_point_x + WIDTH * 0.7f, center_point_y - WIDTH * 0.4f
                                        , center_point_x + WIDTH * 1.7f, center_point_y + WIDTH * 0.6f, paint);
                            }
                            break;

                        case 5:
                            if(null_block==9){
                                canvas.drawRect(center_point_x + WIDTH * 0.7f, center_point_y + WIDTH * 0.35f
                                        , center_point_x + WIDTH * 1.7f, center_point_y + WIDTH * 1.35f, paint);
                            }else{
                                canvas.drawRect(center_point_x + WIDTH * 0.7f, center_point_y + WIDTH * 0.7f
                                        , center_point_x + WIDTH * 1.7f, center_point_y + WIDTH * 1.7f, paint);
                            }

                            break;
                        case 6:
                            if(null_block==11){
                                canvas.drawRect(center_point_x - WIDTH * 0.2f, center_point_y + WIDTH * 0.7f
                                        , center_point_x + WIDTH * 0.8f, center_point_y + WIDTH * 1.7f, paint);
                            }else{
                                canvas.drawRect(center_point_x - WIDTH * 0.4f, center_point_y + WIDTH * 0.7f
                                        , center_point_x + WIDTH * 0.6f, center_point_y + WIDTH * 1.7f, paint);
                            }

                            break;
                        case 7:
                            if(null_block==13){
                                canvas.drawRect(center_point_x - WIDTH * 0.75f, center_point_y + WIDTH * 0.7f
                                        , center_point_x +WIDTH * 0.25f, center_point_y + WIDTH * 1.7f, paint);
                            }else{
                                canvas.drawRect(center_point_x - WIDTH * 1.5f, center_point_y + WIDTH * 0.7f
                                        , center_point_x - WIDTH * 0.5f, center_point_y + WIDTH * 1.7f, paint);
                            }
                            break;
                        case 8:
                            if(null_block==15){
                                canvas.drawRect(center_point_x - WIDTH * 1.5f, center_point_y - WIDTH * 0.2f
                                        , center_point_x - WIDTH * 0.5f, center_point_y + WIDTH * 0.8f, paint);
                            }else{
                                canvas.drawRect(center_point_x - WIDTH * 1.5f, center_point_y - WIDTH * 0.4f
                                        , center_point_x - WIDTH * 0.5f, center_point_y + WIDTH * 0.6f, paint);
                            }

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
