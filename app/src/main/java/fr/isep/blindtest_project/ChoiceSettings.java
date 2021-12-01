package fr.isep.blindtest_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ChoiceSettings extends AppCompatActivity {
    private String parameterOfEnd = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_settings);
        ImageView imageViewNext = findViewById(R.id.image_next_settings);
        imageViewNext.setImageResource(R.drawable.ic_next_foreground);
        imageViewNext.setElevation(8f);

    }



    public void buttonSetSettings(View view) {
        Intent intent = new Intent(this, ChoiceNamePlayers.class);
        Spinner numberOfPlayersSpinner = (Spinner) findViewById(R.id.number_players_spinner);
        String strNumberOfPlayers = numberOfPlayersSpinner.getSelectedItem().toString();
        int numberOfPlayers = Integer.parseInt(strNumberOfPlayers);
        intent.putExtra("numberOfPlayers", numberOfPlayers);

        EditText editTextMinutesMusicTime = (EditText) findViewById(R.id.editText_number_minutes_music);
        String editTextMinutesMusicTimeStr = editTextMinutesMusicTime.getText().toString();
        if(editTextMinutesMusicTimeStr.length() == 0) {
            Toast.makeText(ChoiceSettings.this, "Field minutes cannot be empty !", Toast.LENGTH_LONG).show();
            return;
        }
        int minutesMusicTime = Integer.parseInt(editTextMinutesMusicTimeStr);
        if(minutesMusicTime > 3) {
            Toast.makeText(ChoiceSettings.this, "The music cannot be played more than 3 minutes !", Toast.LENGTH_LONG).show();
            return;
        }
        intent.putExtra("minutesMusicTime", minutesMusicTime);


        EditText editTextSecondsMusicTime = (EditText) findViewById(R.id.editText_number_seconds_music);
        String editTextSecondsMusicTimeStr = editTextSecondsMusicTime.getText().toString();
        if(editTextSecondsMusicTimeStr.length() == 0) {
            Toast.makeText(ChoiceSettings.this, "Field seconds cannot be empty !", Toast.LENGTH_LONG).show();
            return;
        }
        int secondsMusicTime = Integer.parseInt(editTextSecondsMusicTimeStr);
        if(secondsMusicTime > 59) {
            Toast.makeText(ChoiceSettings.this, "It is impossible to have more than 59 seconds !", Toast.LENGTH_LONG).show();
            return;
        }
        intent.putExtra("secondsMusicTime", secondsMusicTime);

        RadioButton radioButtonNbPoints = findViewById(R.id.radioButton_points_parameter_of_end);
        RadioButton radioButtonNbMusics = findViewById(R.id.radioButton_musics_parameter_of_end);
        if(radioButtonNbPoints.isChecked()) {
            parameterOfEnd = "Number of points";
        }
        if(radioButtonNbMusics.isChecked()) {
            parameterOfEnd = "Number of musics";
        }
        if(!radioButtonNbMusics.isChecked() && !radioButtonNbPoints.isChecked()) {
            Toast.makeText(ChoiceSettings.this, "You must choose a parameter of end", Toast.LENGTH_LONG).show();
            return;
        }
        if(radioButtonNbMusics.isChecked() && radioButtonNbPoints.isChecked()) {
            Toast.makeText(ChoiceSettings.this, "Only one radio button must be checked", Toast.LENGTH_LONG).show();
            return;
        }
        intent.putExtra("parameterOfEnd", parameterOfEnd);

        Spinner numberToFinishGameSpinner = (Spinner) findViewById(R.id.number_to_finish_spinner);
        String strNumberToFinishGame = numberToFinishGameSpinner.getSelectedItem().toString();
        int numberToFinishGame = Integer.parseInt(strNumberToFinishGame);
        intent.putExtra("numberOfPlayers", numberToFinishGame);

        startActivity(intent);

    }
}