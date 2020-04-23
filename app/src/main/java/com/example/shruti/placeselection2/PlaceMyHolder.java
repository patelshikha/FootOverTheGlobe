package com.example.shruti.placeselection2;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Shruti on 23-11-2017.
 */

public class PlaceMyHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {

    ImageView img;
    TextView name,dec;
ItemTouchListener itemTouchListener;


    public PlaceMyHolder(View itemView) {
        super(itemView);

    name=(TextView) itemView.findViewById(R.id.name);
        dec=(TextView) itemView.findViewById(R.id.dec);
       img=(ImageView) itemView.findViewById(R.id.imgview);

        itemView.setOnTouchListener(this);
    }

public void setItemTouchListener(ItemTouchListener itemTouchListener)
{
    this.itemTouchListener=itemTouchListener;
}

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        this.itemTouchListener.onItemTouch(getLayoutPosition());
        return false;

    }
}
