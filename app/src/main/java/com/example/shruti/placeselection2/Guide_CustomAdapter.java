package com.example.shruti.placeselection2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class Guide_CustomAdapter extends RecyclerView.Adapter<Guide_CustomAdapter.MyViewHolder> {
    private java.util.List<Guide_Model> List= new ArrayList<>();

    Context context;
    private int addPosition;
    Spinner spinner;

    public Guide_CustomAdapter(Context context, java.util.List<Guide_Model> List, int position){

        this.List=List;
        this.context=context;
        addPosition=position;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageView;
        Spinner spinner;


        public MyViewHolder(View view) {
            super(view);

            title= (TextView) view.findViewById(R.id.title);

            imageView = (ImageView) view.findViewById(R.id.imageView);

            spinner=(Spinner)view.findViewById(R.id.spinner);
        }
    }


    @Override
    public Guide_CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guide_list_details1, parent, false);



        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final Guide_CustomAdapter.MyViewHolder holder,  int position) {


        holder.title.setText(List.get(position).getTitle());


        holder.imageView.setImageResource(List.get(position).imageId);



        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("position", addPosition);
                intent.putExtra("guide", List.get(holder.getAdapterPosition()));
                ((GuideListing) context).setResult(Activity.RESULT_OK, intent);
                ((GuideListing) context).finish();
            }

        });


    }
        @Override
    public int getItemCount()
    {
        return List.size();
    }


}

