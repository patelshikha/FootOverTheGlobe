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

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class Rest_CustomAdapter extends RecyclerView.Adapter<Rest_CustomAdapter.MyViewHolder> {
    private List<Rest_Model> List= new ArrayList<>();

    Context context;
    private int addPosition;

    public Rest_CustomAdapter(Context context,List<Rest_Model> List,int position){

        this.List=List;
        this.context=context;
        addPosition=position;

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
    public Rest_CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rest_list_details1, parent, false);



        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final Rest_CustomAdapter.MyViewHolder holder,  int position) {


        holder.title.setText(List.get(position).getTitle());


        holder.imageView.setImageResource(List.get(position).imageId);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("position", addPosition);
                intent.putExtra("restaurant", List.get(holder.getAdapterPosition()));
                ((RestListing) context).setResult(Activity.RESULT_OK, intent);
                ((RestListing) context).finish();



            }
        });
    }


    @Override
    public int getItemCount()
    {
        return List.size();
    }


}



