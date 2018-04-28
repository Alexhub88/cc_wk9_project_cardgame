package com.example.alexs.highlowandroid.HighLow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alexs.highlowandroid.R;

import java.util.ArrayList;

public class HighLowActivity extends AppCompatActivity {

    private TextView instructions;
    private Button playButton;
    private TextView result;

    private Deck deck;
    private Hand hand1;
    private Hand hand2;
    private Player player1;
    private Player player2;
    private Player winner;
    private String displayGameResult;
    private String winnerName;
    private ArrayList<Player> playerList;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_low);

        instructions = findViewById(R.id.instructionsTextViewID);
        playButton = findViewById(R.id.playButtonID);

        deck = new Deck();
        hand1 = new Hand();
        hand2 = new Hand();
        player1 = new Player("Alice", hand1);
        player2 = new Player("Bob", hand2);
        playerList = new ArrayList<Player>();
        playerList.add(player1);
        playerList.add(player2);
        game = new Game(deck, playerList);
    }

    public void onPlayButtonClick(View view) {

        game.deal();
        winner = game.checkWinner();

        if(winner == player1) {
            winnerName = "Player 1";
        } else {
            winnerName = "Player 2";
        }

        displayGameResult = "Player 1: " + player1.getHand().getCards().get(0).prettyName()
                + ", " + player1.getHand().getCards().get(1).prettyName()
                + "\n\n" + "Player 2: " + player2.getHand().getCards().get(0).prettyName()
                + ", " + player2.getHand().getCards().get(1).prettyName()
                + "\n\n\n" + winnerName.toUpperCase() + " WINS!!";

        Intent intent = new Intent(this, GameResultActivity.class);
        intent.putExtra("displayGameResult", displayGameResult);
        startActivity(intent);

    }
}
