package com.example.alexs.compendium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.alexs.compendium.HighLow.HighLowGameActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_high_low) {
            super.onOptionsItemSelected(item);
            this.closeOptionsMenu();
            Intent intent = new Intent(this, HighLowGameActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.action_blackjack){

        }
        return super.onOptionsItemSelected(item);
    }
}
