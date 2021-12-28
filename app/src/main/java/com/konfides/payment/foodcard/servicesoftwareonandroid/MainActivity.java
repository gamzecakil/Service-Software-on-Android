package com.konfides.payment.foodcard.servicesoftwareonandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnService;
    boolean serviceStatus=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnService=findViewById(R.id.button);

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(!serviceStatus) //If serviceStatus is false-->Service is starting
             {
                 Intent intent=new Intent(MainActivity.this,MyService.class);
                 startService(intent);
                 serviceStatus=true;
                 btnService.setText("Servisi Durdur");
             }
             else
             {
                 //If serviceStatus is true-->Service is stopping
                 Intent intent=new Intent(MainActivity.this,MyService.class);
                 stopService(intent);
                 serviceStatus=false;
                 btnService.setText("Servisi Başlat");
             }
            }
        });
    }
}