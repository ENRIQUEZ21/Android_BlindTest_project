package fr.isep.blindtest_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChoiceNamePlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_name_players);

        ImageView imagePlayGame = findViewById(R.id.image_play_game);
        imagePlayGame.setImageResource(R.drawable.ic_next_foreground);
        imagePlayGame.setElevation(8f);


        Intent intent = getIntent();
        int numberOfPlayers = intent.getIntExtra("numberOfPlayers", 0);

        if(numberOfPlayers == 1) {
            LinearLayout linearLayout2 = findViewById(R.id.linear_player_2);
            linearLayout2.setVisibility(View.INVISIBLE);
            LinearLayout linearLayout3 = findViewById(R.id.linear_player_3);
            linearLayout3.setVisibility(View.INVISIBLE);
            LinearLayout linearLayout4 = findViewById(R.id.linear_player_4);
            linearLayout4.setVisibility(View.INVISIBLE);
        } else if(numberOfPlayers == 2) {
            LinearLayout linearLayout3 = findViewById(R.id.linear_player_3);
            linearLayout3.setVisibility(View.INVISIBLE);
            LinearLayout linearLayout4 = findViewById(R.id.linear_player_4);
            linearLayout4.setVisibility(View.INVISIBLE);
        } else if(numberOfPlayers == 3) {
            LinearLayout linearLayout4 = findViewById(R.id.linear_player_4);
            linearLayout4.setVisibility(View.INVISIBLE);
        }
    }

    public void buttonToPlay(View view) {
        Intent intentBefore = getIntent();
        int numberOfPlayers = intentBefore.getIntExtra("numberOfPlayers", 0);

        Intent intent = new Intent(this, PlayGame.class);

        intent.putExtra("numberOfPlayers", numberOfPlayers);
        intent.putExtra("minutesMusicTime", intentBefore.getIntExtra("minutesMusicTime", 0));
        intent.putExtra("secondsMusicTime", intentBefore.getIntExtra("secondsMusicTime", 0));
        intent.putExtra("parameterOfEnd", intentBefore.getStringExtra("parameterOfEnd"));
        intent.putExtra("numberToFinishGame", intentBefore.getIntExtra("numberToFinishGame", 0));
        if(numberOfPlayers == 1) {
            String namePlayer1 = findViewById(R.id.tv_name_of_player_1).toString();
            intent.putExtra("namePlayer1", namePlayer1);
        } else if(numberOfPlayers == 2) {
            String namePlayer1 = findViewById(R.id.tv_name_of_player_1).toString();
            intent.putExtra("namePlayer1", namePlayer1);
            String namePlayer2 = findViewById(R.id.tv_name_of_player_2).toString();
            intent.putExtra("namePlayer2", namePlayer2);
        } else if(numberOfPlayers == 3) {
            String namePlayer1 = findViewById(R.id.tv_name_of_player_1).toString();
            intent.putExtra("namePlayer1", namePlayer1);
            String namePlayer2 = findViewById(R.id.tv_name_of_player_2).toString();
            intent.putExtra("namePlayer2", namePlayer2);
            String namePlayer3 = findViewById(R.id.tv_name_of_player_3).toString();
            intent.putExtra("namePlayer3", namePlayer3);
        } else {
            String namePlayer1 = findViewById(R.id.tv_name_of_player_1).toString();
            intent.putExtra("namePlayer1", namePlayer1);
            String namePlayer2 = findViewById(R.id.tv_name_of_player_2).toString();
            intent.putExtra("namePlayer2", namePlayer2);
            String namePlayer3 = findViewById(R.id.tv_name_of_player_3).toString();
            intent.putExtra("namePlayer3", namePlayer3);
            String namePlayer4 = findViewById(R.id.tv_name_of_player_4).toString();
            intent.putExtra("namePlayer4", namePlayer4);
        }

        startActivity(intent);
    }
}