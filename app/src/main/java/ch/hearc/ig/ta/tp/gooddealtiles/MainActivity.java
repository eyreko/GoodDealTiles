package ch.hearc.ig.ta.tp.gooddealtiles;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
import ch.hearc.ig.ta.tp.Business.Deal;
import ch.hearc.ig.ta.tp.persistance.MySQLiteHelper;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Payot 10%";

    MySQLiteHelper db;
    ArrayList<String> listDeals;
    ArrayAdapter adapter;
    ListView userList;

    Button add_deal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MySQLiteHelper(this);
        
        db.addDeal(new Deal("Payot","Payot -10%","test"));
        db.addDeal(new Deal("Fnac","Fnac fidélité","test1"));
        db.addDeal(new Deal("Fnac","CFF Railplus","test1"));
        db.addDeal(new Deal("Fnac","digitec.ch","test1"));
        db.addDeal(new Deal("Fnac","Cinéma Pathé","test1"));
        db.addDeal(new Deal("Fnac","Abonnement Mobility","test1"));

        listDeals = new ArrayList<>();

        userList = findViewById(R.id.deals_list);
        viewData();

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this," "+text,Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayTileActivity.class);
        String message = "";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void viewData() {
        Cursor cursor = db.showAllDeals();

        if (cursor.getCount() == 0) {
            Toast.makeText(this,"No data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listDeals.add(cursor.getString(2));
            }
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,listDeals);
        userList.setAdapter(adapter);
    }
}
