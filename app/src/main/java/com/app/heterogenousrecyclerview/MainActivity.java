package com.app.heterogenousrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.heterogenousrecyclerview.adapters.TripsAdapter;
import com.app.heterogenousrecyclerview.models.Ads;
import com.app.heterogenousrecyclerview.models.Item;
import com.app.heterogenousrecyclerview.models.News;
import com.app.heterogenousrecyclerview.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        setData();
    }

    private void setData() {

        List<Item> items = new ArrayList<>();

        //Here setting Data here -
        //Here Types are: 0-Trips,1-Ads,2-News
        Trip trip1 = new Trip("Western Trip","Western Trip Desc.",R.drawable.trip_one);
        items.add(new Item(0,trip1));

        Ads ads1 = new Ads("AD. Deepawali Sale","70% off all Products Todays");
        items.add(new Item(1,ads1));

        Trip trip2 = new Trip("Indian Trip","Western Trip Desc.",R.drawable.trip_three);
        items.add(new Item(0,trip2));

        News news1 = new News("Govt Policies Alert!!","our govt changed new systems !!");
        items.add(new Item(2,news1));


        Ads ads2 = new Ads("AD. Holi Sale","New Colors Found Today!!");
        items.add(new Item(1,ads2));

        News news2 = new News("Govt Old Alert!!","our govt changed new systems !!");
        items.add(new Item(2,news2));

        Trip trip3 = new Trip("American Trip","American Trip Desc.",R.drawable.trip_two);
        items.add(new Item(0,trip3));


        TripsAdapter tripsAdapter = new TripsAdapter(this,items);
        recyclerView.setAdapter(tripsAdapter);
    }
}