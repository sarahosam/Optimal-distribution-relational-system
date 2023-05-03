package com.android.optimaldistributionrelationalsystem.shahand;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.android.optimaldistributionrelationalsystem.Status2Activity;
import com.android.optimaldistributionrelationalsystem.databinding.ActivityViewItemBinding;

public class ViewItemActivity extends AppCompatActivity {

    ActivityViewItemBinding binding;
    AdapterRecycler adapter = new AdapterRecycler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setAdapter(adapter);
        // there no thing left put list of data in adapter

        onClick();
    }

    private void onClick() {

        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ViewItemActivity.this, Status2Activity.class);
                startActivity(intent);
            }
        });

    }

}