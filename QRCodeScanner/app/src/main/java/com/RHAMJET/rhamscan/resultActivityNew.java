package com.RHAMJET.rhamscan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class resultActivityNew extends AppCompatActivity {


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_new);

        TextView resultView = (TextView) findViewById(R.id.textViewMain);
        TextView resultViewBody = (TextView) findViewById(R.id.textViewBody);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);

        String msg = getIntent().getStringExtra("Key");
        //resultView.setText(msg);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        Map<String,Object> result= databaseAccess.getAddress(msg);

        resultView.setText((String)result.get("ArtName"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] image = (byte[]) result.get("Image");
            System.out.println("Imageeee:::"+image);
            Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
            imageView.setImageBitmap(bmp);

            resultViewBody.setText((String) result.get("Description"));


        databaseAccess.close();
        }catch(Exception ex){
        System.out.println("Main Java::");
        ex.printStackTrace();
    }
    }

}