package com.example.shruti.placeselection2;

/**
 * Created by admin on 11/20/2017.
 */

public class CAR {
    private String title,description,capacity,AirConditional;
    int imageId;





    public CAR(String title, String capacity,int imageId,String description,String AirConditional ) {
        super();

        this.title = title;
        this.description=description;
        this. imageId=  imageId;
        this.capacity=capacity;
        this.AirConditional=AirConditional;
        // this.frwf=frwf;





    }


    public String getTitle ( )
    {
        return title;
    }

    public void setTitle (String t)
    {
        title = t;
    }


    public String getDescription ( )
    {
        return description;
    }

    public void setDescription (String l) {description = l;}


    public int getImageId ( )
    {
        return imageId;
    }

    public void setImageId (int i)
    {
        imageId = i;
    }


    public String getCapacity ( )
    {
        return capacity;
    }

    public void setCapacity (String k) {capacity = k;}
    public String getAirConditional(){return AirConditional;}
    public void setAirConditional(String a){AirConditional=a;}
    //public String getfrwf( ) {return frwf;}
    //public void setFrwf (String v) {frwf=v;}






    @Override
    public String toString() {
        return "Book [  title=" + title + ", author="
                + ",imageID="+imageId+",capacity="+",Description="+",AirConditional]";
    }

}
