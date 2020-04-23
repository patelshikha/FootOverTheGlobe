package com.example.shruti.placeselection2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Hotel_Adapter2 extends RecyclerView.Adapter<Hotel_Adapter2.MyViewHolder> {
  private List<Hotel_Model2> List= new ArrayList<>();

    Context context;
    private int addPosition;

    public Hotel_Adapter2(Context context, List<Hotel_Model2> List, int position){

        this.List=List;
        this.context=context;

        addPosition = position;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageView;


        public MyViewHolder(View view) {
            super(view);

            title= (TextView) view.findViewById(R.id.title);

            imageView = (ImageView) view.findViewById(R.id.imageView);

        }
    }


    @Override
    public Hotel_Adapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_list_details, parent, false);



        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final Hotel_Adapter2.MyViewHolder holder, int position) {


        holder.title.setText(List.get(position).getTitle());


        holder.imageView.setImageResource(List.get(position).imageId);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("position", addPosition);
                intent.putExtra("hotel", List.get(holder.getAdapterPosition()));
                ((HotelActivity2) context).setResult(Activity.RESULT_OK, intent);
                ((HotelActivity2) context).finish();



            }
        });
    }


    @Override
    public int getItemCount()
    {
        return List.size();
    }


}


