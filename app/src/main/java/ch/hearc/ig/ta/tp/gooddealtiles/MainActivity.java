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
        }
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
