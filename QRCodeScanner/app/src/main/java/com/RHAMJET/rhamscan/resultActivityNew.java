package com.RHAMJET.rhamscan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class resultActivityNew extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_new);

        TextView resultView = (TextView) findViewById(R.id.textViewMain);
        TextView resultViewBody = (TextView) findViewById(R.id.textViewBody);

        String msg = getIntent().getStringExtra("Key");
        //resultView.setText(msg);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        Map<String,String> result= databaseAccess.getAddress(msg);

        resultView.setText(result.get("ArtName"));
        resultViewBody.setText(result.get("Description"));

        databaseAccess.close();
    }

}