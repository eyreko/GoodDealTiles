package ch.hearc.ig.ta.tp.gooddealtiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "fdafafda";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayTileActivity.class);
        String message = "dgfdgdg";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d("GoodDealTiles","hello");
    }
}
