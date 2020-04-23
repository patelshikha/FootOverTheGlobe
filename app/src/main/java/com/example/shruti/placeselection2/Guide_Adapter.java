package com.example.shruti.placeselection2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class Guide_Adapter extends RecyclerView.Adapter<Guide_Adapter.MyViewHolder> {
    private Context context;
    private List<Guide_FeedItem> guideFeedItems = new ArrayList<>();
    private ArrayList<Languages> languageList=new ArrayList<>();


    public Guide_Adapter(Context context, List<Guide_FeedItem> guideFeedItems,ArrayList<Languages> languageList) {
        this.context = context;

         this.guideFeedItems=guideFeedItems;

        this.languageList=languageList;

     }
/*
    public Guide_Adapter(Context context, ArrayList<Languages> objects) {
        this.context = context;

        this.languageList = objects;

        //super(context,languageList);
        languageList=objects;
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLoc;
        TextView tvAddPlace;
        Spinner spinner;

        public MyViewHolder(View view) {
            super(view);
                        tvLoc = (TextView) view.findViewById(R.id.tvLoc);
                       tvAddPlace = (TextView) view.findViewById(R.id.tvAddPlace);
                        spinner=(Spinner)view.findViewById(R.id.spinner);
        }
    }


    @Override
    public Guide_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guide_layout_abc, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Guide_Adapter.MyViewHolder holder, int position) {


        holder.tvLoc.setText(guideFeedItems.get(position).getDate());

        if (guideFeedItems.get(position).getObjGuide() == null) {
            holder.tvAddPlace.setText("Add Guide");
        } else {
            holder.tvAddPlace.setText(guideFeedItems.get(position).getObjGuide().getTitle());
        }

        holder.tvAddPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GuideListing.class);
                intent.putExtra("position", holder.getAdapterPosition());

                ((Guide_MainActivity) context).startActivityForResult(intent, 100);
            }
        });

      /*  holder.spinner.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, GuideListing.class);
                intent.putExtra("position", holder.getAdapterPosition());

                ((Guide_MainActivity) context).startActivityForResult(intent, 100);

            }
                                          }
        );*/
    }


    @Override
    public int getItemCount() {
        return guideFeedItems.size();
    }


}





