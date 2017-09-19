package com.example.satishamhetre.videoapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends AppCompatActivity {

    ProgressDialog progressDialog;
    VideoView videoView;
    String url="http://proxynotes.com/assignmnet/test.mp4?videoid=0001";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);



        videoView = (VideoView) findViewById(R.id.VideoView);
        progressDialog = new ProgressDialog(this);


        progressDialog.setMessage("Loading... ");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();

        try {
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);

            Uri video = Uri.parse(url);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(video);
        }
        catch (Exception e){
            Log.e("Error",e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressDialog.dismiss();
                videoView.start();
            }
        });

    }


}
