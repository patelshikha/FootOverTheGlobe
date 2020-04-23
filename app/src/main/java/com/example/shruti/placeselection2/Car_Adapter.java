package com.example.shruti.placeselection2;

/**
 * Created by admin on 11/20/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Car_Adapter extends RecyclerView.Adapter<Car_Adapter.MyViewHolder> {
    private List<CAR> List= new ArrayList<>();





    public Car_Adapter(Context mContext, List<CAR> List){

        this.List=List;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageView;
        TextView description;
        TextView capacity;
        TextView AirConditional;
        TextView frwf;



        public MyViewHolder(View view) {
            super(view);

            title= (TextView) view.findViewById(R.id.title);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            description= (TextView) view.findViewById(R.id.dec1);
            capacity= (TextView) view.findViewById(R.id.cb);
            AirConditional=(TextView)view.findViewById(R.id.ac);
            //frwf=(TextView)view.findViewById(R.id.fw);

        }
    }


    @Override
    public Car_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_list_details, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent1 = new Intent(context, Hotel_Activity1.class);
                context.startActivity(intent1);
            }
        });

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(Car_Adapter.MyViewHolder holder, int position) {


        holder.title.setText(List.get(position).getTitle());
        holder.imageView.setImageResource(List.get(position).imageId);
        holder.description.setText(List.get(position).getDescription());
        holder.capacity.setText(List.get(position).getCapacity()+"");
        holder.AirConditional.setText(List.get(position).getAirConditional());
        // holder.frwf.setText(languageList.get(position).getfrwf());


    }

    @Override
    public int getItemCount()
    {
        return List.size();
    }


}


