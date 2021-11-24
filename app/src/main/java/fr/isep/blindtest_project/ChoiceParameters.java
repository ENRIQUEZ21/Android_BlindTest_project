package fr.isep.blindtest_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChoiceParameters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_parameters);

    }

    public void buttonSetParameters(View view) {
        Intent intent = new Intent(this, ChoiceNamePlayers.class);
        Spinner number_of_players_spinner = (Spinner) findViewById(R.id.number_players_spinner);
        String str_number_of_players = number_of_players_spinner.getSelectedItem().toString();
        intent.putExtra("number_of_players", str_number_of_players);

        EditText editTextMinutesMusicTime = findViewById(R.id.editText_number_minutes_music);
        EditText editTextSecondsMusicTime = findViewById(R.id.editText_number_seconds_music);
        Integer str_minutes_on_each_music = Integer.parseInt(editTextMinutesMusicTime.getText().toString());
        Integer str_seconds_on_each_music = Integer.parseInt(editTextSecondsMusicTime.getText().toString());

        startActivity(intent);

    }
}