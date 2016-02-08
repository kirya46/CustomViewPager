package com.root.customviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.root.customviewpager.data.MockData;
import com.root.customviewpager.data.model.Word;
import com.root.customviewpager.fragments.MainActivityFragment;
import com.root.customviewpager.util.CustomSpeedScroller;
import com.root.customviewpager.util.CustomViewPagerH;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int NUM_PAGES;
    private static final String TAG = "CHECK ACTIVITY";

    private int mWordCounter = 1;

    private TextView mTextViewStatus;
    private Button mButtonNext;
    private LinearLayout mDoubleButtonConteiner;

    private PagerAdapter mPagerAdapter;

    private CustomViewPagerH mPager;  // Horizontal scroll, make change in xml  file
//    private CustomViewPagerV mPager;  // Vertical scroll, make change in xml  file

    MainActivityFragment learnActivityFragment;

    ArrayList<Word> mWordList;

    private View.OnClickListener mButtonChekListener, mButtonChekOkListener, mButtonChekNoListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_learn);

        mWordList = (ArrayList<Word>) new MockData().getStartWords();
        NUM_PAGES = mWordList.size();

        mButtonNext = (Button) findViewById(R.id.btnNext);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                mWordCounter++;
                mTextViewStatus.setText(mWordCounter + " из " + (mWordList.size()));

            }
        });

        mPager = (CustomViewPagerH) findViewById(R.id.pager);
//        mPager = (CustomViewPagerV) findViewById(R.id.pager);


        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());


        mPager.setAdapter(mPagerAdapter);
        mPager.setPagingEnabled(true); //disable touch scroll

        /** Set scroller duration */
        // do 2/3/2016 extract to scroller class  ( in CustomViewPagerV  in postInitViewPager() method fix from Scroller custom duration to FixedSpeedScroller

//        try {
//            Field mScroller;
//            mScroller = ViewPager.class.getDeclaredField("mScroller");
//            mScroller.setAccessible(true);
//            Interpolator sInterpolator = new AccelerateInterpolator();
//            FixedSpeedScroller scroller = new FixedSpeedScroller(mPager.getContext(), sInterpolator);
//            scroller.setmDuration(500);
//            mScroller.set(mPager, scroller);
//        } catch (NoSuchFieldException e) {
//        } catch (IllegalArgumentException e) {
//        } catch (IllegalAccessException e) {
//        }


        try {
            CustomSpeedScroller.setScrollSpeed(mPager, 500);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


//        mPager.setScrollDurationFactor(5); /** set duration slow */


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_learn, menu);
        mTextViewStatus = new TextView(this);
        mTextViewStatus.setText(mWordCounter + " из " + (mWordList.size()));
        mTextViewStatus.setPadding(0, 0, 16, 0);

        //set text size and color for status TextView
        mTextViewStatus.setTextAppearance(this, R.style.ActionTextStyle);


        for (int i = 0; i < menu.size(); i++) {
            menu.removeItem(menu.getItem(i).getItemId());
        }

        menu.add(0, R.id.statusTextview, 1, " ").setActionView(mTextViewStatus).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    /**
     * ScreenSlidePagerAdapter
     */

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d(TAG, "Position: " + position);
            learnActivityFragment = MainActivityFragment.create(position, mWordList.get(position));
            return learnActivityFragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

    }
}
