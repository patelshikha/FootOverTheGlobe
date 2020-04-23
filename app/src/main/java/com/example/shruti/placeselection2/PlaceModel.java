package com.example.shruti.placeselection2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shruti on 23-11-2017.
 */


public class PlaceModel implements Parcelable {

    private String name;
    private String description;
    private int image;

    public PlaceModel() {
    }

    protected PlaceModel(Parcel in) {
        name = in.readString();
        description = in.readString();
        image = in.readInt();
    }

    public static final Creator<PlaceModel> CREATOR = new Creator<PlaceModel>() {
        @Override
        public PlaceModel createFromParcel(Parcel in) {
            return new PlaceModel(in);
        }

        @Override
        public PlaceModel[] newArray(int size) {
            return new PlaceModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(image);
    }
}



