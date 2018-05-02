package com.example.alexs.compendium.HighLow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alexs.compendium.R;

import java.util.ArrayList;

public class HighLowGameActivity extends AppCompatActivity {

    private TextView instructions;
    private Button playButton;
    private TextView result;

    private Deck deck;
    private Hand hand1;
    private Hand hand2;
    private Player player1;
    private Player player2;
    private Player winner;
    private String player1Result;
    private String player2Result;
    private String displayWinner;
    private String winnerName;
    private String player1Card1;
    private String player1Card2;
    private String player2Card1;
    private String player2Card2;
    private ArrayList<Player> playerList;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_low_game);

        instructions = findViewById(R.id.instructionsTextViewID);
        playButton = findViewById(R.id.playButtonID);

        deck = new Deck();
        hand1 = new Hand();
        hand2 = new Hand();
        player1 = new Player("Alice", hand1);
        player2 = new Player("Bob", hand2);
        playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        game = new Game(deck, playerList);
    }

    public void onPlayButtonClick(View view) {

        game.deal();
        winner = game.checkWinner();

        if(winner == player1) {
            winnerName = "Player 1";
        } else if (winner == player2){
            winnerName = "Player 2";
        } else {
            winnerName = "Draw!";
        }

        player1Card1 = player1.getHand().getCards().get(0).getImageFileName();
        player1Card2 = player1.getHand().getCards().get(1).getImageFileName();
        player2Card1 = player2.getHand().getCards().get(0).getImageFileName();
        player2Card2 = player2.getHand().getCards().get(1).getImageFileName();

        player1Result = "Player 1" + "\n" + player1.getHand().getCards().get(0).prettyName()
                + ", " + player1.getHand().getCards().get(1).prettyName() + "\n" + "Score: " + player1.getHand().getHandValue();

        player2Result = "Player 2" + "\n" + player2.getHand().getCards().get(0).prettyName()
                + ", " + player2.getHand().getCards().get(1).prettyName()+ "\n" + "Score: " + player2.getHand().getHandValue();

        displayWinner = winnerName.toUpperCase() + " WINS!!";

        Intent intent = new Intent(this, HighLowResultActivity.class);
        intent.putExtra("player1Card1", player1Card1);
        intent.putExtra("player1Card2", player1Card2);
        intent.putExtra("player2Card1", player2Card1);
        intent.putExtra("player2Card2", player2Card2);
        intent.putExtra("player1Result", player1Result);
        intent.putExtra("player2Result", player2Result);
        intent.putExtra("displayWinner", displayWinner);
        startActivity(intent);

    }
}
