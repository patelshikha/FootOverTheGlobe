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

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class Rest_Adapter extends RecyclerView.Adapter<Rest_Adapter.MyViewHolder> {
    private Context context;
    private List<Rest_FeedItem> restFeedItems = new ArrayList<>();

    public Rest_Adapter(Context context, List<Rest_FeedItem> restFeedItems) {
        this.context = context;

        this.restFeedItems = restFeedItems;

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
    public Rest_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rest_layout_abc, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Rest_Adapter.MyViewHolder holder, int position) {


        holder.tvDate.setText(restFeedItems.get(position).getDate());

        if (restFeedItems.get(position).getObjRest() == null) {
            holder.tvAddPlace.setText("Add Restaurant");
        } else {
            holder.tvAddPlace.setText(restFeedItems.get(position).getObjRest().getTitle());
        }

        holder.tvAddPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RestListing.class);
                intent.putExtra("position", holder.getAdapterPosition());

                ((Rest_MainActivity) context).startActivityForResult(intent, 100);
            }
        });


       }


    @Override
    public int getItemCount() {
        return restFeedItems.size();
    }


}



