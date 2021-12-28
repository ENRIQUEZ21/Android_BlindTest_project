package fr.isep.blindtest_project;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class ChooseWinner extends AppCompatActivity {
    protected int numberOfPlayers;
    protected String namePlayer1;
    protected String namePlayer2;
    protected String namePlayer3;
    protected String namePlayer4;
    protected String paramaterOfEnd;
    protected int numberToFinishGame;
    protected int scorePlayer1;
    protected int scorePlayer2;
    protected int scorePlayer3;
    protected int scorePlayer4;

    protected int nbOfTestsDone;
    protected ArrayList<Integer> scoresArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentBefore = getIntent();

        scoresArrayList = new ArrayList<>();

        nbOfTestsDone = intentBefore.getIntExtra("nbOfTestsDone", 0);

        numberOfPlayers = intentBefore.getIntExtra("numberOfPlayers", 1);
        namePlayer1 = intentBefore.getStringExtra("namePlayer1");
        namePlayer2 = intentBefore.getStringExtra("namePlayer2");
        namePlayer3 = intentBefore.getStringExtra("namePlayer3");
        namePlayer4 = intentBefore.getStringExtra("namePlayer4");
        paramaterOfEnd = intentBefore.getStringExtra("parameterOfEnd");
        numberToFinishGame = intentBefore.getIntExtra("numberToFinishGame", 0);
        scorePlayer1 = intentBefore.getIntExtra("scorePlayer1", 0);
        scorePlayer2 = intentBefore.getIntExtra("scorePlayer2", 0);
        scorePlayer3 = intentBefore.getIntExtra("scorePlayer3", 0);
        scorePlayer4 = intentBefore.getIntExtra("scorePlayer4", 0);

        if(numberOfPlayers == 1) {
            scorePlayer1++;
            if(nbOfTestsDone == numberToFinishGame) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberToFinishGame", numberToFinishGame);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                intent.putExtra("scorePlayer1", scorePlayer1);
                startActivity(intent);
                finish();
                return;
            }
            returnToPlayGame();
        } else {
            setContentView(R.layout.activity_player_found);
            Button btnPlayer1 = findViewById(R.id.btn_player_1);
            Button btnPlayer2 = findViewById(R.id.btn_player_2);
            Button btnPlayer3 = findViewById(R.id.btn_player_3);
            Button btnPlayer4 = findViewById(R.id.btn_player_4);
            if(numberOfPlayers >= 2) {
                btnPlayer1.setVisibility(View.VISIBLE);
                btnPlayer1.setText(namePlayer1);
                btnPlayer2.setVisibility(View.VISIBLE);
                btnPlayer2.setText(namePlayer2);
                scoresArrayList.add(scorePlayer1);
                scoresArrayList.add(scorePlayer2);
            }
            if(numberOfPlayers >= 3) {
                btnPlayer3.setVisibility(View.VISIBLE);
                btnPlayer3.setText(namePlayer3);
                scoresArrayList.add(scorePlayer3);
            }
            if(numberOfPlayers == 4) {
                btnPlayer4.setVisibility(View.VISIBLE);
                btnPlayer4.setText(namePlayer4);
                scoresArrayList.add(scorePlayer4);
            }
        }
    }

    public void buttonPlayer1Found(View view) {
        scorePlayer1++;
        if(paramaterOfEnd.equals("MAXSCORE")) {
            if(numberToFinishGame == scorePlayer1) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                intent.putExtra("nameWinner", namePlayer1);
                if(numberOfPlayers >= 2) {
                    intent.putExtra("scorePlayer1", scorePlayer1);
                    intent.putExtra("scorePlayer2", scorePlayer2);
                    intent.putExtra("namePlayer1", namePlayer1);
                    intent.putExtra("namePlayer2", namePlayer2);
                }
                if(numberOfPlayers >= 3) {
                    intent.putExtra("scorePlayer3", scorePlayer3);
                    intent.putExtra("namePlayer3", namePlayer3);
                }
                if(numberOfPlayers == 4) {
                    intent.putExtra("scorePlayer4", scorePlayer4);
                    intent.putExtra("namePlayer4", namePlayer4);
                }
                startActivity(intent);
                finish();
                return;
            }
        } else {
            if(nbOfTestsDone == numberToFinishGame) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                scoresArrayList.set(0, scorePlayer1);
                Collections.sort(scoresArrayList);
                Collections.reverse(scoresArrayList);
                if(!scoresArrayList.get(0).equals(scoresArrayList.get(1))) {
                    if (scoresArrayList.get(0).equals(scorePlayer1)) {
                        intent.putExtra("nameWinner", namePlayer1);
                    } else if (scoresArrayList.get(0).equals(scorePlayer2)) {
                        intent.putExtra("nameWinner", namePlayer2);
                    } else if (scoresArrayList.get(0).equals(scorePlayer3)) {
                        intent.putExtra("nameWinner", namePlayer3);
                    } else {
                        intent.putExtra("nameWinner", namePlayer4);
                    }
                } else {
                    intent.putExtra("nameWinner", "NO WINNER");
                }

                if(numberOfPlayers >= 2) {
                    intent.putExtra("scorePlayer1", scorePlayer1);
                    intent.putExtra("scorePlayer2", scorePlayer2);
                    intent.putExtra("namePlayer1", namePlayer1);
                    intent.putExtra("namePlayer2", namePlayer2);
                }
                if(numberOfPlayers >= 3) {
                    intent.putExtra("scorePlayer3", scorePlayer3);
                    intent.putExtra("namePlayer3", namePlayer3);
                }
                if(numberOfPlayers == 4) {
                    intent.putExtra("scorePlayer4", scorePlayer4);
                    intent.putExtra("namePlayer4", namePlayer4);
                }
                startActivity(intent);
                finish();
                return;
            }
        }
        returnToPlayGame();
    }

    public void buttonPlayer2Found(View view) {
        scorePlayer2++;
        if(paramaterOfEnd.equals("MAXSCORE")) {
            if(numberToFinishGame == scorePlayer2) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                intent.putExtra("nameWinner", namePlayer2);
                if(numberOfPlayers >= 2) {
                    intent.putExtra("scorePlayer1", scorePlayer1);
                    intent.putExtra("scorePlayer2", scorePlayer2);
                    intent.putExtra("namePlayer1", namePlayer1);
                    intent.putExtra("namePlayer2", namePlayer2);
                }
                if(numberOfPlayers >= 3) {
                    intent.putExtra("scorePlayer3", scorePlayer3);
                    intent.putExtra("namePlayer3", namePlayer3);
                }
                if(numberOfPlayers == 4) {
                    intent.putExtra("scorePlayer4", scorePlayer4);
                    intent.putExtra("namePlayer4", namePlayer4);
                }
                startActivity(intent);
                finish();
                return;
            }
        } else {
            if(nbOfTestsDone == numberToFinishGame) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                scoresArrayList.set(1, scorePlayer2);
                Collections.sort(scoresArrayList);
                Collections.reverse(scoresArrayList);
                if(!scoresArrayList.get(0).equals(scoresArrayList.get(1))) {
                    if (scoresArrayList.get(0).equals(scorePlayer1)) {
                        intent.putExtra("nameWinner", namePlayer1);
                    } else if (scoresArrayList.get(0).equals(scorePlayer2)) {
                        intent.putExtra("nameWinner", namePlayer2);
                    } else if (scoresArrayList.get(0).equals(scorePlayer3)) {
                        intent.putExtra("nameWinner", namePlayer3);
                    } else {
                        intent.putExtra("nameWinner", namePlayer4);
                    }
                } else {
                    intent.putExtra("nameWinner", "NO WINNER");
                }

                if(numberOfPlayers >= 2) {
                    intent.putExtra("scorePlayer1", scorePlayer1);
                    intent.putExtra("scorePlayer2", scorePlayer2);
                    intent.putExtra("namePlayer1", namePlayer1);
                    intent.putExtra("namePlayer2", namePlayer2);
                }
                if(numberOfPlayers >= 3) {
                    intent.putExtra("scorePlayer3", scorePlayer3);
                    intent.putExtra("namePlayer3", namePlayer3);
                }
                if(numberOfPlayers == 4) {
                    intent.putExtra("scorePlayer4", scorePlayer4);
                    intent.putExtra("namePlayer4", namePlayer4);
                }
                startActivity(intent);
                finish();
                return;
            }
        }
        returnToPlayGame();
    }

    public void buttonPlayer3Found(View view) {
        scorePlayer3++;
        if(paramaterOfEnd.equals("MAXSCORE")) {
            if(numberToFinishGame == scorePlayer3) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                intent.putExtra("nameWinner", namePlayer3);
                if(numberOfPlayers >= 2) {
                    intent.putExtra("scorePlayer1", scorePlayer1);
                    intent.putExtra("scorePlayer2", scorePlayer2);
                    intent.putExtra("namePlayer1", namePlayer1);
                    intent.putExtra("namePlayer2", namePlayer2);
                }
                if(numberOfPlayers >= 3) {
                    intent.putExtra("scorePlayer3", scorePlayer3);
                    intent.putExtra("namePlayer3", namePlayer3);
                }
                if(numberOfPlayers == 4) {
                    intent.putExtra("scorePlayer4", scorePlayer4);
                    intent.putExtra("namePlayer4", namePlayer4);
                }
                startActivity(intent);
                finish();
                return;
            }
        } else {
            if(nbOfTestsDone == numberToFinishGame) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                scoresArrayList.set(2, scorePlayer3);
                Collections.sort(scoresArrayList);
                Collections.reverse(scoresArrayList);
                if(!scoresArrayList.get(0).equals(scoresArrayList.get(1))) {
                    if(scoresArrayList.get(0).equals(scorePlayer1)) {
                        intent.putExtra("nameWinner", namePlayer1);
                    } else if(scoresArrayList.get(0).equals(scorePlayer2)) {
                        intent.putExtra("nameWinner", namePlayer2);
                    } else if(scoresArrayList.get(0).equals(scorePlayer3)) {
                        intent.putExtra("nameWinner", namePlayer3);
                    } else {
                        intent.putExtra("nameWinner", namePlayer4);
                    }
                } else {
                    intent.putExtra("nameWinner", "NO WINNER");
                }


                if(numberOfPlayers >= 2) {
                    intent.putExtra("scorePlayer1", scorePlayer1);
                    intent.putExtra("scorePlayer2", scorePlayer2);
                    intent.putExtra("namePlayer1", namePlayer1);
                    intent.putExtra("namePlayer2", namePlayer2);
                }
                if(numberOfPlayers >= 3) {
                    intent.putExtra("scorePlayer3", scorePlayer3);
                    intent.putExtra("namePlayer3", namePlayer3);
                }
                if(numberOfPlayers == 4) {
                    intent.putExtra("scorePlayer4", scorePlayer4);
                    intent.putExtra("namePlayer4", namePlayer4);
                }
                startActivity(intent);
                finish();
                return;
            }
        }
        returnToPlayGame();
    }

    public void buttonPlayer4Found(View view) {
        scorePlayer4++;
        if(paramaterOfEnd.equals("MAXSCORE")) {
            if(numberToFinishGame == scorePlayer4) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                intent.putExtra("nameWinner", namePlayer4);
                if(numberOfPlayers >= 2) {
                    intent.putExtra("scorePlayer1", scorePlayer1);
                    intent.putExtra("scorePlayer2", scorePlayer2);
                    intent.putExtra("namePlayer1", namePlayer1);
                    intent.putExtra("namePlayer2", namePlayer2);
                }
                if(numberOfPlayers >= 3) {
                    intent.putExtra("scorePlayer3", scorePlayer3);
                    intent.putExtra("namePlayer3", namePlayer3);
                }
                if(numberOfPlayers == 4) {
                    intent.putExtra("scorePlayer4", scorePlayer4);
                    intent.putExtra("namePlayer4", namePlayer4);
                }
                startActivity(intent);
                finish();
                return;
            }
        } else {
            if(nbOfTestsDone == numberToFinishGame) {
                Intent intent = new Intent(this, EndGame.class);
                intent.putExtra("numberOfPlayers", numberOfPlayers);
                scoresArrayList.set(3, scorePlayer4);
                Collections.sort(scoresArrayList);
                Collections.reverse(scoresArrayList);
                if(!scoresArrayList.get(0).equals(scoresArrayList.get(1))) {
                    if (scoresArrayList.get(0).equals(scorePlayer1)) {
                        intent.putExtra("nameWinner", namePlayer1);
                    } else if (scoresArrayList.get(0).equals(scorePlayer2)) {
                        intent.putExtra("nameWinner", namePlayer2);
                    } else if (scoresArrayList.get(0).equals(scorePlayer3)) {
                        intent.putExtra("nameWinner", namePlayer3);
                    } else {
                        intent.putExtra("nameWinner", namePlayer4);
                    }
                } else {
                    intent.putExtra("nameWinner", "NO WINNER");
                }

                if(numberOfPlayers >= 2) {
                    intent.putExtra("scorePlayer1", scorePlayer1);
                    intent.putExtra("scorePlayer2", scorePlayer2);
                    intent.putExtra("namePlayer1", namePlayer1);
                    intent.putExtra("namePlayer2", namePlayer2);
                }
                if(numberOfPlayers >= 3) {
                    intent.putExtra("scorePlayer3", scorePlayer3);
                    intent.putExtra("namePlayer3", namePlayer3);
                }
                if(numberOfPlayers == 4) {
                    intent.putExtra("scorePlayer4", scorePlayer4);
                    intent.putExtra("namePlayer4", namePlayer4);
                }
                startActivity(intent);
                finish();
                return;
            }
        }
        returnToPlayGame();
    }

    public void returnToPlayGame() {
        Intent intent = new Intent(this, PlayGame.class);

        intent.putExtra("nbOfTestsDone", nbOfTestsDone);

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
        startActivity(intent);
        finish();
    }
}
