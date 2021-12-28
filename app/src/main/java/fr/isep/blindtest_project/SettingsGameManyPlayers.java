package fr.isep.blindtest_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsGameManyPlayers extends AppCompatActivity {

    protected int nbOfPlayers;
    int nbToFinishGame;
    protected String parameterOfEnd;
    protected RadioButton radioButtonNbTests;
    protected RadioButton radioButtonMaxScore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_game_many_players);
        ImageView imageViewNext = findViewById(R.id.image_next_settings);
        imageViewNext.setImageResource(R.drawable.ic_next_foreground);
        imageViewNext.setElevation(8f);

        Intent intentBefore = getIntent();
        nbOfPlayers = intentBefore.getIntExtra("nbOfPlayers", 2);

        radioButtonNbTests = findViewById(R.id.radioButton_nb_tests);
        radioButtonMaxScore = findViewById(R.id.radioButton_max_score);

        parameterOfEnd = "NBTESTS";


    }

    public void buttonCheckNbTests(View view) {
        radioButtonMaxScore.setChecked(false);
        parameterOfEnd = "NBTESTS";
    }

    public void buttonCheckMaxScore(View view) {
        radioButtonNbTests.setChecked(false);
        parameterOfEnd = "MAXSCORE";
    }


    public void buttonSetSettingsManyPlayers(View view) {
        int nbRadioChecked = 0;
        if(radioButtonNbTests.isChecked()) {
            nbRadioChecked++;
        }
        if(radioButtonMaxScore.isChecked()) {
            nbRadioChecked++;
        }
        if(nbRadioChecked == 0) {
            Toast.makeText(SettingsGameManyPlayers.this, "You must choose a type of end-of-game", Toast.LENGTH_LONG).show();
            return;
        }
        if(nbRadioChecked == 2) {
            Toast.makeText(SettingsGameManyPlayers.this, "You must choose only one condition of end-of-game", Toast.LENGTH_LONG).show();
            return;
        }
        EditText editText = findViewById(R.id.edittext_number_to_reach);
        String nbToReach = editText.getText().toString();
        if(nbToReach.length() == 0) {
            Toast.makeText(SettingsGameManyPlayers.this, "Field number to reach cannot be empty !", Toast.LENGTH_LONG).show();
            return;
        }
        nbToFinishGame = Integer.parseInt(nbToReach);
        if(nbToFinishGame < 5 || nbToFinishGame > 50) {
            Toast.makeText(SettingsGameManyPlayers.this, "Number to reach must be between 5 and 50 !", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(SettingsGameManyPlayers.this, ChoiceNamePlayers.class);
        intent.putExtra("numberOfPlayers", nbOfPlayers);
        intent.putExtra("nbToFinishGame", nbToFinishGame);
        intent.putExtra("parameterOfEnd", parameterOfEnd);
        startActivity(intent);

    }
}
