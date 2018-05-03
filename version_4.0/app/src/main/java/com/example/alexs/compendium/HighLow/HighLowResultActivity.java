package com.example.alexs.compendium.HighLow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexs.compendium.R;

public class HighLowResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_low_result);

        ImageView imageViewp1c1 = findViewById(R.id.imageViewp1c1ID);
        ImageView imageViewp1c2 = findViewById(R.id.imageViewp1c2ID);
        ImageView imageViewp2c1 = findViewById(R.id.imageViewp2c1ID);
        ImageView imageViewp2c2 = findViewById(R.id.imageViewp2c2ID);

        Intent intent = getIntent();
        String player1Card1 = (String) intent.getSerializableExtra("player1Card1");
        String player1Card2 = (String) intent.getSerializableExtra("player1Card2");
        String player2Card1 = (String) intent.getSerializableExtra("player2Card1");
        String player2Card2 = (String) intent.getSerializableExtra("player2Card2");

        String player1Result = (String) intent.getSerializableExtra("player1Result");
        String player2Result = (String) intent.getSerializableExtra("player2Result");
        String displayWinner  = (String) intent.getSerializableExtra("displayWinner");
//Get the names of the files representing the player cards
        int p1c1 = getResources().getIdentifier(player1Card1, "drawable", getPackageName());
        imageViewp1c1.setImageResource(p1c1);
        int p1c2 = getResources().getIdentifier(player1Card2, "drawable", getPackageName());
        imageViewp1c2.setImageResource(p1c2);
        int p2c1 = getResources().getIdentifier(player2Card1, "drawable", getPackageName());
        imageViewp2c1.setImageResource(p2c1);
        int p2c2 = getResources().getIdentifier(player2Card2, "drawable", getPackageName());
        imageViewp2c2.setImageResource(p2c2);
//Set the results strings in Results screen to display the winner
        TextView player1ResultView = findViewById(R.id.p1ResultTextViewID);
        player1ResultView.setText(player1Result);
        TextView player2ResultView = findViewById(R.id.p2ResultTextViewID);
        player2ResultView.setText(player2Result);
        TextView result = findViewById(R.id.resultTextViewID);
        result.setText(displayWinner);
    }


}
