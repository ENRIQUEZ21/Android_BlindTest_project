package fr.isep.blindtest_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
            EditText editTextPlayer1 = findViewById(R.id.edittext_name_of_player_1);
            String namePlayer1 = editTextPlayer1.getText().toString();
            namePlayer1 = namePlayer1.trim();
            if(namePlayer1.equals("")) {
                Toast.makeText(ChoiceNamePlayers.this, "You must choose a name for the player 1", Toast.LENGTH_LONG).show();
                return;
            }
            intent.putExtra("namePlayer1", namePlayer1);
        } else if(numberOfPlayers == 2) {
            EditText editTextPlayer1 = findViewById(R.id.edittext_name_of_player_1);
            EditText editTextPlayer2 = findViewById(R.id.edittext_name_of_player_2);
            String namePlayer1 = editTextPlayer1.getText().toString();
            namePlayer1 = namePlayer1.trim();
            String namePlayer2 = editTextPlayer2.getText().toString();
            namePlayer2 = namePlayer2.trim();
            if(namePlayer1.equals("") || namePlayer2.equals("")) {
                Toast.makeText(ChoiceNamePlayers.this, "You must choose a name for all the players", Toast.LENGTH_LONG).show();
                return;
            }
            if(namePlayer1.equals(namePlayer2)) {
                Toast.makeText(ChoiceNamePlayers.this, "You cannot choose the same name for the two players", Toast.LENGTH_LONG).show();
                return;
            }
            intent.putExtra("namePlayer1", namePlayer1);
            intent.putExtra("namePlayer2", namePlayer2);
        } else if(numberOfPlayers == 3) {
            EditText editTextPlayer1 = findViewById(R.id.edittext_name_of_player_1);
            TextView editTextPlayer2 = findViewById(R.id.edittext_name_of_player_2);
            TextView editTextPlayer3 = findViewById(R.id.edittext_name_of_player_3);
            String namePlayer1 = editTextPlayer1.getText().toString();
            namePlayer1 = namePlayer1.trim();
            String namePlayer2 = editTextPlayer2.getText().toString();
            namePlayer2 = namePlayer2.trim();
            String namePlayer3 = editTextPlayer3.getText().toString();
            namePlayer3 = namePlayer3.trim();
            if(namePlayer1.equals("") || namePlayer2.equals("") || namePlayer3.equals("")) {
                Toast.makeText(ChoiceNamePlayers.this, "You must choose a name for all the players", Toast.LENGTH_LONG).show();
                return;
            }
            if(namePlayer1.equals(namePlayer2) || namePlayer1.equals(namePlayer3) || namePlayer2.equals(namePlayer3)) {
                Toast.makeText(ChoiceNamePlayers.this, "You cannot choose the same name for the two different players", Toast.LENGTH_LONG).show();
                return;
            }
            intent.putExtra("namePlayer1", namePlayer1);
            intent.putExtra("namePlayer2", namePlayer2);
            intent.putExtra("namePlayer3", namePlayer3);
        } else {
            EditText editTextPlayer1 = findViewById(R.id.edittext_name_of_player_1);
            EditText editTextPlayer2 = findViewById(R.id.edittext_name_of_player_2);
            EditText editTextPlayer3 = findViewById(R.id.edittext_name_of_player_3);
            EditText editTextPlayer4 = findViewById(R.id.edittext_name_of_player_4);
            String namePlayer1 = editTextPlayer1.getText().toString();
            namePlayer1 = namePlayer1.trim();
            String namePlayer2 = editTextPlayer2.getText().toString();
            namePlayer2 = namePlayer2.trim();
            String namePlayer3 = editTextPlayer3.getText().toString();
            namePlayer3 = namePlayer3.trim();
            String namePlayer4 = editTextPlayer4.getText().toString();
            namePlayer4 = namePlayer4.trim();
            if(namePlayer1.equals("") || namePlayer2.equals("") || namePlayer3.equals("") || namePlayer4.equals("")) {
                Toast.makeText(ChoiceNamePlayers.this, "You must choose a name for all the players", Toast.LENGTH_LONG).show();
                return;
            }
            if(namePlayer1.equals(namePlayer2) || namePlayer1.equals(namePlayer3) || namePlayer2.equals(namePlayer3)
            || namePlayer1.equals(namePlayer4) || namePlayer2.equals(namePlayer4) || namePlayer3.equals(namePlayer4)) {
                Toast.makeText(ChoiceNamePlayers.this, "You cannot choose the same name for the two different players", Toast.LENGTH_LONG).show();
                return;
            }
            intent.putExtra("namePlayer1", namePlayer1);
            intent.putExtra("namePlayer2", namePlayer2);
            intent.putExtra("namePlayer3", namePlayer3);
            intent.putExtra("namePlayer4", namePlayer4);
        }

        startActivity(intent);
    }
}