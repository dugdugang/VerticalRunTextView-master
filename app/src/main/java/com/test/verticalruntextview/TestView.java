package com.test.verticalruntextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class TestView extends View {

    private Paint mPaint;//画笔
    private int mWidth;
    private int mHeight;

    public TestView(Context context) {
        super(context);
        init();
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);//设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//填充模式
        mPaint.setStrokeWidth(2f);//设置画笔宽带位10px
        mPaint.setAntiAlias(true);//抗锯齿
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // setMeasuredDimension();
//        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
//        int widthmode=MeasureSpec.getMode(widthMeasureSpec);
//        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
//        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //  canvas.drawColor(Color.BLUE);//背景色
//        canvas.drawPoint(200, 200, mPaint);//点
//        canvas.drawPoints(new float[]{500f, 500f, 500f, 600f, 500f, 700f}, mPaint);//多点
//        canvas.drawLine(300, 200, 600, 200, mPaint);//线
//        canvas.drawLines(new float[]{//多线
//                200, 300, 400, 300,
//                200, 400, 400, 400
//
//        }, mPaint);
        //矩形
//        canvas.drawRect(0, 0, 350, 350, mPaint);
//        Rect rect = new Rect(400, 400, 500, 500);//精度int
//        canvas.drawRect(rect, mPaint);
//        canvas.drawRect(new RectF(0, 600, 300, 800), mPaint);//精度float
        //圆角矩形
//        RectF rectF = new RectF(0, 0, 400, 400);
//        canvas.drawRoundRect(rectF, 30, 30, mPaint);
//        canvas.drawRoundRect(0f,500f,500f,800f,20f,20f,mPaint);
        //椭圆
//        RectF rectF=new RectF(200,200,500,500);
//        canvas.drawOval(rectF,mPaint);
//        canvas.drawOval(0,600,200,800,mPaint);
        //圆
//        canvas.drawCircle(500,500,100,mPaint);
//        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG
//                | Paint.FILTER_BITMAP_FLAG)); //设置图形、图片的抗锯齿。可用于线条等。按位或.
        //圆弧
//        RectF f = new RectF(200, 200, 500, 500);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(f, mPaint);
//        mPaint.setColor(Color.RED);
//        canvas.drawArc(f, 0, 90, false, mPaint);
//        RectF f1 = new RectF(200, 600, 400, 800);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(f1, mPaint);
//        mPaint.setColor(Color.RED);
//        canvas.drawArc(f1, 0, 90, true, mPaint);
        //描边与填充
//        Paint paint = new Paint();
//        paint.setColor(Color.BLACK);
//        paint.setStrokeWidth(30);
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);//描边
//        canvas.drawCircle(200, 200, 100, paint);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(400, 400, 100, paint);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawCircle(200, 500, 100, paint);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.BLACK);
//        paint.setStrokeWidth(5);
//        canvas.translate(200, 200);
//        canvas.drawCircle(0, 0, 100, paint);
//        canvas.translate(200, 200);
//        paint.setColor(Color.RED);
//        canvas.drawCircle(0, 0, 100, paint);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.RED);
//        canvas.drawLines(new float[]{
//                0f, -mHeight / 2, 0f, mHeight / 2,
//                -mWidth / 2, 0f, mWidth / 2, 0f
//        }, mPaint);
//        RectF rectF = new RectF(0, 0, 300, 300);
//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        RectF f = new RectF(0, -300, 300, 0);
//        canvas.drawRect(f, paint);
//        canvas.scale(-0.5f, -0.5f,50,0);
//        paint.setColor(Color.GREEN);
//        canvas.drawRect(f, paint);
//        RectF rectF = new RectF(-300, -300, 300, 300);
//        canvas.drawRect(rectF, paint);
//        for (int i = 0; i < 20; i++) {
//            canvas.scale(0.9f,0.9f);
//            canvas.drawRect(rectF,paint);
//        }
//        canvas.translate(mWidth / 2, mHeight / 2);
//        RectF f = new RectF(0, -300, 300, 0);
//        canvas.drawRect(f, paint);
//        canvas.rotate(180);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(f, paint);
//        canvas.drawCircle(0,0,300,paint);
//        canvas.drawCircle(0,0,280,paint);
//        for (int i=0;i<=360;i+=10){
//            canvas.drawLine(0,-300,0,-280,paint);
//            canvas.rotate(10);
//        }
//        canvas.drawRect(new RectF(0,0,200,200),paint);
//        canvas.skew(1,0);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(new RectF(0,0,200,200),paint);
//        Picture picture = new Picture();
//        Canvas c = picture.beginRecording(500, 500);
//        c.translate(250, 250);
//        paint.setStyle(Paint.Style.FILL);
//        c.drawCircle(0, 0, 100, paint);
//        picture.endRecording();
////        picture.draw(canvas);
////        canvas.drawPicture(picture,new RectF(0,0,200,200));
//        PictureDrawable pictureDrawable=new PictureDrawable(picture);
//        pictureDrawable.setBounds(0,0,250,picture.getHeight());
//        pictureDrawable.draw(canvas);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
//        float rato = ((float) bitmap.getWidth()) / bitmap.getHeight();
//        Rect str = new Rect(0, 0, bitmap.getWidth()/2, bitmap.getHeight()/2);
//        RectF des = new RectF(0, 0, mWidth, mWidth/rato);
//        canvas.drawBitmap(bitmap, str, des, null);
//        Paint textPaint = new Paint();
//        textPaint.setAntiAlias(true);
//        textPaint.setColor(Color.BLACK);
//        textPaint.setTextSize(50);
//        textPaint.setStyle(Paint.Style.FILL);
//        String s = "ABCD";
//        char[] chars="ABCDEF".toCharArray();
//        canvas.drawText(chars, 2, 3, 200, 200, textPaint);
//        canvas.drawPosText(s,new float[]{
//                100,100,
//                200,200,
//                300,300,
//                400,400
//        },textPaint);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.scale(1,-1);
        Path path = new Path();
        path.lineTo(100,100);
        RectF f=new RectF(0,0,200,200);
        //path.addArc(f,0,180);
        path.arcTo(f,0,180,false);
        canvas.drawPath(path,paint);
        super.onDraw(canvas);
    }


}
