package com.example.shruti.placeselection2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Hotel_Adapter1 extends RecyclerView.Adapter<Hotel_Adapter1.MyViewHolder> {
    private Context context;
    private List<Hotel_Model1> hotelFeedItems = new ArrayList<>();

    public Hotel_Adapter1(Context context, List<Hotel_Model1> hotelFeedItems) {
        this.context = context;

        this.hotelFeedItems = hotelFeedItems;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvAddPlace;

        public MyViewHolder(View view) {
            super(view);
            tvDate = (TextView) view.findViewById(R.id.tvDate);
            tvAddPlace = (TextView) view.findViewById(R.id.tvAddPlace);
        }
    }


    @Override
    public Hotel_Adapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_layout_abc, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Hotel_Adapter1.MyViewHolder holder, int position) {


        holder.tvDate.setText(hotelFeedItems.get(position).getDate());

        if (hotelFeedItems.get(position).getObjHotel() == null) {
            holder.tvAddPlace.setText("Add Hotel");
        } else {
            holder.tvAddPlace.setText(hotelFeedItems.get(position).getObjHotel().getTitle());
        }

        holder.tvAddPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HotelActivity2.class);
                intent.putExtra("position", holder.getAdapterPosition());

                ((Hotel_Activity1) context).startActivityForResult(intent, 100);
            }
        });



    }


    @Override
    public int getItemCount() {
        return hotelFeedItems.size();
    }


}


