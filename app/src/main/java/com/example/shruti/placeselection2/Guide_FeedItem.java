package com.example.shruti.placeselection2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class Guide_FeedItem  implements Parcelable {
    private String date;

    private Guide_Model objGuide;

    public Guide_FeedItem(String date, Guide_Model objGuide) {
        this.date = date;
        this.objGuide = objGuide;
    }

    protected Guide_FeedItem(Parcel in) {
        date = in.readString();
        objGuide = in.readParcelable(Guide_Model.class.getClassLoader());
    }

    public static final Creator<Guide_FeedItem> CREATOR = new Creator<Guide_FeedItem>() {
        @Override
        public Guide_FeedItem createFromParcel(Parcel in) {
            return new Guide_FeedItem(in);
        }

        @Override
        public Guide_FeedItem[] newArray(int size) {
            return new Guide_FeedItem[size];
        }
    };

    public Guide_Model getObjGuide() {
        return objGuide;
    }

    public void setObjGuide(Guide_Model objGuide) {
        this.objGuide = objGuide;
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
        dest.writeParcelable(objGuide, flags);
    }
}

