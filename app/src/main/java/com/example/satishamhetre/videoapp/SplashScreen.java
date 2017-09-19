package com.example.satishamhetre.videoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread =new Thread(){
            @Override
            public void run() {
                super.run();

                try{
                    sleep(1000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        thread.start();


    }
}
