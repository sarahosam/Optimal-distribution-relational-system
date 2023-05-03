package com.android.optimaldistributionrelationalsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.optimaldistributionrelationalsystem.amal.LoginWareHouseActivity;
import com.android.optimaldistributionrelationalsystem.aya.StoreManagerActivity;
import com.android.optimaldistributionrelationalsystem.databinding.ActivityMainBinding;
import com.android.optimaldistributionrelationalsystem.eman.EmanActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onClick();
    }

    private void onClick() {

        binding.btnDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, EmanActivity.class);
                startActivity(intent);
            }
        });

        binding.btnStoreManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, StoreManagerActivity.class);
                startActivity(intent);
            }
        });

        binding.btnWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginWareHouseActivity.class);
                startActivity(intent);
            }
        });
    }
}