package com.kylealar.cardslibtest;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private TextView mSecondaryTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Card card = new Card(this, R.layout.row_card);

        CardHeader header = new CardHeader(this);
        header.setTitle("Card Demo");

        card.setTitle("Oklahoma State University");
        //see if I can chane background to color variable
        //card.setBackgroundResourceId();

        CardThumbnail thumb = new CardThumbnail(this);
        thumb.setDrawableResource(R.drawable.ic_launcher);

        card.addCardThumbnail(thumb);
        card.addCardHeader(header);

        CardView cardView = (CardView) findViewById(R.id.carddemo);
        cardView.setCard(card);

        mSecondaryTitle = (TextView) findViewById(R.id.card_main_inner_secondary_title);
        mSecondaryTitle.setText("Click the button to see restaurants");
    }

    public void btnCardListDemoClick(View v){
        switchToRestaurantList();
    }

    public void btnGridListDemoClick(View v) {
        switchToFoodItems();
    }

    private void switchToFoodItems () {
        Intent intent = new Intent(this, GirdListActivity.class);
        startActivity(intent);

        Context context = getApplicationContext();
        String toastMessage = "showing grid";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.show();
    }

    private void switchToRestaurantList () {
        Intent intent = new Intent(this, CardListActivity.class);
        startActivity(intent);

        Context context = getApplicationContext();
        String toastMessage = "showing list";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.show();
    }
}
