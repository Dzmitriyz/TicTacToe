package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameBoard extends AppCompatActivity {
    private final GameLogic game = new GameLogic();
    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);

        Button playAgainBTN = findViewById(R.id.play_again);
        Button homeButton = findViewById(R.id.home_button);
        TextView playerTurn = findViewById(R.id.player_display);

        playAgainBTN.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);

        String [] playeNames = getIntent().getStringArrayExtra("PLAYERS_NAMES");
        if(playeNames != null){
            playerTurn.setText(playeNames[0]+ R.string.move);
        }

        ticTacToeBoard=findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainBTN,homeButton,playerTurn,playeNames);
    }

    public void playAgainButtonClick(View view){
        ticTacToeBoard.restGame();
        ticTacToeBoard.invalidate();

    }

    public void homeButtonClick (View view){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }


}