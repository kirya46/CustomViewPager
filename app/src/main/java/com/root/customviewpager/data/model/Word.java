package com.root.customviewpager.data.model;


import java.io.Serializable;

public class Word implements Serializable {

    private String mEnglishWord;

    private String mTranscriptionWord;

    private String mExampleOne;

    private String mExampleTwo;

    public Word() {
    }

    public Word(String mEnglishWord, String mTranscriptionWord, String mExampleOne, String mExampleTwo) {
        this.mEnglishWord = mEnglishWord;
        this.mTranscriptionWord = mTranscriptionWord;
        this.mExampleOne = mExampleOne;
        this.mExampleTwo = mExampleTwo;
    }

    public String getmEnglishWord() {
        return mEnglishWord;
    }

    public void setmEnglishWord(String mEnglishWord) {
        this.mEnglishWord = mEnglishWord;
    }

    public String getmTranscriptionWord() {
        return mTranscriptionWord;
    }

    public void setmTranscriptionWord(String mTranscriptionWord) {
        this.mTranscriptionWord = mTranscriptionWord;
    }

    public String getmExampleOne() {
        return mExampleOne;
    }

    public void setmExampleOne(String mExampleOne) {
        this.mExampleOne = mExampleOne;
    }

    public String getmExampleTwo() {
        return mExampleTwo;
    }

    public void setmExampleTwo(String mExampleTwo) {
        this.mExampleTwo = mExampleTwo;
    }
}
