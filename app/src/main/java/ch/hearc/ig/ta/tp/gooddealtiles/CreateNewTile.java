package ch.hearc.ig.ta.tp.gooddealtiles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ch.hearc.ig.ta.tp.Business.Deal;

public class CreateNewTile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_tile);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
    }

    public void createTile(View v){
        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        final EditText titleField = (EditText) findViewById(R.id.EditTextTitle);
        String title = titleField.getText().toString();

        final EditText descriptionField = (EditText) findViewById(R.id.EditTextDescription);
        String description = descriptionField.getText().toString();

        Intent returnIntent = new Intent();
        returnIntent.putExtra("name",name);
        returnIntent.putExtra("title",title);
        returnIntent.putExtra("description",description);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
