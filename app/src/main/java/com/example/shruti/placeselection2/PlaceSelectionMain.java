package com.example.shruti.placeselection2;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaceSelectionMain extends AppCompatActivity {

    RecyclerView horizontal_recycler_view,verticalView;
    HorizontalAdapter horizontalAdapter;
    private List<PlaceData> data;
    Button button;
    PlaceMyAdapter placeMyAdapter=null;

    List<AddPlaceModel> List = new ArrayList<>();

    AddPlaceAdapter addPlace=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_main);
        button = (Button) findViewById(R.id.bt);
       Button b = (Button) findViewById(R.id.button4);
        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(PlaceSelectionMain.this,
                        PlaceList.class);
                startActivity(myIntent);
            }
        });

        verticalView = (RecyclerView) findViewById(R.id.verticalView);

        List.add(new AddPlaceModel("13-11-2017", null));
        List.add(new AddPlaceModel("14-11-2017", null));
        List.add(new AddPlaceModel("15-11-2017", null));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        verticalView.setLayoutManager(mLayoutManager);

        addPlace = new AddPlaceAdapter(PlaceSelectionMain.this,List);
        verticalView.setAdapter(addPlace);


        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        data = fill_with_data();


        horizontalAdapter = new HorizontalAdapter(data, getApplication());

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(PlaceSelectionMain.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);



        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(PlaceSelectionMain.this,Car_MainActivity.class);
                startActivity(myIntent);
            }
        });

    }

    public List<PlaceData> fill_with_data() {

        List<PlaceData> data = new ArrayList<>();

        data.add(new PlaceData(R.drawable.vadodara, "Vadodara"));
        data.add(new PlaceData(R.drawable.surat, "Surat"));
        data.add(new PlaceData(R.drawable.vadodara, "Goa"));
        data.add(new PlaceData(R.drawable.surat, "Bombay"));
        data.add(new PlaceData(R.drawable.udaipur, "Udaipur"));
        data.add(new PlaceData(R.drawable.udaipur, "Rajasthan"));
        data.add(new PlaceData(R.drawable.surat, "Ahmedabad"));
        data.add(new PlaceData(R.drawable.vadodara, "Vadodara"));
        data.add(new PlaceData(R.drawable.surat, "Surat"));
        data.add(new PlaceData(R.drawable.vadodara, "Goa"));
        data.add(new PlaceData(R.drawable.surat, "Bombay"));


        return data;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data != null) {
                int pos = data.getIntExtra("position", 0);
                List.get(pos).setObjPlace((PlaceModel) data.getParcelableExtra("place"));


                if (placeMyAdapter != null) {
                    placeMyAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {


        List<PlaceData> horizontalList = Collections.emptyList();
        Context context;


        public HorizontalAdapter(List<PlaceData> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView txtview;

            public MyViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.imageview);
                txtview = (TextView) view.findViewById(R.id.txtview);
            }
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_singleview_horizontal, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.imageView.setImageResource(horizontalList.get(position).imageId);
            holder.txtview.setText(horizontalList.get(position).txt);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String list = horizontalList.get(position).txt.toString();
                    Toast.makeText(PlaceSelectionMain.this, list, Toast.LENGTH_SHORT).show();
                }

            });

        }


        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }

}
