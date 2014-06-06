package com.kylealar.cardslibtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by kylealanr on 4/26/14.
 */
public class CardListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //get int from integer.xml
        int size = getResources().getInteger(R.integer.card_list_size);

        //create array for the images
        int listImages[] = new int[size];

        //add the images to the array
        for (int i = 0; i<size; i++) {
            listImages[i] = R.drawable.ic_launcher;
        }

        //create array of cards
        ArrayList<Card> cards = new ArrayList<Card>();

        //create the # of cards specified in the xml file
        for (int i = 0; i<size; i++) {
            if (i%2 == 0) {
                // Create a Card
                Card card = new Card(this, R.layout.row_card_closed);
                // Create a CardHeader
                //CardHeader header = new CardHeader(this);
                // Add Header to card
                //header.setTitle("Card test: " + i);
                card.setTitle("Which Wich");
                //card.addCardHeader(header);
                card.setBackgroundResourceId(R.drawable.restaurant_closed);

                CardThumbnail thumb = new CardThumbnail(this);
                thumb.setDrawableResource(listImages[i]);
                card.addCardThumbnail(thumb);

                card.setOnClickListener(new Card.OnCardClickListener() {
                    @Override
                    public void onClick(Card card, View view) {
                        Toast.makeText(getApplicationContext(),
                                "this place is closed", Toast.LENGTH_SHORT).show();
                    }
                });

                cards.add(card);
            } else {
                // Create a Card
                Card card = new Card(this, R.layout.row_card);
                // Create a CardHeader
                //CardHeader header = new CardHeader(this);
                // Add Header to card
                //header.setTitle("Card test: " + i);
                card.setTitle("Oreganos");
                //card.addCardHeader(header);
                card.setBackgroundResourceId(R.drawable.restaurant_open);

                CardThumbnail thumb = new CardThumbnail(this);
                thumb.setDrawableResource(listImages[i]);
                card.addCardThumbnail(thumb);

                card.setOnClickListener(new Card.OnCardClickListener() {
                    @Override
                    public void onClick(Card card, View view) {
                        Toast.makeText(getApplicationContext(),
                                "here are some food options", Toast.LENGTH_SHORT).show();

                        switchToFoodItems();
                    }
                });

                cards.add(card);
            }
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards);

        CardListView listView = (CardListView) this.findViewById(R.id.testList);
        if (listView != null) {
            listView.setAdapter(mCardArrayAdapter);
        }
    }

    private void switchToFoodItems () {
        Intent intent = new Intent(this, GirdListActivity.class);
        startActivity(intent);
    }
}
