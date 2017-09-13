package com.test.verticalruntextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/12 0012.
 */

public class SpiderView extends View {

    private int mWidth;//控件宽
    private int mHeight;//控件高
    private int mCount = 5;//阶数
    private float mAngle;//角度
    private float mLength;//长度
    private float mStepLength;//阶度长度
    private int[] datas = {4, 6, 8, 10, 4, 7};
    private String[] names = {"A", "B", "C", "D", "E", "F"};
    private int mMax = 10;//每个维度最大值
    private Paint mShapePaint;//线条画笔
    private Paint mTextPaint;//文字画笔
    private Paint mRegionPaint;//区域画笔
    private Paint mPointPaint;

    public SpiderView(Context context) {
        super(context);
        init();
    }

    public SpiderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpiderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mShapePaint = new Paint();
        mShapePaint.setColor(Color.BLACK);
        mShapePaint.setAntiAlias(true);
        mShapePaint.setStrokeWidth(1);
        mShapePaint.setStyle(Paint.Style.STROKE);

        mPointPaint = new Paint();
        mPointPaint.setColor(Color.RED);
        mPointPaint.setAntiAlias(true);
        mPointPaint.setStrokeWidth(8);
        mPointPaint.setStyle(Paint.Style.FILL);

        mRegionPaint = new Paint();
        mRegionPaint.setColor(Color.parseColor("#66A4D3EE"));
        mRegionPaint.setAntiAlias(true);
        mRegionPaint.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.BLUE);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextSize(15);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mWidth = w;
        this.mHeight = h;
        mLength = (int) (Math.min(w, h) * 0.5) / 2;
        mStepLength = mLength / mCount;
        mAngle = (float) (Math.PI * 2 / mCount + 1);

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);//移动画布到中心
        drawHexagons(canvas);
        drawLines(canvas);
        drawRegion(canvas);
        drawTexts(canvas);
        super.onDraw(canvas);
    }

    //绘制六边形
    private void drawHexagons(Canvas canvas) {
        // canvas.restoreToCount(1);
        Path path = new Path();
        for (int i = 1; i <= 5; i++) {
            path.reset();
            for (int j = 0; j <= 5; j++) {
                float x = (float) (Math.cos(Math.PI * 2 / 6 * j) * mStepLength * i);
                float y = (float) (Math.sin(Math.PI * 2 / 6 * j) * mStepLength * i);
                if (j == 0) {
                    path.moveTo(x, y);
                }
                if (i == 1) {
                }
                path.lineTo(x, y);
            }
            path.close();
            canvas.drawPath(path, mShapePaint);
        }

    }

    /**
     * 画线
     *
     * @param canvas
     */
    private void drawLines(Canvas canvas) {
        float[] posints = new float[6];
        ArrayList<float[]> ponits = new ArrayList<>();
        for (int j = 0; j <= 5; j++) {
            float x = (float) (Math.cos(Math.PI * 2 / 6 * j) * mLength);
            float y = (float) (Math.sin(Math.PI * 2 / 6 * j) * mLength);
            ponits.add(new float[]{x, y});
        }
        for (int i = 0; i < 3; i++) {
            canvas.drawLine(ponits.get(i)[0], ponits.get(i)[1], ponits.get(i + 3)[0], ponits.get(i + 3)[1], mShapePaint);
        }
    }

    private void drawRegion(Canvas canvas) {
        float[] posints = new float[6];
        ArrayList<float[]> ponits = new ArrayList<>();
        Path path = new Path();
        for (int i = 0; i <= 5; i++) {
            float x = (float) (Math.cos(Math.PI * 2 / 6 * i) * mLength / mMax * datas[i]);
            float y = (float) (Math.sin(Math.PI * 2 / 6 * i) * mLength / mMax * datas[i]);
            ponits.add(new float[]{x, y});
            canvas.drawCircle(x, y, 5, mPointPaint);
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }
        path.close();
        canvas.drawPath(path, mRegionPaint);
    }

    private void drawTexts(Canvas canvas) {
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float height = fontMetrics.descent - fontMetrics.ascent;
        Log.i("M-TAG", "" + height);
        for (int i = 0; i <= 5; i++) {
            float x = (float) ((mLength + height / 2) * Math.cos(Math.PI * 2 / 6 * i));
            float y = (float) ((mLength + height / 2) * Math.sin(Math.PI * 2 / 6 * i));
            if (Math.PI * 2 / 6 * i <= Math.PI / 2) {//第一象限
                canvas.drawText(names[i], x, y, mTextPaint);
            } else if (Math.PI * 2 / 6 * i > Math.PI / 2 && Math.PI * 2 / 6 * i <= Math.PI) {//第二象限
                float w = mTextPaint.measureText(names[i]);
                canvas.drawText(names[i], x - w, y, mTextPaint);
            } else if (Math.PI * 2 / 6 * i > Math.PI && Math.PI * 2 / 6 * i <= Math.PI * 3 / 2) {
                float w = mTextPaint.measureText(names[i]);
                canvas.drawText(names[i], x - w, y, mTextPaint);
            } else {
                canvas.drawText(names[i], x, y, mTextPaint);
            }


        }
    }
}
