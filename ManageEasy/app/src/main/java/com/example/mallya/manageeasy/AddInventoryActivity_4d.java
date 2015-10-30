package com.example.mallya.manageeasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddInventoryActivity_4d extends AppCompatActivity {

    DatabaseHelper backEndDB;
    EditText editInventoryName, editInvetoryInstancetName, editInventoryDescription, editInventoryCost;
    Button addNewInventoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4d_add_inventory);

        backEndDB                   = new DatabaseHelper (this);

        editInventoryName           = (EditText)findViewById(R.id.editText_InventoryName);
        editInventoryDescription    = (EditText)findViewById(R.id.editText_InventoryDescription);
        editInvetoryInstancetName   = (EditText)findViewById(R.id.editText_InventoryRelatedInstanceName);
        editInventoryCost           = (EditText)findViewById(R.id.editText_InventoryCost);

        addNewInventoryButton       = (Button)findViewById(R.id.button_AddNewInventory);
        AddData();
    }

    public void AddData() {

        addNewInventoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(editInventoryName.getText().toString().trim().length() <= 0 || editInventoryDescription.getText().toString().trim().length() <= 0 ||
                                editInvetoryInstancetName.getText().toString().trim().length() <= 0 || editInventoryCost.getText().toString().trim().length() <= 0)
                        {

                            Toast.makeText(AddInventoryActivity_4d.this, "Please enter data in all fields", Toast.LENGTH_LONG).show();
                        }
                        else {
                            boolean isInserted = backEndDB.insertInventorySpecificData(editInventoryName.getText().toString(),
                                    editInventoryDescription.getText().toString(), editInvetoryInstancetName.getText().toString(),
                                    editInventoryCost.getText().toString());

                            if (isInserted == true)
                                Toast.makeText(AddInventoryActivity_4d.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(AddInventoryActivity_4d.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

                            //clearing edit-texts
                            editInventoryName.setText("");
                            editInventoryDescription.setText("");
                            editInvetoryInstancetName.setText("");
                            editInventoryCost.setText("");

                        }
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_inventory_activity_4d, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}