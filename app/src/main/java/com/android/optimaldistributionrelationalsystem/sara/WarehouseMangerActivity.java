package com.android.optimaldistributionrelationalsystem.sara;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.optimaldistributionrelationalsystem.R;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class WarehouseMangerActivity extends AppCompatActivity implements OrderAdapter.itemClickListener {

    ArrayList<productitem> productlist;
    productAdapters adapters;

    RecyclerView playout;

    ArrayList<orderitem> orderitems;
    OrderAdapter adapter;
    RecyclerView play;

    MeowBottomNavigation bottomNavigation;
    RelativeLayout home,order;
    ConstraintLayout add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_manger);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        home = findViewById(R.id.home);
        add = findViewById(R.id.add);
        order = findViewById(R.id.order);

        //first page will appear
        bottomNavigation.show(1, true);


        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_local_grocery_store_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_content_paste_24));


        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @SuppressLint("NewApi")
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES

                switch (model.getId()) {

                    case 1:

                        home.setVisibility(View.VISIBLE);
                        add.setVisibility(View.GONE);
                        order.setVisibility(View.GONE);

                        getWindow().setStatusBarColor(Color.parseColor("#439A97"));
                        break;

                    case 2:
                        home.setVisibility(View.GONE);
                        add.setVisibility(View.VISIBLE);
                        order.setVisibility(View.GONE);

                        getWindow().setStatusBarColor(Color.parseColor("#439A97"));

                        break;
                    case 3:
                        home.setVisibility(View.GONE);
                        add.setVisibility(View.GONE);
                        order.setVisibility(View.VISIBLE);

                        getWindow().setStatusBarColor(Color.parseColor("#439A97"));
                        break;

                }


                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES

                switch (model.getId()) {
                    case 1:
                        home.setVisibility(View.VISIBLE);
                        add.setVisibility(View.GONE);
                        order.setVisibility(View.GONE);

                        break;

                }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES

                switch (model.getId()) {
                    case 2:
                        home.setVisibility(View.GONE);
                        add.setVisibility(View.VISIBLE);
                        order.setVisibility(View.GONE);

                        break;

                }
                return null;
            }
        });
        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES

                switch (model.getId()) {
                    case 3:
                        home.setVisibility(View.GONE);
                        add.setVisibility(View.GONE);
                        order.setVisibility(View.VISIBLE);

                        break;

                }
                return null;
            }
        });

        playout = findViewById(R.id.product);

        productlist = new ArrayList<>();
        productlist.add(new productitem(R.drawable.smart, 1, "Smart Watch", "it contain a microphone that filters out background noise as well as built-in accelerometers and optical sensors capable of detecting taps and pinches", "800$"));
        productlist.add(new productitem(R.drawable.phone, 2, "Mobile Phone", "it contain a microphone that filters out background noise as well as built-in accelerometers and optical sensors capable of detecting taps and pinches", "800$"));
        productlist.add(new productitem(R.drawable.laptop, 3, "Laptop", "it contain a microphone that filters out background noise as well as built-in accelerometers and optical sensors capable of detecting taps and pinches", "800$"));
        productlist.add(new productitem(R.drawable.airpods, 4, "Airpods", "it contain a microphone that filters out background noise as well as built-in accelerometers and optical sensors capable of detecting taps and pinches", "800$"));
        productlist.add(new productitem(R.drawable.smart, 5, "Smart Watch", "it contain a microphone that filters out background noise as well as built-in accelerometers and optical sensors capable of detecting taps and pinches", "800$"));
        productlist.add(new productitem(R.drawable.phone, 6, "Mobile Phone", "it contain a microphone that filters out background noise as well as built-in accelerometers and optical sensors capable of detecting taps and pinches", "800$"));
        productlist.add(new productitem(R.drawable.laptop, 7, "Laptop", "it contain a microphone that filters out background noise as well as built-in accelerometers and optical sensors capable of detecting taps and pinches", "800$"));
        productlist.add(new productitem(R.drawable.airpods, 8, "Airpods", "it contain a microphone that filters out background noise as well as built-in accelerometers and optical sensors capable of detecting taps and pinches", "800$"));

        adapters = new productAdapters(productlist, this);
        playout.setAdapter(adapters);
        playout.setLayoutManager(new GridLayoutManager(this, 2));

        play = findViewById(R.id.rv_order);
        orderitems = new ArrayList<>();
        orderitems.add(new orderitem(R.drawable.airpods, "Airpods", "Quantity: 100", "Price: 500", "Store Code: 2", "Address: Cairo"));
        orderitems.add(new orderitem(R.drawable.laptop, "Laptop", "Quantity: 200", "Price: 11000", "Store Code: 8", "Address: Cairo"));
        orderitems.add(new orderitem(R.drawable.smart, "Smart Watch", "300", "1200", "6", "Cairo"));
        orderitems.add(new orderitem(R.drawable.phone, "phone", "133", "2000", "1", "Cairo"));
        orderitems.add(new orderitem(R.drawable.airpods, "Airpods", "341", "500", "9", "Cairo"));
        orderitems.add(new orderitem(R.drawable.smart, "Smart Watch", "78", "800", "7", "Cairo"));
        orderitems.add(new orderitem(R.drawable.laptop, "Laptop", "30", "31000", "5", "Cairo"));
        orderitems.add(new orderitem(R.drawable.phone, "Phone", "12", "5000", "4", "Cairo"));

        adapter = new OrderAdapter(orderitems, this, this);
        play.setAdapter(adapter);
        play.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClik(View view) {
        if (view.getId() == R.id.bu) {
            Intent intent = new Intent(this, DriversActivity.class);
            startActivity(intent);
        }

    }
    public void On(View v){
        if(v.getId()==R.id.btn_add){
            Toast.makeText(getApplicationContext(), "Product has been added ", Toast.LENGTH_SHORT).show();
        }

    }


}