package com.example.alexs.compendium.Blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.alexs.compendium.R;

import java.util.ArrayList;

public class DisplayCardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cards);

// Open the Intent sent through from the BlackjackGameActivity screen and extract the card names

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        ArrayList<String> playerCardNames = extras.getStringArrayList("playerCardNames");
        ArrayList<String> dealerCardNames = extras.getStringArrayList("dealerCardNames");

// Set up the GridView object for the Player card display, using an ImageAdapter to inflate the view

        GridView gridview = (GridView) findViewById(R.id.gridview);
        ImageAdapter imageAdapter = new ImageAdapter(this, playerCardNames);

        gridview.setAdapter(imageAdapter);

// Set up the GridView object for the Dealer card display, using an ImageAdapter to inflate the view

        GridView dealerGridView = (GridView) findViewById(R.id.dealerGridViewID);
        ImageAdapter dealerImageAdapter = new ImageAdapter(this, dealerCardNames);

        dealerGridView.setAdapter(dealerImageAdapter);
    }

// Restart the main activity screen if the Replay button is clicked

    public void onReplayButtonClick(View view) {
        Intent replayIntent = new Intent(this, BlackjackGameActivity.class);
        startActivity(replayIntent);
    }
}
