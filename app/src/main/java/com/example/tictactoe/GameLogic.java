package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {
    private int [][] gameBoard;
    private Button playAgainButton;
    private Button homeBTN;
    private TextView playerTurn;
    private String[] playerNames = {"Players 1","Players 2"};
    private int[] winType ={-1,-1,-1};
    private  int player =1;

    GameLogic(){
        gameBoard = new int[3][3];
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row,int col){
        if(gameBoard[row-1][col-1]==0){
            gameBoard[row-1][col-1]= player;
            if(player ==1){
                playerTurn.setText(playerNames[1]+ " turn");
            }else{
                playerTurn.setText(playerNames[0]+ " turn");
            }
            return  true;
        }else{
            return false;
        }
    }

    public boolean winnerCheck(){
        boolean isWinner = false;
        //horizont
        for(int r=0; r<3; r++){
            if(gameBoard[r][0]==gameBoard[r][1] && gameBoard[r][1]==gameBoard[r][2] && gameBoard[r][0]!=0){
                winType = new int[]{r,0,1};
                isWinner = true;

            }
        }
        //vertical
        for(int i=0; i<3; i++){
            if(gameBoard[0][i]==gameBoard[1][i] && gameBoard[1][i]==gameBoard[2][i] && gameBoard[0][i] != 0){
                winType = new int [] {0,i,2};
                isWinner = true;
            }
        }
        //leftDown
        if(gameBoard[0][0]==gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][2] && gameBoard[0][0] != 0){
            winType= new int []{0,2,3};

            isWinner=true;
        }
        //leftUp
        if(gameBoard[0][2]==gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][0] && gameBoard[0][2] !=0){
            winType= new int []{2,0,4};
            System.out.println(gameBoard[0][2]+" "+gameBoard[1][1]+" "+gameBoard[2][0] );
            isWinner =true;
        }

        int boardFilled = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(gameBoard[i][j] != 0){
                    boardFilled+=1;
                }
            }
        }
        if(isWinner){
            playAgainButton.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1]+" win!!!"));

            return true;
        }
        if(boardFilled==9){
            playAgainButton.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText(("draw!!!"));
            return true;
        }else {
            return false;
        }
    }

    public void restGame(){
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
        player =1 ;
        playAgainButton.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0]+ " Ходит"));
    }

    public void setPlayAgainButton(Button playAgainButton){
        this.playAgainButton = playAgainButton;
    }

    public void setHomeBTN (Button homeBTN){
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn){
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player){
        this.player = player;
    }

    public int getPlayer(){
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
