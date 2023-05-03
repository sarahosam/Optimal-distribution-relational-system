package com.android.optimaldistributionrelationalsystem.amal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.optimaldistributionrelationalsystem.R;
import com.android.optimaldistributionrelationalsystem.databinding.ActivityOrderBinding;
import com.android.optimaldistributionrelationalsystem.sara.DriversActivity;

public class OrderActivity extends AppCompatActivity {

    private ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onClick();
    }

    private void onClick() {

        String product = binding.product.toString();
        String quantity = binding.quantity.toString();
        String price = binding.price.toString();
        String description = binding.description.toString();

        if (product.isEmpty()) {
            binding.product.setError(getString(R.string.required));

        } else if (quantity.isEmpty()) {
            binding.quantity.setError(getString(R.string.required));

        } else if (price.isEmpty()) {
            binding.price.setError(getString(R.string.required));

        } else {
            Intent intent = new Intent(this, DriversActivity.class);
            startActivity(intent);
        }
    }
}