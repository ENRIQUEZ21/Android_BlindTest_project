package fr.isep.blindtest_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executors;

import Connectors.SongService;

public class MainActivity2 extends AppCompatActivity {
    private TextView track1View, track2View, track3View, track4View;
    private ImageView imageView;
    private Song song;

    public String url;

    private SongService songService;
    private ArrayList<Song> tracks;
    private ArrayList<Song> randomTracks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        songService = new SongService(getApplicationContext());
        track1View = findViewById(R.id.track1);
        track2View = findViewById(R.id.track2);
        track3View = findViewById(R.id.track3);
        track4View = findViewById(R.id.track4);
        imageView = findViewById(R.id.imageView);




        SharedPreferences sharedPreferences = this.getSharedPreferences("SPOTIFY", 0);


        getTracks();
    }


    private void getTracks() {
        songService.getTracks(() -> {
            tracks = songService.getSongs();
            assignTracksToText();
            randomizeTracks();
            tracksToSet();
            updateImage();
        });
    }

    private void randomizeTracks() {
        Collections.shuffle(tracks);
    }

    private void tracksToSet() {
        randomTracks.add(tracks.get(0));
        randomTracks.add(tracks.get(1));
        randomTracks.add(tracks.get(2));
        randomTracks.add(tracks.get(3));
    }

    private void assignTracksToText() {
        track1View.setText(tracks.get(0).getName());
        track2View.setText(tracks.get(1).getName());
        track3View.setText(tracks.get(2).getName());
        track4View.setText(tracks.get(3).getName());
    }

    private void updateImage() {
        new DownloadImageFromInternet((ImageView) findViewById(R.id.imageView)).execute(randomTracks.get(0).getUrl());
        Log.d("yo",randomTracks.get(0).getUrl());
    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView=imageView;
            Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...",Toast.LENGTH_SHORT).show();
        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL=urls[0];
            Bitmap bimage=null;
            try {
                InputStream in=new java.net.URL(imageURL).openStream();
                bimage= BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

}