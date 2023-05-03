package com.android.optimaldistributionrelationalsystem.eman;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.optimaldistributionrelationalsystem.R;
import com.android.optimaldistributionrelationalsystem.ordertoday.OrderToDayActivity;

public class EmanActivity extends AppCompatActivity {
    private EditText email, password;
    private Button signup;
    private Button login;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eman);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        initial();
    }

    private void initial() {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(EmanActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginwithemail(email.getText().toString(), password.getText().toString());
            }
        });
    }

    private void loginwithemail(String em, String pass) {
        if (em.length() > 4 && pass.length() > 6) {

            Intent intent = new Intent();
            intent.setClass(EmanActivity.this, OrderToDayActivity.class);
            startActivity(intent);

        } else {
            if (em.length() < 4) {
                email.setError("email not vaild");
            }
            if (pass.length() < 6) {
                password.setError("email not vaild");
            }
        }
    }
}