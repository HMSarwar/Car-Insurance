package com.example.devil.car_project.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.*;
import com.example.devil.car_project.R;

import static android.R.attr.button;
import static android.R.string.no;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button police, user, insurance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        police = (Button) findViewById(R.id.pol);
        user = (Button) findViewById(R.id.user);
        insurance = (Button) findViewById(R.id.ins);

        police.setOnClickListener(this);
        user.setOnClickListener(this);
        insurance.setOnClickListener(this);

        DBHandler db = new DBHandler(this);
        db.addCars(new Cars("Towfiq Tomal","house no-30, road no-02, Solimuddi Market, Mirpur10, Dhaka", "DM098765", "FC 3749394", "408003", "419354" ));
    }

    @Override

    public void onClick(View v) {
        if (v.getId() == R.id.pol) {
            Intent intent = new Intent(MainActivity.this, Login_PoliceActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.ins) {
            Intent intent = new Intent(MainActivity.this, Login_InsuranceActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.user) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

    }



}