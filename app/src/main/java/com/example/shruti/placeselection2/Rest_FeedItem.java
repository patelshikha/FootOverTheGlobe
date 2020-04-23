package com.example.shruti.placeselection2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class Rest_FeedItem  implements Parcelable {
    private String date;

    private Rest_Model objRest;

    public Rest_FeedItem(String date, Rest_Model objRest) {
        this.date = date;
        this.objRest = objRest;
    }

    protected Rest_FeedItem(Parcel in) {
        date = in.readString();
        objRest = in.readParcelable(Rest_Model.class.getClassLoader());
    }

    public static final Creator<Rest_FeedItem> CREATOR = new Creator<Rest_FeedItem>() {
        @Override
        public Rest_FeedItem createFromParcel(Parcel in) {
            return new Rest_FeedItem(in);
        }

        @Override
        public Rest_FeedItem[] newArray(int size) {
            return new Rest_FeedItem[size];
        }
    };

    public Rest_Model getObjRest() {
        return objRest;
    }

    public void setObjRest(Rest_Model objRest) {
        this.objRest = objRest;
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
        dest.writeParcelable(objRest, flags);
    }
}
