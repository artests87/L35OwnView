package com.example.artests.l35ownview;

/**
 * Created by artests on 29.01.2016.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ShapeView extends View {

    private int mShapeColor;

    private int mShapeWidth = 100;
    private int mShapeHeight = 100;
    private Paint mPaint;

    private String[] mShapeValuesArray = {"square", "circle"};
    private int mCurrentShapeIndex = 0;

//    public ShapeView(Context context) {
//        super(context);
//        init();
//    }

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupAttributes(attrs);
        init();
    }

//    public ShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }

    private void setupAttributes(AttributeSet attrs) {
        // Obtain a typed array of attributes
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ShapeView, 0, 0);
        // Extract custom attributes into member variables
        try {
            mShapeColor = a.getColor(R.styleable.ShapeView_shapeColor, Color.BLACK);
        } finally {
            // TypedArray objects are shared and must be recycled.
            a.recycle();
        }
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mShapeColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int contentWidth = mShapeWidth;
        int minWidth = contentWidth + getPaddingLeft() + getPaddingRight();
        int width = resolveSizeAndState(minWidth, widthMeasureSpec, 0);
        int minHeight = mShapeHeight + getPaddingBottom() + getPaddingTop();
        int height = resolveSizeAndState(minHeight, heightMeasureSpec, 0);
        setMeasuredDimension(width, height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String shapeSelected = mShapeValuesArray[mCurrentShapeIndex];
        if (shapeSelected.equals("square")) {
            canvas.drawRect(0, 0, mShapeWidth, mShapeHeight, mPaint);
        } else if (shapeSelected.equals("circle")) {
            canvas.drawCircle(mShapeWidth / 2, mShapeHeight / 2, mShapeWidth / 2, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mCurrentShapeIndex++;
            if (mCurrentShapeIndex > (mShapeValuesArray.length - 1)) {
                mCurrentShapeIndex = 0;
            }
            postInvalidate();
            return true;
        }
        return result;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("currentShapeIndex", this.mCurrentShapeIndex);
        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.mCurrentShapeIndex = bundle.getInt("currentShapeIndex");
            state = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(state);
    }


    public int getShapeColor() {
        return mShapeColor;
    }

    public void setShapeColor(int color) {
        this.mShapeColor = color;
        invalidate();
        requestLayout();
    }

    public String getSelectedShape() {
        return mShapeValuesArray[mCurrentShapeIndex];
    }
}
