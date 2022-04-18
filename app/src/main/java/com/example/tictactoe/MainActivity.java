package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //4. Player 0 vs Player 1
    int activePlayer = 0;

    //2. State of the game
    int [] gameState = {2,2,2,2,2,2,2,2,2};

    //---------------------------GAME LOGIC-------------------------------------
    int [][] winningCombo = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    boolean inGame = true;

    public void dropIn(View view){

        //1. get the tag of the image view

        //2. State of the game


       //3. Animate the movement of playerX
        //4. Player 0 vs Player 1
        //5. Alternate


        //------------------------start of GAME LOGIC-------------------------------------
        for(int[] winningPos: winningCombo){
            if(gameState[winningPos[0]] == gameState[winningPos[1]]
                    && gameState[winningPos[1]] == gameState[winningPos[2]]
                    && gameState[winningPos[0]]!=2){
                System.out.println("Won!");
                inGame = false;
                int playerNo = 2;
                if(gameState[winningPos[0]]==0){
                    playerNo = 1;
                }
                //-----------------------end of GAME LOGIC-------------------------------------

                //6. Once game is won, make the layout visible

                //6.1. Set winning text

                //6.2. Set layout to visible


            }else{
                boolean isOver = true;
                for(int counterState: gameState){
                    if(counterState == 2){
                        isOver = false;
                    }
                }
                if(isOver){
                    TextView winningMessage = (TextView) findViewById(R.id.diplayWinningText);
                    winningMessage.setText("Draw!");

                    //6.2. Set layout to visible

                    LinearLayout layout = (LinearLayout) findViewById(R.id.atWin);
                    layout.setVisibility(View.VISIBLE);
                }
            }
        }

    }



    public void playAgain(View view){
        /*
        To restart:
        1. Make the hiddenLayout disappear again
        2. Remove all the images from ImageView
        3. Reset gameState
         */

        LinearLayout winningLayout = (LinearLayout) findViewById(R.id.atWin);
        winningLayout.setVisibility(View.INVISIBLE);

        activePlayer = 0;
        inGame = true;

        for(int i = 0;i< gameState.length;i++){
            gameState[i] = 2;
        }

        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0;i<grid.getChildCount();i++){
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}