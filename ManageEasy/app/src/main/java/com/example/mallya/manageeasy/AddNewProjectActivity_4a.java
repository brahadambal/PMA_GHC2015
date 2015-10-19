package com.example.mallya.manageeasy;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewProjectActivity_4a extends AppCompatActivity {

    DatabaseHelper backEndDB;
    EditText editProjectName, editDescription, editStartDate, editEndDate, editFunds;
    Button addNewProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4a_add_new_project);

        backEndDB = new DatabaseHelper (this);
        editProjectName = (EditText)findViewById(R.id.editText_ProjectName);
        editDescription = (EditText)findViewById(R.id.editText_ProjectDescription);
        editStartDate   = (EditText)findViewById(R.id.editText_StartDate);
        editEndDate     = (EditText)findViewById(R.id.editText_EndDate);
        editFunds       = (EditText)findViewById(R.id.editText_ProjectFunds);

        addNewProjectButton = (Button)findViewById(R.id.button_AddNewProject);
        AddData();
    }

    public void AddData() {

        addNewProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isInserted = backEndDB.insertProjectSpecificData(editProjectName.getText().toString(), editDescription.getText().toString(),
                                editStartDate.getText().toString(), editEndDate.getText().toString(), editFunds.getText().toString());

                        if (isInserted == true) {

                            String display;
                            display = "Project Name: " + editProjectName.getText().toString() + "\n" +
                                    "Description: "+ editDescription.getText().toString() + "\n" +
                                    "Start Date: " + editStartDate.getText().toString() + "\n" +
                                    "End Date:" + editEndDate.getText().toString() + "\n" +
                                    "Funds :" + editFunds.getText().toString() + "\n" +
                                    "Data Inserted";

                            final Toast box = Toast.makeText(AddNewProjectActivity_4a.this, display, Toast.LENGTH_LONG);

                            box.show();

                            new CountDownTimer(9000, 1000)
                            {

                                public void onTick(long millisUntilFinished) {box.show();}
                                public void onFinish() {box.show();}

                            }.start();
                        }
                        else
                            Toast.makeText(AddNewProjectActivity_4a.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

                        //clearing edit-texts
                        editProjectName.setText("");
                        editDescription.setText("");
                        editStartDate.setText("");
                        editEndDate.setText("");
                        editFunds.setText("");

                    }
                }
        );

        addNewProjectButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {

                    addNewProjectButton.setTextColor(Color.WHITE);
                    addNewProjectButton.setBackgroundColor(Color.parseColor("#ff0000ff"));
                    return false;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP ) {
                    addNewProjectButton.setTextColor(Color.WHITE);
                    addNewProjectButton.setBackgroundColor(Color.parseColor("#333333"));
                    return false;
                }


                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_project, menu);
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
