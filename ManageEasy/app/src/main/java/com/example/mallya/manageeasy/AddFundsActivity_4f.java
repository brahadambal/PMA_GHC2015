package com.example.mallya.manageeasy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Mallya on 10/25/2015.
 */
public class AddFundsActivity_4f extends AppCompatActivity {

    DatabaseHelper backEndDB;

    EditText editDonatedBy, editAmount, editProjectName, editLocation, editPanCardNum;

    Button addFundsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4f_add_funds);

        backEndDB       = new DatabaseHelper (this);

        editDonatedBy   = (EditText)findViewById(R.id.editText_DonatedBy);
        editAmount      = (EditText)findViewById(R.id.editText_Amount);
        editProjectName = (EditText)findViewById(R.id.editText_ProjectName);
        editLocation    = (EditText)findViewById(R.id.editText_Location);
        editPanCardNum  = (EditText)findViewById(R.id.editText_PanCard);

        addFundsButton  = (Button)findViewById(R.id.button_AddDonations);

        AddData();
    }

    public void AddData() {

        addFundsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //String DonatedBy, String Amount, String ProjectName, String  Location, String PANCard

                        if(editDonatedBy.getText().toString().trim().length() <= 0 || editAmount.getText().toString().trim().length() <= 0 ||
                                editProjectName.getText().toString().trim().length() <= 0 || editLocation.getText().toString().trim().length() <= 0 ||
                                editPanCardNum.getText().toString().trim().length() <= 0)
                        {

                            Toast.makeText(AddFundsActivity_4f.this, "Please enter data in all fields", Toast.LENGTH_LONG).show();
                        }
                        else {

                            boolean isInserted = backEndDB.insertDonationSpecificData(editDonatedBy.getText().toString(), editAmount.getText().toString(),
                                    editProjectName.getText().toString(), editLocation.getText().toString(), editPanCardNum.getText().toString());


                            if (isInserted == true)
                                Toast.makeText(AddFundsActivity_4f.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(AddFundsActivity_4f.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

                            //clearing edit-texts
                            editDonatedBy.setText("");
                            editAmount.setText("");
                            editProjectName.setText("");
                            editLocation.setText("");
                            editPanCardNum.setText("");
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
