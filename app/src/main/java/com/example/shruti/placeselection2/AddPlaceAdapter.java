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
 * Created by Shruti on 28-11-2017.
 */

public class AddPlaceAdapter extends RecyclerView.Adapter<AddPlaceAdapter.MyViewHolder> {
    private Context context;
    private List<AddPlaceModel> placeModel = new ArrayList<>();

    public AddPlaceAdapter(Context context,List<AddPlaceModel> placeModel) {
        this.context = context;

        this.placeModel = placeModel;

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
    public AddPlaceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.addplacelist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AddPlaceAdapter.MyViewHolder holder, int position) {


        holder.tvDate.setText(placeModel.get(position).getDate());

        if (placeModel.get(position).getObjPlace() == null) {
            holder.tvAddPlace.setText("Add Place");
        } else {
            holder.tvAddPlace.setText(placeModel.get(position).getObjPlace().getName());
        }

        holder.tvAddPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlaceList.class);
                intent.putExtra("position", holder.getAdapterPosition());

                ((PlaceSelectionMain) context).startActivityForResult(intent, 100);
            }
        });
    }


    @Override
    public int getItemCount() {
        return placeModel.size();
    }


}
