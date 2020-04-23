package com.example.shruti.placeselection2;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Shruti on 24-11-2017.
 */

public class SwipeHelper extends ItemTouchHelper.SimpleCallback{

    PlaceMyAdapter adapter;


    public SwipeHelper(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);

    }

    public SwipeHelper( PlaceMyAdapter adapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        adapter.openMain2Activity();

    }
}
