package com.test.verticalruntextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/8 0008.
 */

public class PieView extends View {
    private int mWidth;//宽
    private int mHeight;//高
    private Paint mPaint;//画笔
    private ArrayList<PieData> pieDatas;
    private float mStartAngle = 0;
    private int colors[] = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.WHITE};

    public PieView(Context context) {
        super(context);
        init();
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //初始化画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setStyle(Paint.Style.FILL);//填充模式
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (pieDatas == null || pieDatas.size() == 0) {
            return;
        }
        canvas.translate(mWidth / 2, mHeight / 2);//画布原点移动到控件中心位置
        float r = (float) (Math.min(mHeight, mWidth) / 2 * 0.8);//半径
        RectF rectF = new RectF(-r, -r, r, r);//矩形
        float curStartAngle = mStartAngle;
        for (PieData data : pieDatas) {
            mPaint.setColor(data.getColor());
            canvas.drawArc(rectF, curStartAngle, data.getAngle(), true, mPaint);
            curStartAngle = curStartAngle + data.getAngle();
        }
    }

    public void setStartAngle(float mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();
    }

    public void setPieDatas(ArrayList<PieData> pieDatas) {
        this.pieDatas = pieDatas;
        initDatas();
        invalidate();
    }

    /**
     * 初始化饼状图数据
     */
    private void initDatas() {
        int allValue = 0;
        for (PieData data : pieDatas) {
            allValue += data.getValue();
        }
        PieData pieData;
        for (int i = 0; i < pieDatas.size(); i++) {
            pieData = pieDatas.get(i);
            pieData.setColor(colors[i % colors.length]);
            pieData.setAngle(pieData.getValue() / allValue * 360);
        }
    }
}
