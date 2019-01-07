package ch.hearc.ig.ta.tp.gooddealtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "DealText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayTileActivity.class);
        String message = "?";
        switch (view.getId()) {
            case (R.id.tile1):
                message = "Payot 10% de réduction !";
                Log.d("GoodDealTiles","tile1");
                break;
            case (R.id.tile2):
                message = "Billet à l'étranger 50% avec CFF Railplus";
                Log.d("GoodDealTiles","tile2");
                break;
            case (R.id.tile3):
                message = "Livre en lecture libre sur ENI";
                Log.d("GoodDealTiles","tile3");
                break;
            case (R.id.tile4):
                message = "Bon plan journalier sur digitec.ch et livraison le lendemain si commandé avant 12h";
                Log.d("GoodDealTiles","tile4");
                break;
            case (R.id.tile5):
                message = "Cinéma Pathé au Flon à Lausanne : réduction de 3CHF";
                Log.d("GoodDealTiles","tile5");
                break;
            case (R.id.tile6):
                message = "Abonnement Mobility pour 100CHF par année";
                Log.d("GoodDealTiles","tile4");
                break;
        }
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
