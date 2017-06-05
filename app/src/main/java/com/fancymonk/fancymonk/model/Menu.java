package com.fancymonk.fancymonk.model;

import android.os.Parcel;
import android.os.Parcelable;

import static android.R.attr.id;

/**
 * Created by Pavilion on 05-06-2017.
 */

public class Menu implements Parcelable{

    private String mName;
    private String mDescription;
    private Double mPrice;
    private  boolean isSelected;

    public Menu(String name, String description, Double price, boolean isSelected) {
       mName = name;
        mDescription = description;
        mPrice = price;
        this.isSelected = isSelected;
    }

    public Menu(Parcel in){
        mName = in.readString();
        mDescription = in.readString();
        mPrice = in.readDouble();
        isSelected = in.readByte() != 0;     //isSelected == true if byte != 0
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(mName);
        parcel.writeString(mDescription);
        parcel.writeDouble(mPrice);
        parcel.writeByte((byte) (isSelected ? 1 : 0));
    }

    public static final Parcelable.Creator<Menu> CREATOR
            = new Parcelable.Creator<Menu>() {
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
