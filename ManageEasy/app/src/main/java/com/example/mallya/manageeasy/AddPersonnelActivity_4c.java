package com.example.mallya.manageeasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPersonnelActivity_4c extends AppCompatActivity {

    DatabaseHelper backEndDB;
    EditText editPersonnelName, editPersonnelInstance, editContact, editAddress, editSalary,editJoinDate, editResignDate;
    Button addNewPersonnelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4c_add_personnel);

        backEndDB = new DatabaseHelper (this);
        editPersonnelName = (EditText)findViewById(R.id.editText_PersonnelName);
        editPersonnelInstance = (EditText)findViewById(R.id.editText_PersonnelInstanceName);
        editContact   = (EditText)findViewById(R.id.editText_PersonnelContact);
        editAddress     = (EditText)findViewById(R.id.editText_PersonnelAddress);
        editSalary       = (EditText)findViewById(R.id.editText_PersonnelSalarty);
        editJoinDate = (EditText)findViewById(R.id.editText_JoinDate);
        editResignDate = (EditText)findViewById(R.id.editText_ResignDate);

        addNewPersonnelButton = (Button)findViewById(R.id.button_AddNewPersonnel);
        AddData();
    }

    public void AddData() {

        addNewPersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isInserted = backEndDB.insertPersonnelSpecificData(editPersonnelName.getText().toString(), editPersonnelInstance.getText().toString(),
                                editContact.getText().toString(), editAddress.getText().toString(), editSalary.getText().toString(),
                                editJoinDate.getText().toString(), editResignDate.getText().toString());

                        if (isInserted == true)
                            Toast.makeText(AddPersonnelActivity_4c.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddPersonnelActivity_4c.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personnel_specific, menu);
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
