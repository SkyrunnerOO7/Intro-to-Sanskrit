package com.Language.ApplicationRelease;

public class Word {

    //gives english words
    private String mDefaultTranslation;

    //gives miwok words
    private String mMiwokTranslation;

    //gives image int
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static  final int NO_IMAGE_PROVIDED = -1;

    //gives audio file
    private int mAudioResourceId;



    /*
    * Constructor
    * */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }


    /*
     * takes english, miwok, image and audio file */
    public Word(String defaultTranslation,String miwokTranslation,int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /*
    * get the Default translation of the word*/
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /*
     * get the Miwok translation of the word*/
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /*
     * get the images*/
    public int getmImageResourceId(){return mImageResourceId;}

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    //gets the audio
    public int getmAudioResourceId(){return mAudioResourceId; }

}
