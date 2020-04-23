package com.example.shruti.placeselection2;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotel_Model1 implements Parcelable{
    private String date;

    private Hotel_Model2 objHotel;

    public Hotel_Model1(String date, Hotel_Model2 objHotel) {
        this.date = date;
        this.objHotel = objHotel;
    }

    protected Hotel_Model1(Parcel in) {
        date = in.readString();
        objHotel = in.readParcelable(Hotel_Model2.class.getClassLoader());
    }

    public static final Creator<Hotel_Model1> CREATOR = new Creator<Hotel_Model1>() {
        @Override
        public Hotel_Model1 createFromParcel(Parcel in) {
            return new Hotel_Model1(in);
        }

        @Override
        public Hotel_Model1[] newArray(int size) {
            return new Hotel_Model1[size];
        }
    };

    public Hotel_Model2 getObjHotel() {
        return objHotel;
    }

    public void setObjHotel(Hotel_Model2 objHotel) {
        this.objHotel = objHotel;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeParcelable(objHotel, flags);
    }
}
