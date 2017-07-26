package com.example.devil.car_project.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.devil.car_project.R;
import com.example.devil.car_project.helpers.InputValidation;
import com.example.devil.car_project.sql.DatabaseHelper;
import com.example.devil.car_project.activities.DBHandler;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.onClick;
import static android.R.attr.start;
import static com.example.devil.car_project.R.id.activity_main;
import static com.example.devil.car_project.R.id.appCompatButtonLogin;
import static com.example.devil.car_project.R.id.nestedScrollView;

/**
 * Created by devil on 4/22/2017.
 */

public class Viewer_UserActivity extends AppCompatActivity implements View.OnClickListener {
    public String message;
    public String name1;
    public String add;
    public String fit;
    public String tax;
    public String cnum;
    public String insu;
    public String message1;
    public NestedScrollView nestedScrollView;
    private TextInputEditText textInputEditTextCar;
    private AppCompatButton appCompatButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        appCompatButtonSubmit = (AppCompatButton) findViewById(R.id.appCompatButtonSubmit);
        initViews();
        initListeners();



    }

    public void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputEditTextCar = (TextInputEditText) findViewById(R.id.textInputEditTextCar);
        message = textInputEditTextCar.getText().toString();

    }


    private void initListeners() {
        appCompatButtonSubmit.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonSubmit:

                Intent intent = new Intent(getApplicationContext(), ShowDataActivity.class);
                startActivity(intent);
                break;

        }
    }


}