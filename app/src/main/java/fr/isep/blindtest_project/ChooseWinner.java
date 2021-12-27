package fr.isep.blindtest_project;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseWinner extends AppCompatActivity {
    protected int numberOfPlayers;
    protected String namePlayer1;
    protected String namePlayer2;
    protected String namePlayer3;
    protected String namePlayer4;
    protected int numberSecondsForEachMusic;
    protected String paramaterOfEnd;
    protected int numberToFinishGame;
    protected int scorePlayer1;
    protected int scorePlayer2;
    protected int scorePlayer3;
    protected int scorePlayer4;
    protected int numberOfMusicsPlayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentBefore = getIntent();
        numberOfPlayers = intentBefore.getIntExtra("numberOfPlayers", 1);
        namePlayer1 = intentBefore.getStringExtra("namePlayer1");
        namePlayer2 = intentBefore.getStringExtra("namePlayer2");
        namePlayer3 = intentBefore.getStringExtra("namePlayer3");
        namePlayer4 = intentBefore.getStringExtra("namePlayer4");
        numberSecondsForEachMusic = intentBefore.getIntExtra("secondsMusicTime", 0)+
                60*intentBefore.getIntExtra("minutesMusicTime", 0);
        paramaterOfEnd = intentBefore.getStringExtra("parameterOfEnd");
        numberToFinishGame = intentBefore.getIntExtra("numberToFinishGame", 0);
        scorePlayer1 = intentBefore.getIntExtra("scorePlayer1", 0);
        scorePlayer2 = intentBefore.getIntExtra("scorePlayer2", 0);
        scorePlayer3 = intentBefore.getIntExtra("scorePlayer3", 0);
        scorePlayer4 = intentBefore.getIntExtra("scorePlayer4", 0);
        numberOfMusicsPlayed = intentBefore.getIntExtra("numberOfMusicsPlayed", 0);

        if(numberOfPlayers == 1) {
            scorePlayer1++;
            if(paramaterOfEnd.equals("Number of points")) {
                if(numberToFinishGame == scorePlayer1) {
                    Intent intent = new Intent(this, EndGame.class);
                    intent.putExtra("namePlayer", namePlayer1);
                    startActivity(intent);
                    finish();
                    return;
                }
            } else {
                if(numberOfMusicsPlayed == numberToFinishGame) {
                    // Redirect to end page
                }
            }
            returnToPlayGame();
        } else {
            setContentView(R.layout.activity_player_found);
            Button btnPlayer1 = findViewById(R.id.btn_player_1);
            Button btnPlayer2 = findViewById(R.id.btn_player_2);
            Button btnPlayer3 = findViewById(R.id.btn_player_3);
            Button btnPlayer4 = findViewById(R.id.btn_player_4);
            if(numberOfPlayers >= 1) {
                btnPlayer1.setVisibility(View.VISIBLE);
                btnPlayer1.setText(namePlayer1);
            }
            if(numberOfPlayers >= 2) {
                btnPlayer2.setVisibility(View.VISIBLE);
                btnPlayer2.setText(namePlayer2);
            }
            if(numberOfPlayers >= 3) {
                btnPlayer3.setVisibility(View.VISIBLE);
                btnPlayer3.setText(namePlayer3);
            }
            if(numberOfPlayers == 4) {
                btnPlayer4.setVisibility(View.VISIBLE);
                btnPlayer4.setText(namePlayer4);
            }
        }
    }

    public void buttonPlayer1Found(View view) {
        scorePlayer1++;
        if(paramaterOfEnd.equals("Number of points")) {
            if(numberToFinishGame == scorePlayer1) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("namePlayer", namePlayer1);
                startActivity(intent);
                finish();
                return;
            }
        } else {
            if(numberOfMusicsPlayed == numberToFinishGame) {
                // Redirect to end page
            }
        }
        returnToPlayGame();
    }

    public void buttonPlayer2Found(View view) {
        scorePlayer2++;
        if(paramaterOfEnd.equals("Number of points")) {
            if(numberToFinishGame == scorePlayer2) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("namePlayer", namePlayer2);
                startActivity(intent);
                finish();
                return;
            }
        } else {
            if(numberOfMusicsPlayed == numberToFinishGame) {
                // Redirect to end page
            }
        }
        returnToPlayGame();
    }

    public void buttonPlayer3Found(View view) {
        scorePlayer3++;
        if(paramaterOfEnd.equals("Number of points")) {
            if(numberToFinishGame == scorePlayer3) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("namePlayer", namePlayer3);
                startActivity(intent);
                finish();
                return;
            }
        } else {
            if(numberOfMusicsPlayed == numberToFinishGame) {
                // Redirect to end page
            }
        }
        returnToPlayGame();
    }

    public void buttonPlayer4Found(View view) {
        scorePlayer4++;
        if(paramaterOfEnd.equals("Number of points")) {
            if(numberToFinishGame == scorePlayer4) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("namePlayer", namePlayer4);
                startActivity(intent);
                finish();
                return;
            }
        } else {
            if(numberOfMusicsPlayed == numberToFinishGame) {
                // Redirect to end page
            }
        }
        returnToPlayGame();
    }

    public void returnToPlayGame() {
        Intent intent = new Intent(this, PlayGame.class);
        intent.putExtra("numberOfPlayers", numberOfPlayers);
        intent.putExtra("namePlayer1", namePlayer1);
        intent.putExtra("namePlayer2", namePlayer2);
        intent.putExtra("namePlayer3", namePlayer3);
        intent.putExtra("namePlayer4", namePlayer4);
        intent.putExtra("scorePlayer1", scorePlayer1);
        intent.putExtra("scorePlayer2", scorePlayer2);
        intent.putExtra("scorePlayer3", scorePlayer3);
        intent.putExtra("scorePlayer4", scorePlayer4);
        intent.putExtra("parameterOfEnd", paramaterOfEnd);
        intent.putExtra("numberToFinishGame", numberToFinishGame);
        intent.putExtra("numberSecondsForEachMusic", numberSecondsForEachMusic);
        intent.putExtra("numberOfMusicsPlayed", numberOfMusicsPlayed);
        startActivity(intent);
        finish();
    }
}
