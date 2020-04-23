package com.example.shruti.placeselection2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class Rest_Model implements Parcelable {


    private String title;

    int imageId;



    public Rest_Model(String title, int imageId) {
        super();

        this.title = title;

        this. imageId=  imageId;
    }


    protected Rest_Model(Parcel in) {
        title = in.readString();
        imageId = in.readInt();
    }

    public static final Creator<Rest_Model> CREATOR = new Creator<Rest_Model>() {
        @Override
        public Rest_Model createFromParcel(Parcel in) {
            return new Rest_Model(in);
        }

        @Override
        public Rest_Model[] newArray(int size) {
            return new Rest_Model[size];
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


