package com.example.shruti.placeselection2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class Guide_Model implements Parcelable {


    private String title;

    int langId;

    int imageId;



    public Guide_Model(String title, int imageId,int langId) {


        this.title = title;

        this. imageId=  imageId;

        this.langId=langId;
    }


    protected Guide_Model(Parcel in) {
        title = in.readString();
        langId = in.readInt();
        imageId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(langId);
        dest.writeInt(imageId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Guide_Model> CREATOR = new Creator<Guide_Model>() {
        @Override
        public Guide_Model createFromParcel(Parcel in) {
            return new Guide_Model(in);
        }

        @Override
        public Guide_Model[] newArray(int size) {
            return new Guide_Model[size];
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

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }
}



