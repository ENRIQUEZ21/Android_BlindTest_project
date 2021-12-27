package fr.isep.blindtest_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGame extends AppCompatActivity {
    @Override
    public void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent = getIntent();
        ImageView imageViewNext = findViewById(R.id.image_replay);
        imageViewNext.setImageResource(R.drawable.ic_replay_foreground);
        imageViewNext.setElevation(8f);
        TextView tvPlayerName = findViewById(R.id.tv_player_name);
        String namePlayer = intent.getStringExtra("namePlayer");
        tvPlayerName.setText(namePlayer);
    }

    public void buttonReplay(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
