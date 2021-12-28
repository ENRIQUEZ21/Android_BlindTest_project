package fr.isep.blindtest_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChoiceNumberPlayers extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_number_players);
        ImageView imageViewNext = findViewById(R.id.image_next_settings);
        imageViewNext.setImageResource(R.drawable.ic_next_foreground);
        imageViewNext.setElevation(8f);

    }


    public void buttonSetNumberOfPlayers(View view) {
        EditText editText = (EditText) findViewById(R.id.nb_players);
        String nbOfPlayers = editText.getText().toString();
        if(nbOfPlayers.length() == 0) {
            Toast.makeText(ChoiceNumberPlayers.this, "Field number of players cannot be empty !", Toast.LENGTH_LONG).show();
            return;
        }
        int numberOfPlayers = Integer.parseInt(nbOfPlayers);
        if(numberOfPlayers <= 0 || numberOfPlayers > 4) {
            Toast.makeText(ChoiceNumberPlayers.this, "Number of players must be between 1 and 4", Toast.LENGTH_LONG).show();
            return;
        }
        if(numberOfPlayers == 1) {
            Intent intent = new Intent(ChoiceNumberPlayers.this, SettingsGameOnePlayer.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(ChoiceNumberPlayers.this, SettingsGameManyPlayers.class);
            intent.putExtra("nbOfPlayers", numberOfPlayers);
            startActivity(intent);
        }

    }
}
