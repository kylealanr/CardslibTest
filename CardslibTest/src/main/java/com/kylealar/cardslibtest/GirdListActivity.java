package com.kylealar.cardslibtest;

/**
 * Created by kylealanr on 5/1/14.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;

public class GirdListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_list);

        //get int from integer.xml
        int size = 20;

        //create array for the images
        int listImages[] = new int[size];

        //add the images to the array
        for (int i = 0; i<size; i++) {
            if (i == 1 || i ==6 || i == 13 || i == 17) {
                listImages[i] = R.drawable.p;
            } else {
                listImages[i] = R.drawable.s;
            }
        }

        //create array of cards
        ArrayList<Card> gridCards = new ArrayList<Card>();

        for (int i=0; i<size; i++) {
            if (i == 1 || i ==6 || i == 13 || i == 17) {
                createFavoriteFoodCard(i, gridCards, listImages);
            } else {

                createRegularFoodCard(i, gridCards, listImages);
            }
        }

        CardGridArrayAdapter mGridArrayAdapter = new CardGridArrayAdapter(this, gridCards);

        CardGridView gridView = (CardGridView) this.findViewById(R.id.gridList);
        if (gridView != null) {
            gridView.setAdapter(mGridArrayAdapter);
        }
    }

    public void createRegularFoodCard (int i, ArrayList gridCards, int[] listImages) {
        Card card = new Card(this);
        CardHeader header = new CardHeader(this);
        header.setTitle("Stomboli: $4");
        card.setTitle("regular ass food" + "\n\nI eat this infrequently");
        card.addCardHeader(header);
        card.setBackgroundResourceId(R.drawable.food_item);

        CardThumbnail thumb = new CardThumbnail(this);
        thumb.setDrawableResource(listImages[i]);
        card.addCardThumbnail(thumb);

        gridCards.add(card);
    }

    private void createFavoriteFoodCard (int i, ArrayList gridCards, int[] listImages) {
        Card card = new Card(this);
        CardHeader header = new CardHeader(this);
        header.setTitle("Pizza: $5");
        card.setTitle("one of my favs" + "\n\nI eat this every week");
        card.addCardHeader(header);
        card.setBackgroundResourceId(R.drawable.food_item_favorite);

        CardThumbnail thumb = new CardThumbnail(this);
        thumb.setDrawableResource(listImages[i]);
        card.addCardThumbnail(thumb);

        gridCards.add(card);
    }
}
