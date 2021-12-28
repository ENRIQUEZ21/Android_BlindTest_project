package fr.isep.blindtest_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGame extends AppCompatActivity {

    int numberOfPlayers;
    int numberToFinishGame;
    int scorePlayer1;
    int scorePlayer2;
    int scorePlayer3;
    int scorePlayer4;
    String nameWinner;
    String namePlayer1;
    String namePlayer2;
    String namePlayer3;
    String namePlayer4;
    TextView textView;

    @Override
    public void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();
        ImageView imageViewNext = findViewById(R.id.image_replay);
        imageViewNext.setImageResource(R.drawable.ic_replay_foreground);
        imageViewNext.setElevation(8f);
        numberOfPlayers = intent.getIntExtra("numberOfPlayers", 0);
        numberToFinishGame = intent.getIntExtra("numberToFinishGame", 5);
        scorePlayer1 = intent.getIntExtra("scorePlayer1", 0);
        textView = findViewById(R.id.textView);
        if(numberOfPlayers == 1) {
            textView.setText("You have obtained a score of \n"+
            scorePlayer1+" / "+numberToFinishGame+"");
        } else {
            nameWinner = intent.getStringExtra("nameWinner");
            if(numberOfPlayers >= 2) {
                scorePlayer2 = intent.getIntExtra("scorePlayer2", 0);
                namePlayer1 = intent.getStringExtra("namePlayer1");
                namePlayer2 = intent.getStringExtra("namePlayer2");
                textView.setText("The WINNER is : \n"+
                        nameWinner+"\n All the scores are the following: \n"+
                        namePlayer1+" has a score of "+scorePlayer1+" \n"+
                        namePlayer2+" has a score of "+scorePlayer2+" \n");
            }
            if(numberOfPlayers >= 3) {
                scorePlayer3 = intent.getIntExtra("scorePlayer3", 0);
                namePlayer3 = intent.getStringExtra("namePlayer3");
                textView.setText("The WINNER is : \n"+
                        nameWinner+"\n All the scores are the following: \n"+
                        namePlayer1+" has a score of "+scorePlayer1+" \n"+
                        namePlayer2+" has a score of "+scorePlayer2+" \n"+
                        namePlayer3+" has a score of "+scorePlayer3+" \n");
            }
            if(numberOfPlayers == 4) {
                scorePlayer4 = intent.getIntExtra("scorePlayer4", 0);
                namePlayer4 = intent.getStringExtra("namePlayer4");
                textView.setText("The WINNER is : \n"+
                        nameWinner+"\n All the scores are the following: \n"+
                        namePlayer1+" has a score of "+scorePlayer1+" \n"+
                        namePlayer2+" has a score of "+scorePlayer2+" \n"+
                        namePlayer3+" has a score of "+scorePlayer3+" \n"+
                        namePlayer4+" has a score of "+scorePlayer4+" \n");
            }
        }
    }

    public void buttonReplay(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
