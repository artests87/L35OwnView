package com.example.artests.l35ownview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by artests on 26.01.2016.
 */
public class MyWidgetView extends View {
    final int MIN_WIDTH = 300; //107
    final int MIN_HEIGHT = 150;
    final int DEFAULT_COLOR = Color.WHITE;
    final int STROKE_WIDTH = 2;
    private RectF mRectF;
    private Path mPath;

    private int mColor;
    private Paint mPaint;
    public MyWidgetView(Context context) {
        super(context);
        init();
    }

    public MyWidgetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyWidgetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /*public MyWidgetView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(STROKE_WIDTH);
        canvas.drawRect(5, 5, getWidth() - 5, getHeight() - 5, mPaint);
        // Сумасшедший текст
        mPaint.setColor(Color.GRAY); // цвет для текста
        mPaint.setTextSize(20); // размер для текста

        mRectF.set(22, 22, getWidth() - 22, getHeight() - 22);
        mPath.addArc(mRectF, 180, 90);

        // текст вдоль заданного пути
        canvas.drawTextOnPath("Сумасшедший", mPath, 0, 0, mPaint);
        mPath.reset();

        mPath.addArc(mRectF, 0, 120);
        canvas.drawTextOnPath("прямоугольник", mPath, 0, 0, mPaint);
    }

    public void setColor(int color) {
        mColor = color;
    }
    private void init() {
        setMinimumWidth(MIN_WIDTH);
        setMinimumHeight(MIN_HEIGHT);
        mColor = DEFAULT_COLOR;
        mPaint = new Paint();
        mRectF = new RectF();
        mPath = new Path();
    }
}
