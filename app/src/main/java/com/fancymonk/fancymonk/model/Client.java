package com.fancymonk.fancymonk.model;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

import static java.lang.System.out;


/**
 * Created by Pavilion on 03-06-2017.
 */

public class Client implements Parcelable {

    private String mName;
    private String mLocation;
    private String mImage;
    private String mTagOne;
    private String mTagTwo;

    public Client (String name, String location, String image, String tagOne, String tagTwo){
        mName = name;
        mLocation = location;
        mImage = image;
        mTagOne = tagOne;
        mTagTwo = tagTwo;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmTagOne() {
        return mTagOne;
    }

    public void setmTagOne(String mTagOne) {
        this.mTagOne = mTagOne;
    }

    public String getmTagTwo() {
        return mTagTwo;
    }

    public void setmTagTwo(String mTagTwo) {
        this.mTagTwo = mTagTwo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(mName);
        parcel.writeString(mLocation);
        parcel.writeString(mImage);
        parcel.writeString(mTagOne);
        parcel.writeString(mTagTwo);
    }

    public static final Parcelable.Creator<Client> CREATOR = new Parcelable.Creator<Client>() {
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    private Client(Parcel in) {
        mName = in.readString();
        mLocation = in.readString();
        mImage = in.readString();
        mTagOne = in.readString();
        mTagTwo = in.readString();
    }

}
