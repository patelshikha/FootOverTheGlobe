package com.example.shruti.placeselection2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shruti on 28-11-2017.
 */

public class AddPlaceModel implements Parcelable{

    private String date;

    private PlaceModel objPlace;

    public AddPlaceModel(String date, PlaceModel objPlace) {
        this.date = date;
        this.objPlace = objPlace;
    }

    protected AddPlaceModel(Parcel in) {
        date = in.readString();
        objPlace = in.readParcelable(PlaceModel.class.getClassLoader());
    }

    public static final Creator<AddPlaceModel> CREATOR = new Creator<AddPlaceModel>() {
        @Override
        public AddPlaceModel createFromParcel(Parcel in) {
            return new AddPlaceModel(in);
        }

        @Override
        public AddPlaceModel[] newArray(int size) {
            return new AddPlaceModel[size];
        }
    };

    public PlaceModel getObjPlace() {
        return objPlace;
    }

    public void setObjPlace(PlaceModel objHotel) {
        this.objPlace = objHotel;
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
        dest.writeParcelable(objPlace, flags);
    }

}
