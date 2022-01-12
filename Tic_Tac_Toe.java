package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

     public int P1 = 0;

     public int P2 = 0;

     public int empty = 0;

     public int activePlayer = 0;

     public String player = "";

     public boolean gameactive = false;

     public int[] gamestate = {2,2,2,2,2,2,2,2,2};

     public int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6} ,{1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

     public ImageView counter;

     public TextView title;


    public void dropin(View view) {

        TextView scorep1 = (TextView) findViewById(R.id.textView5);

        TextView scorep2 = (TextView) findViewById(R.id.textView7);

        title = (TextView) findViewById(R.id.textView3);

        counter = (ImageView) view;

        counter.setTranslationY(-1500);

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        counter.animate().translationYBy(1500).setDuration(300);

        if (gamestate[tappedCounter] == 2 && gameactive == true) {

            gamestate[tappedCounter] = activePlayer;

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.x);
                activePlayer = 1;
                if (activePlayer == 1) {
                    title.setText("Player 2 is choosing");
                }
            } else if (activePlayer == 1) {
                counter.setImageResource(R.drawable.o);
                activePlayer = 0;
                if (activePlayer == 0) {
                    title.setText("Player 1 is choosing");
                }
            }

            for (int[] winningPositions : winningPositions) {
                //goes int o {0 , 1 , 2}
                if (gamestate[winningPositions[0]] == gamestate[winningPositions[1]] && gamestate[winningPositions[1]] == gamestate[winningPositions[2]] && gamestate[winningPositions[0]] != 2) {

                    gameactive = false;

                    if (activePlayer == 1) {
                        player = "Player 1";
                        P1++;
                        scorep1.setText(Integer.toString(P1));
                    } else if (activePlayer == 0) {
                        player = "Player 2";
                        P2++;
                        scorep2.setText(Integer.toString(P2));
                    }

                    Button playAgain = (Button) findViewById(R.id.button);

                    playAgain.setVisibility((View.VISIBLE));

                    Toast.makeText(this, player + " won", Toast.LENGTH_SHORT).show();

                }
            }
        }
        for (int i = 0; i < gamestate.length; i++) {
            if (gamestate[i] == 2) {
                empty++;
            }
        }
        if (empty == 0) {
            Tie();
        }
        empty = 0;
    }

    public void Tie(){
        Toast.makeText(this, "It was a Tie", Toast.LENGTH_SHORT).show();
        Button playAgain = (Button) findViewById(R.id.button);

        playAgain.setVisibility((View.INVISIBLE));

        androidx.gridlayout.widget.GridLayout layer=(androidx.gridlayout.widget.GridLayout)findViewById(R.id.layout);

        for(int i =0; i<layer.getChildCount(); i++) {

            ImageView counter = (ImageView)layer.getChildAt(i);

            counter.setImageDrawable(null);
        }

        for(int i=0; i<gamestate.length; i++){
            gamestate[i] = 2;
        }

        activePlayer = 0;

        gameactive = true;

        if(activePlayer == 0) {
            title.setText("Player 1 is choosing");
        }
        if(activePlayer == 1) {
            title.setText("Player 2 is choosing");
        }
    }

    public void playagain(View view){

        Button playAgain = (Button) findViewById(R.id.button);

        playAgain.setVisibility((View.INVISIBLE));

        androidx.gridlayout.widget.GridLayout layer=(androidx.gridlayout.widget.GridLayout)findViewById(R.id.layout);

        for(int i =0; i<layer.getChildCount(); i++) {

            ImageView counter = (ImageView)layer.getChildAt(i);

            counter.setImageDrawable(null);
        }

        for(int i=0; i<gamestate.length; i++){
            gamestate[i] = 2;
        }

       activePlayer = 0;

       gameactive = true;

        if(activePlayer == 0) {
            title.setText("Player 1 is choosing");
        }
        if(activePlayer == 1) {
            title.setText("Player 2 is choosing");
        }
    }

    public void startingame(View view){
        gameactive = true;

        Button start = (Button) findViewById(R.id.button2);

        start.setVisibility(View.INVISIBLE);

        TextView title = (TextView)findViewById(R.id.textView3);

        if(activePlayer == 0) {
            title.setText("Player 1 is choosing");
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
