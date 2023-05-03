package com.android.optimaldistributionrelationalsystem.aya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.optimaldistributionrelationalsystem.R;

public class StoreManagerActivity extends Activity {

    Button submitButton;
    EditText Code, Password, address, mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_manager);

        Code = (EditText) findViewById(R.id.storeid);
        Password = (EditText) findViewById(R.id.passwordid);
        address = (EditText) findViewById(R.id.address);
        mobileNumber = (EditText) findViewById(R.id.mobileNumber);
        submitButton = (Button) findViewById(R.id.submitt);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (validate(Code) && validate(address)
                        && validate(Password) && validate(mobileNumber)) {
                    Toast.makeText(getApplicationContext(), "SuccessFully Register", Toast.LENGTH_LONG).show();
                    if (v.getId() == R.id.submitt) {
                        Intent intent = new Intent(StoreManagerActivity.this, SelectServecActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(EditText editText) {
        if (editText.getText().toString().trim().length() < 1) {
            editText.setError("Please Fill This.!!!");
            editText.requestFocus();
            return false;
        }
        return true;
    }

}