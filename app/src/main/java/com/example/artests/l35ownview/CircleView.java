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
public class CircleView extends View {

    final int MIN_WIDTH = 100;
    final int MIN_HEIGHT = 100;
    final int DEFAULT_COLOR = Color.RED;

    private int mColor;
    private Paint mPaint;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setMinimumWidth(MIN_WIDTH);
        setMinimumHeight(MIN_HEIGHT);
        mColor = DEFAULT_COLOR;
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int radius;

        if (width > height) {
            radius = height / 2;
        } else {
            radius = width / 2;
        }

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        mPaint.setColor(mColor);
        canvas.drawCircle(width / 2, height / 2, radius, mPaint);
    }

    public void setColor(int color) {
        mColor = color;
    }
}
