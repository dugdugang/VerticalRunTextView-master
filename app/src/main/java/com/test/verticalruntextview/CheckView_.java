package com.test.verticalruntextview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/9/11 0011.
 */

public class CheckView_ extends View {

    private Bitmap bitmap;

    private enum State {
        Start, End, Null
    }

    private int mAllPage = 10;//总帧数
    private int mCurpage = -1;//当前帧
    private Paint mPanit;
    private Handler mHandler;
    private boolean isShow;
    private int mTime = 500;
    private int mWidth;
    private int mHeight;
    private State state = State.Null;

    public CheckView_(Context context) {
        super(context);
        init();
    }

    public CheckView_(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public CheckView_(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        mPanit = new Paint();
        mPanit.setColor(Color.BLUE);
        mPanit.setStyle(Paint.Style.FILL);
        mPanit.setAntiAlias(true);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (mCurpage >= 0 && mCurpage < mAllPage) {
                    invalidate();
                    if (state == State.Null) {
                        return;
                    }
                    if (isShow) {
                        Log.i("M-TAG","mCurpage--");
                        mCurpage--;
                    } else {
                        mCurpage++;
                        Log.i("M-TAG","mCurpage++");

                    }
                    mHandler.sendEmptyMessageDelayed(0, mTime / mAllPage);
                } else {

                    if (isShow) {
                        mCurpage = mAllPage - 1;
                    } else {
                        mCurpage = -1;
                    }
                    invalidate();
                    state = State.Null;
                    Log.i("M-TAG","Null");

                }
            }
        };
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("M-TAG","draw");
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawCircle(0, 0, 250, mPanit);
        int h = bitmap.getHeight();
        Rect f0 = new Rect(h * mCurpage, h, h * (mCurpage + 1), h);
        RectF f1 = new RectF(-250, -250, 250, 250);
        canvas.drawBitmap(bitmap, f0, f1, new Paint());
    }

    public void show() {
        if (isShow || state != State.Null) {
            return;
        }
        Log.i("M-TAG","show");
        state = State.Start;
        mCurpage = 0;
        isShow = true;
        mHandler.sendEmptyMessageDelayed(0, mTime / mAllPage);
    }

    public void hide() {
        if (!isShow || state != State.Null) {
            return;
        }
        state = State.Start;
        mCurpage = mAllPage - 1;
        isShow = false;
        mHandler.sendEmptyMessageDelayed(0, mTime / mAllPage);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
