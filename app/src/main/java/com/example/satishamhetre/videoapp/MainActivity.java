package com.example.satishamhetre.videoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private videoAdapter videoAdapter1;
    private RecyclerView recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1 = (RecyclerView) findViewById(R.id.contact_display);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.addOnItemTouchListener( new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(),video.class);
                startActivity(intent);
            }
        }));
        recyclerView1.setHasFixedSize(false);
        recyclerView1.addItemDecoration(new SimpleDivideItemDecoration(this));

        videoAdapter1 =new videoAdapter(10);
        recyclerView1.setAdapter(videoAdapter1);
        videoAdapter1.notifyDataSetChanged();

    }

    void videoPlay(){
        Intent intent = new Intent(this, video.class);
        startActivity(intent);
    }

}
