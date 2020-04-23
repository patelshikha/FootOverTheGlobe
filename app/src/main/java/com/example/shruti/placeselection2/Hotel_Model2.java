package com.example.shruti.placeselection2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shikh on 17-09-2017.
 */

public class Hotel_Model2 implements Parcelable {


    private String title;

      int imageId;



    public Hotel_Model2(String title, int imageId) {
        super();

        this.title = title;

        this. imageId=  imageId;
    }


    protected Hotel_Model2(Parcel in) {
        title = in.readString();
        imageId = in.readInt();
    }

    public static final Creator<Hotel_Model2> CREATOR = new Creator<Hotel_Model2>() {
        @Override
        public Hotel_Model2 createFromParcel(Parcel in) {
            return new Hotel_Model2(in);
        }

        @Override
        public Hotel_Model2[] newArray(int size) {
            return new Hotel_Model2[size];
        }
    };


    public String getTitle ( )
    {
        return title;
    }

    public void setTitle (String t)
    {
        title = t;
    }



    public int getImageId ( )
    {
        return imageId;
    }

    public void setImageId (int i)
    {
        imageId = i;
    }



    @Override
    public String toString() {
        return "Book [  title=" + title + ", author="
                + ",imageID="+imageId+" ]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(imageId);
    }
}
