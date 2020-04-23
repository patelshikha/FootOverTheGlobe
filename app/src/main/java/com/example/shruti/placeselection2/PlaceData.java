package com.example.shruti.placeselection2;

/**
 * Created by Shruti on 24-11-2017.
 */

public class PlaceData {

    public int imageId;
    public String txt;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    PlaceData(int imageId, String text) {

        this.imageId = imageId;
        this.txt=text;

    }
}
