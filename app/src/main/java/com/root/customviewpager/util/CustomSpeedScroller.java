package com.root.customviewpager.util;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

public class CustomSpeedScroller extends Scroller {

    private int mDuration = 5000;
    private static CustomSpeedScroller scroller;

    public void setmDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public CustomSpeedScroller(Context context) {
        super(context);
    }

    public CustomSpeedScroller(ViewPager viewPager, int duration) throws NoSuchFieldException {
        super(viewPager.getContext(), new AccelerateInterpolator());
        setmDuration(duration);
    }

    public static CustomSpeedScroller setScrollSpeed(ViewPager viewPager,int duration) throws NoSuchFieldException, IllegalAccessException {
        scroller = new CustomSpeedScroller(viewPager,duration);
        Field mScroller;
        mScroller = ViewPager.class.getDeclaredField("mScroller");
        mScroller.setAccessible(true);
        mScroller.set(viewPager, scroller);
        return scroller;
    }

    public CustomSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}