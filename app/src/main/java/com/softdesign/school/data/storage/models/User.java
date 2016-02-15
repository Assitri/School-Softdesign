package com.softdesign.school.data.storage.models;

import android.graphics.drawable.Drawable;

public class User {
    /*  переменные
      mId - id пользователя;
      имя, фамилия, телефон, почта, вк, гит, аватар, рейтинг, дз.
     */

    private int mId;
    private String mFirstName;
    private String mPhoneNumber;
    private String mLastName;
    private Drawable mImage;
    private String mEMail;
    private int mHometask;
    private int mRate;
    private String mVkProfile;
    private String mGitRepo;



    public User(String lastName, String firstName, Drawable image) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mImage = image;
    }

    public Drawable getImage() {return mImage;}

    public String getFirstName() {return mFirstName;}

    public String getLastName() {return mLastName;}


}
