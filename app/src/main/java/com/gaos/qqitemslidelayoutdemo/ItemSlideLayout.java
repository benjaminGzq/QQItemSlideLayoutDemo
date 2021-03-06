package com.gaos.qqitemslidelayoutdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Author:　Created by benjamin
 * DATE :  2017/10/20 16:09
 * versionCode:　v2.2
 */

public class ItemSlideLayout extends FrameLayout {
    private static final String TAG = "ItemSlideLayout";
    private View mContent;
    private View mDelete;
    private int mDeleteWidth;
    private View mLeft;

    public ItemSlideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) {
            throw new RuntimeException("至少要有2个child view, 当前只有" + getChildCount() + "个");
        }
        mLeft = getChildAt(0);
        mContent = getChildAt(1);
        mDelete = getChildAt(2);
        mContent.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//                Log.d(TAG, "onLayoutChange: left = " + left);
//                Log.d(TAG, "onLayoutChange: left = " + left);
//                Log.d(TAG, "onLayoutChange: top = " + top);
//                Log.d(TAG, "onLayoutChange: right = " + right);
//                Log.d(TAG, "onLayoutChange: bottom = " + bottom);

            }
        });


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        Log.d(TAG, "onSizeChanged: ");
//        addOnLayoutChangeListener(new OnLayoutChangeListener() {
//            @Override
//            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//                mContent.layout(left, top, right, bottom);
//                mDelete.layout(right, top, right + mDelete.getMeasuredWidth(), bottom);
//                Log.d(TAG, "onLayoutChange: left = " + left);
//                Log.d(TAG, "onLayoutChange: top = " + top);
//                Log.d(TAG, "onLayoutChange: right = " + right);
//                Log.d(TAG, "onLayoutChange: bottom = " + bottom);
//            }
//        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        Log.d(TAG, "onMeasure: widthMeasureSpec = " + MeasureSpec.getSize(widthMeasureSpec));
//        Log.d(TAG, "onMeasure: heightMeasureSpec = " + MeasureSpec.getSize(heightMeasureSpec));
//        Log.d(TAG, "onMeasure: widthMeasureSpec = " + MeasureSpec.getMode(widthMeasureSpec));
//        Log.d(TAG, "onMeasure: heightMeasureSpec = " + MeasureSpec.getMode(heightMeasureSpec));
//
//        mContent.measure(widthMeasureSpec, MeasureSpec.UNSPECIFIED);
//        int mContentMeasuredHeight = mContent.getMeasuredHeight();
//        Log.d(TAG, "onMeasure: mContentMeasuredHeight = " + mContentMeasuredHeight);
//        LayoutParams mDeleteLayoutParams = (LayoutParams) mDelete.getLayoutParams();
//        mDeleteWidth = MeasureSpec.makeMeasureSpec(mDeleteLayoutParams.width, MeasureSpec.EXACTLY);
//        int mDeleteHeight = MeasureSpec.makeMeasureSpec(mDeleteLayoutParams.height, MeasureSpec.EXACTLY);
//        mDelete.measure(mDeleteWidth, mDeleteHeight);
//        setMeasuredDimension(widthMeasureSpec, mContentMeasuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mLeft.layout(-mLeft.getMeasuredWidth(), t, 0, b);
        mContent.layout(l, t, r, b);
        mDelete.layout(r, t, r + mDelete.getMeasuredWidth(), b);
//        invalidate();
//        Log.d(TAG, "onLayout: l = " + l);
//        Log.d(TAG, "onLayout: t = " + t);
//        Log.d(TAG, "onLayout: r = " + r);
//        Log.d(TAG, "onLayout: b = " + b);
//        mLeft.layout(l, t, mLeft.getMeasuredWidth(), b);
//        mContent.layout(l + mLeft.getMeasuredWidth(), t, l + mLeft.getMeasuredWidth() + mContent.getMeasuredWidth(), b);
//        mDelete.layout(l + mLeft.getMeasuredWidth() + mContent.getMeasuredWidth(), t, l + mLeft.getMeasuredWidth() + mContent.getMeasuredWidth() + mDelete.getMeasuredWidth(), b);
    }

    // SlideDlete的接口
    public interface OnSlideItemListener {
        void onOpen(ItemSlideLayout slideDelete);

        void onClose(ItemSlideLayout slideDelete);
    }

    private OnSlideItemListener onSlideItemListener;

    public void setOnSlideItemListener(OnSlideItemListener onSlideItemListener) {
        this.onSlideItemListener = onSlideItemListener;
    }
}
