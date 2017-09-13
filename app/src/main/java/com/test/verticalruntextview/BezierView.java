package com.test.verticalruntextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dg on 2017/9/12.
 */

public class BezierView extends View {
    private PointF start, control, end, control1;
    private Paint paint;
    private float centerX, centerY;

    private int flag = 0;//0c1,1c2

    public BezierView(Context context) {
        super(context);
        init();
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w / 2;
        centerY = h / 2;
        start = new PointF();
        start.x = centerX - 200;
        start.y = centerY;
        end = new PointF();
        end.x = centerX + 200;
        end.y = centerY;
        control = new PointF();
        control.x = centerX;
        control.y = centerY - 100;
        control1 = new PointF();
        control1.x = centerX;
        control1.y = centerY - 100;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (flag == 0) {
            control.x = event.getX();
            control.y = event.getY();
        } else if (flag == 1) {
            control1.x = event.getX();
            control1.y = event.getY();
        }

        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(10);
        canvas.drawPoint(start.x, start.y, paint);
        canvas.drawPoint(end.x, end.y, paint);
        canvas.drawPoint(control.x, control.y, paint);
        canvas.drawPoint(control1.x, control1.y, paint);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);

        canvas.drawLines(new float[]{
                start.x, start.y,
                control.x, control.y,
                control.x, control.y,
                control1.x,control1.y,
                control1.x,control1.y,
                end.x, end.y
        }, paint);

        paint.setColor(Color.RED);

        Path path = new Path();
        path.moveTo(start.x, start.y);
        path.cubicTo(control.x, control.y,control1.x,control1.y, end.x, end.y);
        canvas.drawPath(path, paint);

    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
