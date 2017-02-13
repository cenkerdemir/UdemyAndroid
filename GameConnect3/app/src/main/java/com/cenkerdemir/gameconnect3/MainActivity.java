package com.cenkerdemir.gameconnect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // 0 - yellow, 1 - red
    int activePlayer = 0;

    // 2 means unplayed
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    String[] activePlayerNameArray = {"yellow", "red"};
    boolean isTheGameActive = true;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && isTheGameActive) {
            counter.setTranslationY(-1000f);
            gameState[tappedCounter] = activePlayer;
            String activePlayerName = activePlayerNameArray[activePlayer];

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for (int[] winningPosition : winningPositions) {

                System.out.println(winningPosition[0] + " " + winningPosition[1]+ " " + winningPosition[2]);
                System.out.println(gameState[winningPosition[0]] + " " + gameState[winningPosition[1]]+ " " + gameState[winningPosition[2]]);

                if (((gameState[winningPosition[0]] == gameState[winningPosition[1]]) && (gameState[winningPosition[0]]
                        == gameState[winningPosition[2]]))
                        && gameState[winningPosition[0]] != 2) {
                    isTheGameActive = false;
                    this.presentLayoutWithMessage(activePlayerName + " has won!");
                }
                else if (isTheGameActive) {

                    boolean isGameOver = true;

                    for (int state : gameState) {
                        if (state == 2) {
                            isGameOver = false;
                        }
                    }

                    if (isGameOver) {
                        isTheGameActive = false;
                        this.presentLayoutWithMessage("It's a draw!");

                    }
                }
            }
        }
    }

    public void presentLayoutWithMessage(String text) {
        TextView winnerTextView = (TextView) findViewById(R.id.winnerMessage);
        winnerTextView.setText(text);

        LinearLayout layout = (LinearLayout) findViewById(R.id.winnerLayout);
        layout.setVisibility(View.VISIBLE);
    }

    public void playAgainClicked(View view) {
        this.resetGame();
    }

    public void resetGame() {
        isTheGameActive = true;
        activePlayer = 0;
        LinearLayout layout = (LinearLayout) findViewById(R.id.winnerLayout);
        layout.setVisibility(View.INVISIBLE);

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
