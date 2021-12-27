package fr.isep.blindtest_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import Connectors.SongService;

public class PlayGame extends AppCompatActivity {

    private TextView track1View, track2View, track3View, track4View;
    private ImageView imageView;
    private Song song;

    public String url;

    private SongService songService;
    private ArrayList<Song> tracks;
    private ArrayList<Song> randomTracks = new ArrayList<>();

    protected String correctSong;

    private Button speechButton;
    private TextView textResult;
    private static final int RECOGNIZER_CODE = 1;
    protected int numberOfPlayers;
    protected int numberSecondsForEachMusic;
    protected String paramaterOfEnd;
    protected int numberToFinishGame;
    protected String namePlayer1;
    protected String namePlayer2;
    protected String namePlayer3;
    protected String namePlayer4;
    protected int scorePlayer1;
    protected int scorePlayer2;
    protected int scorePlayer3;
    protected int scorePlayer4;
    protected int numberOfMusicsPlayed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);


        songService = new SongService(getApplicationContext());
        track1View = findViewById(R.id.track1);
        track2View = findViewById(R.id.track2);
        track3View = findViewById(R.id.track3);
        track4View = findViewById(R.id.track4);
        imageView = findViewById(R.id.imageView);

        SharedPreferences sharedPreferences = this.getSharedPreferences("SPOTIFY", 0);
        getTracks();

        // Get the data from intent of the precedent page
        Intent intentBefore = getIntent();
        numberOfPlayers = intentBefore.getIntExtra("numberOfPlayers", 0);
        numberSecondsForEachMusic = intentBefore.getIntExtra("secondsMusicTime", 0)+
                60*intentBefore.getIntExtra("minutesMusicTime", 0);
        paramaterOfEnd = intentBefore.getStringExtra("parameterOfEnd");
        numberToFinishGame = intentBefore.getIntExtra("numberToFinishGame", 0);
        if(numberOfPlayers >= 1) {
            namePlayer1 = intentBefore.getStringExtra("namePlayer1");
        }
        if(numberOfPlayers >= 2) {
            namePlayer2 = intentBefore.getStringExtra("namePlayer2");
        }
        if(numberOfPlayers >= 3) {
            namePlayer3 = intentBefore.getStringExtra("namePlayer3");
        }
        if(numberOfPlayers == 4) {
            namePlayer4 = intentBefore.getStringExtra("namePlayer4");
        }
        scorePlayer1 = intentBefore.getIntExtra("scorePlayer1", 0);
        scorePlayer2 = intentBefore.getIntExtra("scorePlayer2", 0);
        scorePlayer3 = intentBefore.getIntExtra("scorePlayer3", 0);
        scorePlayer4 = intentBefore.getIntExtra("scorePlayer4", 0);
        numberOfMusicsPlayed = 0;
        activateSpeekButton();
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

    private void assignTracksToText() {
        track1View.setText(tracks.get(0).getName());
        track2View.setText(tracks.get(1).getName());
        track3View.setText(tracks.get(2).getName());
        track4View.setText(tracks.get(3).getName());
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

    private void updateImage() {
        new PlayGame.DownloadImageFromInternet((ImageView) findViewById(R.id.imageView)).execute(randomTracks.get(0).getUrl());
        correctSong = randomTracks.get(0).getName().toLowerCase();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RECOGNIZER_CODE && resultCode == RESULT_OK){
            ArrayList<String> taskText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if(taskText.get(0).toString().equals(correctSong)) { // Put the name of the song
                Intent intentChooseWinner = new Intent(this, ChooseWinner.class);
                intentChooseWinner.putExtra("numberOfPlayers", numberOfPlayers);
                intentChooseWinner.putExtra("namePlayer1", namePlayer1);
                intentChooseWinner.putExtra("namePlayer2", namePlayer2);
                intentChooseWinner.putExtra("namePlayer3", namePlayer3);
                intentChooseWinner.putExtra("namePlayer4", namePlayer4);
                intentChooseWinner.putExtra("scorePlayer1", scorePlayer1);
                intentChooseWinner.putExtra("scorePlayer2", scorePlayer2);
                intentChooseWinner.putExtra("scorePlayer3", scorePlayer3);
                intentChooseWinner.putExtra("scorePlayer4", scorePlayer4);
                intentChooseWinner.putExtra("parameterOfEnd", paramaterOfEnd);
                intentChooseWinner.putExtra("numberToFinishGame", numberToFinishGame);
                intentChooseWinner.putExtra("numberSecondsForEachMusic", numberSecondsForEachMusic);
                intentChooseWinner.putExtra("numberOfMusicsPlayed", numberOfMusicsPlayed);
                startActivity(intentChooseWinner);
                finish();
            } else {
                textResult.setText(taskText.get(0).toString()+" is not the correct answer");
            }
        }
    }


    public void activateSpeekButton() {
        speechButton = findViewById(R.id.speechbutton);
        textResult = findViewById(R.id.textResult);

        speechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speek Up");

                startActivityForResult(intent,RECOGNIZER_CODE);
            }
        });
    }

}
