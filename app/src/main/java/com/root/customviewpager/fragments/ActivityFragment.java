package com.root.customviewpager.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.root.customviewpager.R;
import com.root.customviewpager.data.model.Word;


public class ActivityFragment extends Fragment {
    private static final String TAG = "ActivityFragment";

    public static final String ARG_PAGE = "page";
    public static final String ARG_WORD = "word";

    private int mPageNumber;

    Word word;
    private TextView tvStatus;

    public static ActivityFragment create(int pageNumber, Word word) {
        ActivityFragment fragment = new ActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putSerializable(ARG_WORD, word);
        fragment.setArguments(args);
        return fragment;
    }

    public ActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
        word = (Word) getArguments().getSerializable(ARG_WORD);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.activity_learn_fragment, container, false);

        ((TextView) rootView.findViewById(R.id.mainWord)).setText(word.getmEnglishWord()); //TODO TESTING ATOFITTEXT
//        ((AutofitTextView) rootView.findViewById(R.id.mainWord)).setText(word.getmEnglishWord());
        ((TextView) rootView.findViewById(R.id.translateWord)).setText(word.getmTranscriptionWord()); //TODO TESTING ATOFITTEXT
//        ((AutofitTextView) rootView.findViewById(R.id.translateWord)).setText(word.getmTranscriptionWord());
        ((TextView) rootView.findViewById(R.id.textViewExample1)).setText(linkWord(word.getmEnglishWord(),word.getmExampleOne()));
        ((TextView) rootView.findViewById(R.id.textViewExample2)).setText(linkWord(word.getmEnglishWord(), word.getmExampleTwo()));


        return rootView;
    }



    private SpannableString linkWord(String searchWord, String fullString){
        SpannableString ss =  new SpannableString(fullString);

        int start = (fullString.toLowerCase()).indexOf(searchWord.toLowerCase());
        Log.d(TAG, "Start position: " +start + "search word: " + searchWord );
        int finish = start + searchWord.length();

        if (start == -1){
            return SpannableString.valueOf(fullString);
        }

        ss.setSpan(new ForegroundColorSpan(Color.parseColor("#287DD6")), start, finish, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        return ss;
    }




    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
