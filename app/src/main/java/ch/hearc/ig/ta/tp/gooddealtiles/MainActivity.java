package ch.hearc.ig.ta.tp.gooddealtiles;

import android.app.Activity;
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

    public static final String KEY_TILE = "KeyTile";

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

        Boolean isClean = db.deleteTitles();
        if(isClean) {
            Log.d("cleanDeals", "Deals has been deleted");
        } else {
            Log.d("cleanDeals", "No clean table");
        }
        
        db.addDeal(new Deal("Payot","Payot -10%","Réduction de 10% sur les livres avec présentation de la carte étudiant"));
        db.addDeal(new Deal("Fnac","Fnac fidélité","test1"));
        db.addDeal(new Deal("CFF","CFF Railplus","test1"));
        db.addDeal(new Deal("Digitec","digitec.ch","test1"));
        db.addDeal(new Deal("Pathé","Cinéma Pathé","test1"));
        db.addDeal(new Deal("Mobility","Abonnement Mobility","test1"));

        listDeals = new ArrayList<>();

        userList = findViewById(R.id.deals_list);
        viewData();

        /*userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this," "+text,Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayTileActivity.class);
        String message = "description du deal...";
        intent.putExtra(KEY_TILE, message);
        startActivity(intent);
    }

    public void displayCreateTile(View view){
        Intent intent = new Intent(this, CreateNewTile.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //createTile result

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String name = data.getStringExtra("name");
                String title = data.getStringExtra("title");
                String description = data.getStringExtra("description");

                Deal newDeal = new Deal(name, title, description);

                db.addDeal(newDeal);
                viewData();
            }
        }
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
