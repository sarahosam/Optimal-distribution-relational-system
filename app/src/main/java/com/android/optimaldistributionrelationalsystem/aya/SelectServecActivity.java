package com.android.optimaldistributionrelationalsystem.aya;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.optimaldistributionrelationalsystem.R;
import com.android.optimaldistributionrelationalsystem.StatusActivity;
import com.android.optimaldistributionrelationalsystem.shahand.ViewItemActivity;

public class SelectServecActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_servec);


    }

    public void onClick(View v){
        switch(v.getId()){

            case R.id.add:
                Intent intent= new Intent( SelectServecActivity.this, ViewItemActivity.class);
                startActivity(intent);
                break;
            case R.id.track:
                Intent inten= new Intent( SelectServecActivity.this, StatusActivity.class);
                startActivity(inten);
                break;

        }
    }
}