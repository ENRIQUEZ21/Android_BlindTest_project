package fr.isep.blindtest_project;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsGameOnePlayer extends AppCompatActivity {

    int nbOfTests;
    protected RadioButton radioButtonFastTest;
    protected RadioButton radioButtonMediumTest;
    protected RadioButton radioButtonQuiteLongTest;
    protected RadioButton radioButtonVeryLongTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_game_one_player);
        ImageView imageViewNext = findViewById(R.id.image_next_settings);
        imageViewNext.setImageResource(R.drawable.ic_next_foreground);
        imageViewNext.setElevation(8f);

        radioButtonFastTest = findViewById(R.id.radioButton_five_tests);
        radioButtonMediumTest = findViewById(R.id.radioButton_ten_tests);
        radioButtonQuiteLongTest = findViewById(R.id.radioButton_fifteen_tests);
        radioButtonVeryLongTest = findViewById(R.id.radioButton_twenty_tests);

    }

    public void buttonPlayOnePlayer(View view) {
        int nbBtnsChecked = 0;
        if(radioButtonFastTest.isChecked()) {
            nbOfTests = 5;
            nbBtnsChecked++;
        }
        if(radioButtonMediumTest.isChecked()) {
            nbOfTests = 10;
            nbBtnsChecked++;
        }
        if(radioButtonQuiteLongTest.isChecked()) {
            nbOfTests = 15;
            nbBtnsChecked++;
        }
        if(radioButtonVeryLongTest.isChecked()) {
            nbOfTests = 20;
            nbBtnsChecked++;
        }
        if(nbBtnsChecked == 0) {
            Toast.makeText(SettingsGameOnePlayer.this, "You must choose a type of game", Toast.LENGTH_LONG).show();
            return;
        }
        if(nbBtnsChecked > 1) {
            Toast.makeText(SettingsGameOnePlayer.this, "Only one type of game must be chosen", Toast.LENGTH_LONG).show();
            return;
        }
        Intent  intent = new Intent(SettingsGameOnePlayer.this, PlayGame.class);
        intent.putExtra("numberToFinishGame", nbOfTests);
        intent.putExtra("numberOfPlayers", 1);
        startActivity(intent);
    }

    public void buttonCheckVeryLongGame(View view) {
        radioButtonQuiteLongTest.setChecked(false);
        radioButtonMediumTest.setChecked(false);
        radioButtonFastTest.setChecked(false);
    }

    public void buttonCheckQuiteLongGame(View view) {
        radioButtonVeryLongTest.setChecked(false);
        radioButtonMediumTest.setChecked(false);
        radioButtonFastTest.setChecked(false);
    }

    public void buttonCheckMediumGame(View view) {
        radioButtonQuiteLongTest.setChecked(false);
        radioButtonVeryLongTest.setChecked(false);
        radioButtonFastTest.setChecked(false);
    }

    public void buttonCheckFastGame(View view) {
        radioButtonQuiteLongTest.setChecked(false);
        radioButtonMediumTest.setChecked(false);
        radioButtonVeryLongTest.setChecked(false);
    }
}
