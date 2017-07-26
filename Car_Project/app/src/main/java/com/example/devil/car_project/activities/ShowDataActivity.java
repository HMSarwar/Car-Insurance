package com.example.devil.car_project.activities;
        import  android.content.Intent;
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

/**
 * Created by devil on 4/22/2017.
 */

public class ShowDataActivity extends Viewer_UserActivity {

    AppCompatTextView textviewmessage;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        textviewmessage.setText(message1);
        textviewmessage = (AppCompatTextView) findViewById(R.id.message);


        initObjects();


    }



    public void initObjects() {

        DBHandler db = new DBHandler(getBaseContext());
        Cars car1;
        List<Cars> car = new ArrayList<Cars>();
        car = db.getCars(message);
        car1 = car.get(0);
        name1 = car1.getName();
        add = car1.getAddress();
        cnum = car1.getCar_number();
        fit = car1.getFitness();
        insu = car1.getReport();
        tax = car1.getTax();
        message1 = name1 + add + cnum + fit + insu + tax;
    }}




