package com.example.artests.l35ownview;

/**
 * Created by artests on 29.01.2016.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TouchCircle extends View {

    final int STROKE_WIDTH = 3;
    final int DEFAULT_COLOR = Color.RED;

    private float mInitX, mInitY, mRadius;
    private boolean mIsDrawing = false;
    private int mColor;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TouchCircle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TouchCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TouchCircle(Context context) {
        super(context);
        init();
    }

    private void init() {
        mColor = DEFAULT_COLOR;
        // выберите один из двух вариантов
        mPaint.setStyle(Paint.Style.STROKE); // обводка круга - окружность
        //mPaint.setStyle(Paint.Style.FILL); // или залить круг цветом
        mPaint.setStrokeWidth(STROKE_WIDTH);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),
                MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mIsDrawing) {
            canvas.drawCircle(mInitX, mInitY, mRadius, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_MOVE) {
            float x = event.getX();
            float y = event.getY();

            mRadius = (float) Math.sqrt(Math.pow(x - mInitX, 2)
                    + Math.pow(y - mInitY, 2));

        } else if (action == MotionEvent.ACTION_DOWN) {
            mInitX = event.getX();
            mInitY = event.getY();
            mRadius = 1;
            mIsDrawing = true;
        } else if (action == MotionEvent.ACTION_UP) {
            mIsDrawing = false;
        }
        invalidate();
        return true;
    }
}
