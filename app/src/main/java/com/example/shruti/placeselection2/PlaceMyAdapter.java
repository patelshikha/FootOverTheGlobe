package com.example.shruti.placeselection2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Shruti on 23-11-2017.
 */


public class PlaceMyAdapter extends RecyclerView.Adapter<PlaceMyHolder> {

    Context c;
    ArrayList<PlaceModel> models;
    PlaceModel model;

    public PlaceMyAdapter(Context c, ArrayList<PlaceModel> models){
        this.c=c;
        this.models=models;
    }
    @Override
    public PlaceMyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.place_list_detail,parent,false);
        PlaceMyHolder holder=new PlaceMyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final PlaceMyHolder holder, final int position) {

        String name1=models.get(position).getName();
        String dec1=models.get(position).getDescription();
        int img1=models.get(position).getImage();
        //final String title=models.get(position).getTitle();

        holder.name.setText(name1);
        holder.dec.setText(dec1);
        holder.img.setImageResource(img1);

        holder.setItemTouchListener(new ItemTouchListener() {
            @Override
            public void onItemTouch(int pos) {

                model=models.get(pos);

            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.putExtra("position", position);
                intent.putExtra("place", models.get(holder.getAdapterPosition()));
                ((PlaceList) c).setResult(Activity.RESULT_OK, intent);
                ((PlaceList) c).finish();



            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void openMain2Activity()
    {
        Intent i=new Intent(c,Place_page3.class);

        i.putExtra("NAME_KEY",model.getName());
        i.putExtra("DEC_KEY",model.getDescription());

        i.putExtra("IMAGE_KEY",model.getImage());

        c.startActivity(i);


    }
}