package com.example.devil.car_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.devil.car_project.activities.LoginActivity;
import com.example.devil.car_project.activities.Login_InsuranceActivity;
import com.example.devil.car_project.activities.Login_PoliceActivity;

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