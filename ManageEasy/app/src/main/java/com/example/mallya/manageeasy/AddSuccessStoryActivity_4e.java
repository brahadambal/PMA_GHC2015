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
 * Created by Mallya on 10/23/2015.
 */
public class AddSuccessStoryActivity_4e extends AppCompatActivity {

    DatabaseHelper backEndDB;

    EditText editSuccessStoryName, editSuccessStoryInstanceName, editSuccessStoryDescription, editSuccessStoryInstitution,
            editSuccessStoryPersonnel, editSuccessStoryContact, editSuccessStoryAddress;

    Button addSuccessStoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4e_add_success_story);

        backEndDB                       = new DatabaseHelper (this);

        editSuccessStoryName            = (EditText)findViewById(R.id.editText_SuccessStoryName);
        editSuccessStoryInstanceName    = (EditText)findViewById(R.id.editText_InstanceName);
        editSuccessStoryDescription     = (EditText)findViewById(R.id.editText_SuccessStoryDescription);
        editSuccessStoryInstitution     = (EditText)findViewById(R.id.editText_InstitutionName);
        editSuccessStoryPersonnel       = (EditText)findViewById(R.id.editText_PersonnelName);
        editSuccessStoryContact         = (EditText)findViewById(R.id.editText_ContactSuccessStory);
        editSuccessStoryAddress         = (EditText)findViewById(R.id.editText_AddressSuccessStory);

        addSuccessStoryButton           = (Button)findViewById(R.id.button_AddSuccessStory);

        AddData();
    }

    public void AddData() {

        addSuccessStoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(editSuccessStoryName.getText().toString().trim().length() <= 0 || editSuccessStoryInstanceName.getText().toString().trim().length() <= 0 ||
                                editSuccessStoryDescription.getText().toString().trim().length() <= 0 || editSuccessStoryInstitution.getText().toString().trim().length() <= 0 ||
                                editSuccessStoryPersonnel.getText().toString().trim().length() <= 0 || editSuccessStoryContact.getText().toString().trim().length() <= 0 ||
                                editSuccessStoryAddress.getText().toString().trim().length() <= 0  )
                        {

                            Toast.makeText(AddSuccessStoryActivity_4e.this, "Please enter data in all fields", Toast.LENGTH_LONG).show();
                        }

                        else {
                            boolean isInserted = backEndDB.insertSuccessStorySpecificData(editSuccessStoryName.getText().toString(),
                                    editSuccessStoryInstanceName.getText().toString(), editSuccessStoryDescription.getText().toString(),
                                    editSuccessStoryInstitution.getText().toString(), editSuccessStoryPersonnel.getText().toString(),
                                    editSuccessStoryContact.getText().toString(), editSuccessStoryAddress.getText().toString());

                            if (isInserted == true)
                                Toast.makeText(AddSuccessStoryActivity_4e.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(AddSuccessStoryActivity_4e.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

                            //clearing edit-texts
                            editSuccessStoryName.setText("");
                            editSuccessStoryInstanceName.setText("");
                            editSuccessStoryDescription.setText("");
                            editSuccessStoryInstitution.setText("");
                            editSuccessStoryPersonnel.setText("");
                            editSuccessStoryContact.setText("");
                            editSuccessStoryAddress.setText("");
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
