package com.example.satishamhetre.videoapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Satish A. Mhetre on 18-09-2017.
 */

public class videoAdapter extends RecyclerView.Adapter <videoAdapter.videoHolder  >{


    long duration;
    String time;
    Bitmap image=null;
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    BitmapDrawable imageInDrawable;


    public int NumberOfItems;

    public  videoAdapter(int number){
        NumberOfItems = number;
        if (Build.VERSION.SDK_INT >= 14)
            retriever.setDataSource("http://proxynotes.com/assignmnet/test.mp4?videoid=0001", new HashMap<String, String>());
        else
            retriever.setDataSource("http://proxynotes.com/assignmnet/test.mp4?videoid=0001");

        //getting time
        time=retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        long timeInmillisec = Long.parseLong( time );
        duration = timeInmillisec / 1000;
        Log.e("time = ", duration+"");

        //getting bitmap(thumbnail)
        image=  retriever.getFrameAtTime(1);
        imageInDrawable=new BitmapDrawable(image);
    }


    @Override
    public videoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.display_format;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem,parent, shouldAttachToParentImmediately);
        videoHolder contactHolder1 =new videoHolder(view);
        return contactHolder1;

    }

    @Override
    public void onBindViewHolder(videoHolder holder,final int position) {


        holder.image.setImageDrawable(imageInDrawable);
        holder.title.setText("Title : Video No. " + (position+1));
        holder.duration.setText("Duration : " +(duration/3600) + ":" + ((duration%3600)/60)+ ":" + (((duration%3600)%60)));
        holder.discription.setText(" This is "+" video no. "+ (position+1));
        holder.link.setText("link : " + "http://proxynotes.com/assignmnet/test.mp4?videoid=0001");

    }

    @Override
    public int getItemCount(){
        return NumberOfItems;
    }



    class videoHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title ;
        TextView duration;
        TextView discription;
        TextView link;

        public videoHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            duration= (TextView) itemView.findViewById(R.id.duration);
            discription=(TextView)itemView.findViewById(R.id.description);
            link=(TextView)itemView.findViewById(R.id.link);

        }


    }




}
