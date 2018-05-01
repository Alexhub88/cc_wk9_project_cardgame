package com.example.alexs.compendium.Blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.alexs.compendium.HighLow.Deck;
import com.example.alexs.compendium.HighLow.Hand;

import com.example.alexs.compendium.R;


import java.util.ArrayList;

public class BlackjackGameActivity extends AppCompatActivity {

    private TextView dealerTextView;
    private TextView dealerScoreView;
    private TextView dealerScoreTitle;

    private TextView playerTextView;
    private TextView playerScoreView;
    private TextView playerScoreTitle;

    private TextView winnerTextView;
    private TextView winnerResultView;

    private Button playerStandButton;
    private Button playerHitButton;

    private Deck deck;
    private Hand dealerHand;
    private Hand playerHand;
    private Player dealer;
    private Player player;
    private Game game;
    private ArrayList<Player> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_game);

        dealerScoreView = findViewById(R.id.dealerScoreViewID);
        playerTextView = findViewById(R.id.playerTextViewID);
        playerScoreView = findViewById(R.id.playerScoreViewID);
        winnerResultView = findViewById(R.id.winnerResultViewID);
        playerStandButton = findViewById(R.id.playerStandButtonID);
        playerHitButton = findViewById(R.id.playerHitButtonID);

        deck = new Deck();
        dealerHand = new Hand();
        playerHand = new Hand();
        player = new Player("Player 1", playerHand, true);
        dealer = new Player("Dealer", dealerHand, true);
        playerList = new ArrayList<>();
        playerList.add(player);
        playerList.add(dealer);
        game = new Game(deck, playerList);
        game.deal();

        playerScoreView.setText("PLAYER 1 SCORE: " + game.getPlayerAtPosition(0).getHandValue());
    }

    public void onActionButtonClick(View view) {
        switch (view.getId()) {
            case R.id.playerHitButtonID:
                Log.d("Blackjack", "Player Hits");
                play(Action.HIT);
                if (!game.getPlayerAtPosition(0).getIsPlayerActive()) {
                    dealerPlays();
                }
                break;
            case R.id.playerStandButtonID:
                Log.d("Blackjack", "Player Stands");
                play(Action.STAND);
                dealerPlays();
                break;
        }
    }

    public void play(Action playerAction) {

        if (playerAction == Action.HIT) {
            game.dealCardToPlayer(0);
            playerScoreView.setText("PLAYER 1 SCORE: " + game.getPlayerAtPosition(0).getHandValue());
            if (game.getPlayerAtPosition(0).getHandValue() > 21) {
                game.getPlayerAtPosition(0).setIsPlayerActive(false);
            }
        } else {
            game.getPlayerAtPosition(0).setIsPlayerActive(false);
        }
    }

    public void dealerPlays() {

        while (game.getPlayerAtPosition(1).getIsPlayerActive()) {
            if (game.getDealerAction() == Action.HIT) {
                game.dealCardToPlayer(1);
                dealerScoreView.setText("DEALER SCORE: " + game.getPlayerAtPosition(1).getHandValue());
                if (game.getPlayerAtPosition(1).getHandValue() > 21) {
                    game.getPlayerAtPosition(1).setIsPlayerActive(false);
                }
            } else {
                dealerScoreView.setText("DEALER SCORE: " + game.getPlayerAtPosition(1).getHandValue());
                game.getPlayerAtPosition(1).setIsPlayerActive(false);
            }
        }

        displayResult();
    }

    public void displayResult(){
        String resultString;

        if (game.checkWinner() == null){
            resultString = "RESULT: " +"\n\n" +"PUSH (Draw)!";
        } else { if (game.checkWinner() == game.getPlayerAtPosition(0)) {
            resultString = "RESULT: " +"\n\n" +"PLAYER 1 WINS!!";
            } else {
                resultString = "RESULT:" +"\n\n" + " DEALER WINS!!";
            }
        }
        winnerResultView.setText(resultString);
    }
}
