package com.example.mallya.manageeasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddInstanceActivity_4b extends AppCompatActivity {

    DatabaseHelper backEndDB;

    EditText editInstanceName, editInstanceProjectName, editInstanceDescription, editInstanceFunds, editInstanceLocation,editDonationsBy;
    Button addNewInstanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4b_add_instance);

        backEndDB               = new DatabaseHelper (this);

        editInstanceName        = (EditText)findViewById(R.id.editText_InstanceName);
        editInstanceProjectName = (EditText)findViewById(R.id.editText_InstanceProjectName);
        editInstanceDescription = (EditText)findViewById(R.id.editText_InstanceDescription);
        editInstanceFunds       = (EditText)findViewById(R.id.editText_InstanceFunds);
        editInstanceLocation    = (EditText)findViewById(R.id.editText_InstanceLocation);
        editDonationsBy         = (EditText)findViewById(R.id.editText_DonatedBy);

        addNewInstanceButton    = (Button)findViewById(R.id.button_AddNewInstance);

        AddData();
    }

    public void AddData() {

        addNewInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(editInstanceName.getText().toString().trim().length() <= 0 || editInstanceProjectName.getText().toString().trim().length() <= 0 ||
                                editInstanceDescription.getText().toString().trim().length() <= 0 || editInstanceFunds.getText().toString().trim().length() <= 0 ||
                                editInstanceLocation.getText().toString().trim().length() <= 0 || editDonationsBy.getText().toString().trim().length() <= 0 )
                        {
                            Toast.makeText(AddInstanceActivity_4b.this, "Please enter data in all fields", Toast.LENGTH_LONG).show();
                        }
                        else {
                            boolean isInserted = backEndDB.insertInstanceSpecificData(editInstanceName.getText().toString(),
                                    editInstanceProjectName.getText().toString(), editInstanceDescription.getText().toString(),
                                    editInstanceFunds.getText().toString(), editInstanceLocation.getText().toString(),
                                    editDonationsBy.getText().toString());

                            if (isInserted == true)
                                Toast.makeText(AddInstanceActivity_4b.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(AddInstanceActivity_4b.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

                            //clearing edit-texts
                            editInstanceName.setText("");
                            editInstanceProjectName.setText("");
                            editInstanceDescription.setText("");
                            editInstanceFunds.setText("");
                            editInstanceLocation.setText("");
                            editDonationsBy.setText("");
                        }
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instance_specific, menu);
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
