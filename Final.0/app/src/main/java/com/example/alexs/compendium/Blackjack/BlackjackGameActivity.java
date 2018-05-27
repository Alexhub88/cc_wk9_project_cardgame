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

    private ImageView p1FirstRound1;
    private ImageView p1FirstRound2;
    private ImageView p1Current;
    private ImageView dealerFirstRound1;
    private ImageView dealerFirstRound2;

    private Button showCardsButton;

    private BlackjackDeck deck;
    private BlackjackHand dealerHand;
    private BlackjackHand playerHand;
    private BlackjackPlayer dealer;
    private BlackjackPlayer player;
    private String playerCurrentCard;
    private BlackjackGame game;
    private ArrayList<BlackjackPlayer> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_game);

        dealerScoreView = findViewById(R.id.dealerScoreViewID);
        playerTextView = findViewById(R.id.playerTextViewID);
        playerScoreView = findViewById(R.id.playerScoreViewID);

        winnerResultView = findViewById(R.id.winnerResultViewID);
        p1FirstRound1 = findViewById(R.id.p1FirstRound1ID);
        p1FirstRound2 = findViewById(R.id.p1FirstRound2ID);
        p1Current = findViewById(R.id.p1CurrentID);
        dealerFirstRound1 = findViewById(R.id.dealerFirstRound1ID);
        dealerFirstRound2 = findViewById(R.id.dealerFirstRound2ID);

        showCardsButton = findViewById(R.id.showCardsButtonID);

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

// Hide the 'Show Cards' button, as the hand is not completed at this point

        View showCardsButton = findViewById(R.id.showCardsButtonID);
        showCardsButton.setVisibility(View.GONE);

// Show the Player's first round score

        playerScoreView.setText(game.playerCurrentScore(0));

// Display the Player's first round cards

        setCardImage(p1FirstRound1, game.getCardFileName(0,0));
        setCardImage(p1FirstRound2, game.getCardFileName(0,1));
        p1Current.setVisibility(View.GONE);

// Display the Dealer's first round cards

        setCardImage(dealerFirstRound1, game.getCardFileName(1,0));
        setCardImage(dealerFirstRound2, "facedown");  //Dealer's second card is face down
    }

// The button click sets the action for the Player. After the Player either Stands or Busts, the Dealer plays.

    public void onActionButtonClick(View view) {

        switch (view.getId()) {

            case R.id.playerHitButtonID:   // Player Hits

                game.play(0, Action.HIT);
                playerScoreView.setText(game.playerCurrentScore(0));
                p1Current.setVisibility(View.VISIBLE);
                playerCurrentCard = game.getCardFileName(0, game.getCurrentHandSize(0) - 1);
                setCardImage(p1Current, playerCurrentCard);   //Display current card

                if (!game.getPlayerAtPosition(0).getIsPlayerActive()) { //i.e. if Player's turn is over
                    setCardImage(dealerFirstRound2, game.getCardFileName(1, 1));
                    while (game.getPlayerAtPosition(1).getIsPlayerActive()) {
                        game.play(1, game.getDealerAction());   // Dealer's turn to play
                        dealerScoreView.setText(game.playerCurrentScore(1));
                    }
                    winnerResultView.setText(game.displayResult());  //Check winner and show result
                    showCardsButton.setVisibility(View.VISIBLE);     //Display the 'Show Cards' button
                }

                break;

            case R.id.playerStandButtonID:      // Player Stands

                game.play(0, Action.STAND);
                playerScoreView.setText(game.playerCurrentScore(0));
                setCardImage(dealerFirstRound2, game.getCardFileName(1, 1));
                while (game.getPlayerAtPosition(1).getIsPlayerActive()) {
                    game.play(1, game.getDealerAction());     // Dealer's turn to play
                    dealerScoreView.setText(game.playerCurrentScore(1));
                }

                winnerResultView.setText(game.displayResult());  //Check winner and show result
                showCardsButton.setVisibility(View.VISIBLE);     //Display the 'Show Cards' button

                break;
        }
    }

// If the button to show all player cards is clicked, get the Player and Dealer card names and
// send them through to the DisplayCardsActivity screen using an Intent

    public void onShowCardsButtonClick(View view){
        ArrayList<String> playerCardNames = game.getPlayerCardNames(0);
        ArrayList<String> dealerCardNames = game.getPlayerCardNames(1);
        Intent intent = new Intent(this, DisplayCardsActivity.class);
        intent.putExtra("playerCardNames", playerCardNames);
        intent.putExtra("dealerCardNames", dealerCardNames);
        startActivity(intent);
    }

// Function to set a card image from the filename passed in as a String

    public void setCardImage(ImageView image, String fileName){
        int cardImageID = getResources().getIdentifier(fileName, "drawable", getPackageName());
        image.setImageResource(cardImageID);
    }

}
