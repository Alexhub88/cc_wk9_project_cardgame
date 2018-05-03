package com.example.alexs.compendium.Blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.alexs.compendium.R;
import java.util.ArrayList;

public class BlackjackGameActivity extends AppCompatActivity {

// Set up Activity variables and a BlackjackGame to control the game logic
    private TextView dealerScoreView;
    private TextView playerTextView;
    private TextView playerScoreView;
    private TextView winnerResultView;
    private TextView playerBust;
    private TextView dealerBust;

    private ImageView p1FirstRound1;
    private ImageView p1FirstRound2;
    private ImageView p1Current;
    private ImageView dealerFirstRound1;
    private ImageView dealerFirstRound2;
    private ImageView dealerCurrent;

    private BlackjackDeck deck;
    private BlackjackHand dealerHand;
    private BlackjackHand playerHand;
    private BlackjackPlayer dealer;
    private BlackjackPlayer player;
    private String playerFirstRoundCard1;
    private String playerFirstRoundCard2;
    private String playerCurrentCard;
    private String dealerFirstRoundCard1;
    private String dealerFirstRoundCard2;
    private String dealerCurrentCard;
    private BlackjackGame game;
    private ArrayList<BlackjackPlayer> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_game);

        dealerScoreView = findViewById(R.id.dealerScoreViewID);
        playerTextView = findViewById(R.id.playerTextViewID);
        playerScoreView = findViewById(R.id.playerScoreViewID);
        playerBust = findViewById(R.id.playerBustID);
        dealerBust = findViewById(R.id.dealerBustID);
        winnerResultView = findViewById(R.id.winnerResultViewID);
        p1FirstRound1 = findViewById(R.id.p1FirstRound1ID);
        p1FirstRound2 = findViewById(R.id.p1FirstRound2ID);
        p1Current = findViewById(R.id.p1CurrentID);
        dealerFirstRound1 = findViewById(R.id.dealerFirstRound1ID);
        dealerFirstRound2 = findViewById(R.id.dealerFirstRound2ID);
        dealerCurrent = findViewById(R.id.dealerCurrentID);

        deck = new BlackjackDeck();
        dealerHand = new BlackjackHand();
        playerHand = new BlackjackHand();
        player = new BlackjackPlayer("Player 1", playerHand, true, false);
        dealer = new BlackjackPlayer("Dealer", dealerHand, true, false);
        playerList = new ArrayList<>();
        playerList.add(player);
        playerList.add(dealer);
        game = new BlackjackGame(deck, playerList);

        game.deal();


// If Player has Blackjack, set the flag in the Player to show this
        if(game.getPlayerAtPosition(0).getHandValue() == 21) {
            player = game.getPlayerAtPosition(0);
            player.setHasBlackjack(true);
            game.setPlayerAtPosition(0, player);
            playerScoreView.setText("PLAYER 1: BLACKJACK!");
        } else {
            playerScoreView.setText("PLAYER 1 SCORE: " + game.getPlayerAtPosition(0).getHandValue());
        }
// Display the Player's first round cards
        playerFirstRoundCard1 = game.getPlayerAtPosition(0).getHand().getCards().get(0).getImageFileName();
        setCardImage(p1FirstRound1, playerFirstRoundCard1);
        playerFirstRoundCard2 = game.getPlayerAtPosition(0).getHand().getCards().get(1).getImageFileName();
        setCardImage(p1FirstRound2, playerFirstRoundCard2);
        p1Current.setVisibility(View.GONE);
// Display the Dealer's first round cards
        dealerFirstRoundCard1 = game.getPlayerAtPosition(1).getHand().getCards().get(0).getImageFileName();
        setCardImage(dealerFirstRound1, dealerFirstRoundCard1);
        dealerFirstRoundCard2 = "facedown";
        setCardImage(dealerFirstRound2, dealerFirstRoundCard2);
        dealerFirstRoundCard2 = game.getPlayerAtPosition(1).getHand().getCards().get(1).getImageFileName();
        dealerCurrent.setVisibility(View.GONE);
    }

    public void onActionButtonClick(View view) {

        switch (view.getId()) {
            case R.id.playerHitButtonID:   //Button for Player Hit Action
                Log.d("Blackjack", "Player Hits");
                play(Action.HIT);
                p1Current.setVisibility(View.VISIBLE);
                int currentHandSize = game.getPlayerAtPosition(0).getHand().getCards().size();
                playerCurrentCard = game.getPlayerAtPosition(0).getHand().getCards().get(currentHandSize - 1).getImageFileName();
                setCardImage(p1Current, playerCurrentCard);   //Display current card

                if (!game.getPlayerAtPosition(0).getIsPlayerActive()) { //i.e. Player's turn is over
                    dealerPlays();
                }
                break;
            case R.id.playerStandButtonID:      //Player Stands
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
                playerScoreView.setText("PLAYER 1 SCORE: " + game.getPlayerAtPosition(0).getHandValue());
                playerBust.setText("PLAYER 1 BUSTS!");   //Player Busts
                game.getPlayerAtPosition(0).setIsPlayerActive(false); //Set flag to show turn is over
            }
        } else {
            game.getPlayerAtPosition(0).setIsPlayerActive(false);  //Player Stands
        }

    }

    public void dealerPlays() {  //Different function as Dealer gets Action from a function not button

        if (game.getPlayerAtPosition(1).getHandValue() == 21) {  //Dealer has Blackjack
            dealer = game.getPlayerAtPosition(1);
            dealer.setHasBlackjack(true);
            game.setPlayerAtPosition(1, dealer);
            dealerScoreView.setText("DEALER BLACKJACK!");
        } else {
            while (game.getPlayerAtPosition(1).getIsPlayerActive()) {
                if (game.getDealerAction() == Action.HIT) {
                    game.dealCardToPlayer(1);   //Deal card to Dealer
                    dealerScoreView.setText("DEALER SCORE: " + game.getPlayerAtPosition(1).getHandValue());
                    if (game.getPlayerAtPosition(1).getHandValue() > 21) {
                        dealerScoreView.setText("DEALER SCORE: " + game.getPlayerAtPosition(1).getHandValue());

                        dealerBust.setText("DEALER BUSTS!");   //Dealer Busts
                        game.getPlayerAtPosition(1).setIsPlayerActive(false);
                    }
                    setCardImage(dealerFirstRound2, dealerFirstRoundCard2);
                    int currentHandSize = game.getPlayerAtPosition(1).getHand().getCards().size();
                    dealerCurrentCard = game.getPlayerAtPosition(1).getHand().getCards().get(currentHandSize - 1).getImageFileName();
                    dealerCurrent.setVisibility(View.VISIBLE);
                    setCardImage(dealerCurrent, dealerCurrentCard);  //Display Dealer current card
                } else {
                    dealerScoreView.setText("DEALER SCORE: " + game.getPlayerAtPosition(1).getHandValue());
                    game.getPlayerAtPosition(1).setIsPlayerActive(false);  //Dealer turn ends
                }
            }
        }
        winnerResultView.setText(game.displayResult());  //Check winner and show result
    }


// Function to set a card image from the filename passed in as a String
    public void setCardImage(ImageView image, String fileName){
        int cardImageID = getResources().getIdentifier(fileName, "drawable", getPackageName());
        image.setImageResource(cardImageID);
    }

}
