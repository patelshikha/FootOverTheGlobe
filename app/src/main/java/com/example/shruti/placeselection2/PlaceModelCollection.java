package com.example.shruti.placeselection2;

import java.util.ArrayList;

/**
 * Created by Shruti on 24-11-2017.
 */

public class PlaceModelCollection {

  public static ArrayList<PlaceModel> getModels()
  {
    ArrayList<PlaceModel> models=new ArrayList<>();
    PlaceModel m=null;

    m =new PlaceModel();
    m.setName("Vadodara");
    m.setDescription("Very bad place");
    m.setImage(R.drawable.vadodara);
    models.add(m);

    m =new PlaceModel();
    m.setName("Surat");
    m.setDescription("Best Place Ever");
    m.setImage(R.drawable.surat);
    models.add(m);


    m =new PlaceModel();
    m.setName("Rajasthan");
    m.setDescription("Historical Place ");
    m.setImage(R.drawable.vadodara);
    models.add(m);


    m =new PlaceModel();
    m.setName("Goa");
    m.setDescription("Place For Fun");
    m.setImage(R.drawable.vadodara);
    models.add(m);


    m =new PlaceModel();
    m.setName("Bombay");
    m.setDescription("Shopping Hub");
    m.setImage(R.drawable.surat);
    models.add(m);


    m =new PlaceModel();
    m.setName("Ahmedabad");
    m.setDescription("xyz");
    m.setImage(R.drawable.vadodara);
    models.add(m);







    return models;

  }
}