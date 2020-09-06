package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        //Call method to retrieve data, gets text of the item
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        //Click listener for button, when user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //create an intent which will contain the results of whatever the user has modified
                Intent intent = new Intent();
                //pass the results of editing
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //Set the result of the intent
                setResult(RESULT_OK, intent);

                //Finish the activity and close the current screen and go back
                finish();
            }
        });
    }
}