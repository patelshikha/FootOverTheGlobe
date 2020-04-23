package com.example.shruti.placeselection2;

import android.os.Parcelable;

/**
 * Created by jinal mayavanshi on 22-12-2017.
 */

public class Languages  {

    private int langId;

    private String langName;

    public Languages(int langId, String langName) {
        super();

        this.langId = langId;

        this. langName=  langName;
    }




    public int  getLangId ( )
    {
        return langId;
    }

    public void setLangId (int l)
    {
        langId = l;
    }



    public String getLangname ( )
    {
        return langName;
    }

    public void setLangName (String i)
    {
        langName = i;
    }


}
