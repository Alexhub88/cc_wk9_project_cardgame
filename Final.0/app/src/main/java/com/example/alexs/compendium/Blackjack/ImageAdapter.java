package com.example.alexs.compendium.Blackjack;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alexs.compendium.R;

import java.util.ArrayList;

// ImageAdapter to create and inflate the view for the GridView display

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final ArrayList<String> cardFileNames;

// Constructor takes an array of Strings representing the card file names

    public ImageAdapter(Context context, ArrayList<String> cardFileNames) {
        this.context = context;
        this.cardFileNames = cardFileNames;
    }

// Method to create and inflate the GridView object for the card displays

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.card_image, null);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.playerCardImageViewID);

            String cardFileName = cardFileNames.get(position);

// Identify the card file name from the file name String passed in, then find the integer that labels the file, then
// set the ImageResource to the correct image file

            int cardFileNameID = context.getResources().getIdentifier(cardFileName, "drawable", context.getPackageName());

            imageView.setImageResource(cardFileNameID);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

// The three methods below are required so that ImageAdapter can extend the BaseAdapter class, as required for GridView

    @Override
    public int getCount() {
        return cardFileNames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}

