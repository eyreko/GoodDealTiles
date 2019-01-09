package ch.hearc.ig.ta.tp.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;
import android.util.Log;

import ch.hearc.ig.ta.tp.Business.Deal;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "dealsManager";

    private static final String TABLE_DEALS = "DEALS";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_TITLE = "TITLE";
    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_DEALS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT NOT NULL, "
            + COL_TITLE + " TEXT NOT NULL," + COL_DESCRIPTION + " TEXT NOT NULL);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEALS);
    }

    // code to add the new contact
    public void addDeal(Deal deal) {

        Log.d("addDeal", "Inserting deals");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, deal.getName()); // deal Name
        values.put(COL_TITLE, deal.getTitre()); // deal titre
        values.put(COL_DESCRIPTION, deal.getDescription());

        // Inserting Row
        //2nd argument is String containing nullColumnHack
        db.insert(TABLE_DEALS, null, values);

        db.close(); // Closing database connection
    }

    public String getDealDescriptionByTitle(String title){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_DEALS + " WHERE " + COL_TITLE + " LIKE '"+ title +"'";
        Log.d("selectDescription", query);
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        Log.d("selectDescription", String.valueOf(c.getCount()));
        Log.d("selectDescription", c.getString(c.getColumnIndex(COL_DESCRIPTION)));
        return c.getString(c.getColumnIndex(COL_DESCRIPTION));
    }

    public Cursor showAllDeals() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + TABLE_DEALS;
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }

    public boolean deleteTitles()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_DEALS, null, null) > 0;
    }

    // code to get all deals in a list view
    public List<Deal> getAllDeals() {
        List<Deal> dealList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DEALS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Deal deal = new Deal();
                deal.setName(cursor.getString(1));
                deal.setTitre(cursor.getString(2));
                deal.setDescription(cursor.getString(3));

                // Adding deal to list
                dealList.add(deal);
            } while (cursor.moveToNext());
        }

        // return contact list
        return dealList;
    }

    // https://www.youtube.com/watch?v=N-gHIJShz1I
}