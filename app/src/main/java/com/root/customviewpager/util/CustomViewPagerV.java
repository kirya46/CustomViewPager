package com.root.customviewpager.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;

import java.lang.reflect.Field;


public class CustomViewPagerV extends ViewPager {

    private boolean isPagingEnabled = true; //enable/disable touch scroll in ViewPager

    public CustomViewPagerV(Context context) {
        super(context);
        init(); // initialize vertical scrolling
        postInitViewPager();
    }

    public CustomViewPagerV(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(); // initialize vertical scrolling
        postInitViewPager();
    }


    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }


    /**
     * CHANGE DEFAULT DURATION IN SCROLL
     *
     * Override the Scroller instance with our own class so we can change the
     * duration
     */

    private ScrollerCustomDuration mScroller = null;

    private void postInitViewPager() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            Field interpolator = viewpager.getDeclaredField("sInterpolator");
            interpolator.setAccessible(true);

            mScroller = new ScrollerCustomDuration(getContext(),
                    (Interpolator) interpolator.get(null));
            scroller.set(this, mScroller);
        } catch (Exception e) {
        }
    }

    /**
     * Set the factor by which the duration will change
     */
    public void setScrollDurationFactor(double scrollFactor) {
        mScroller.setScrollDurationFactor(scrollFactor);
    }



    /**
     * VERTICAL SCROLLING CASE
     */
    private void init() {
        // The majority of the magic happens here
        setPageTransformer(true, new VerticalPageTransformer());
        // The easiest way to get rid of the overscroll drawing that happens on the left and right
        setOverScrollMode(OVER_SCROLL_NEVER);

    }

    /**
     * Swaps the X and Y coordinates of your touch event.
     */
    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);

        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev){
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev); // return touch coordinates to original reference frame for any child views
        return this.isPagingEnabled && intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.isPagingEnabled && super.onTouchEvent(swapXY(ev));
    }


    private class VerticalPageTransformer implements ViewPager.PageTransformer {


        @Override
        public void transformPage(View view, float position) {

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                view.setAlpha(1);

                // Counteract the default slide transition
                view.setTranslationX(view.getWidth() * -position);

                //set Y position to swipe in from top
                float yPosition = -(position * view.getHeight()); /** -(position * view.getHeight()); swap  from  top  to bottom */
                view.setTranslationY(yPosition);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}



