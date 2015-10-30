package com.example.mallya.manageeasy;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddNewProjectActivity_4a extends AppCompatActivity {

    DatabaseHelper backEndDB;
    EditText editProjectName, editDescription, editStartDate, editEndDate, editFunds;
    Button addNewProjectButton;
    static final int DIALOG_ID = 0, DIALOG_ID1 = 1;
    int year_x, month_x, day_x;

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

        // To get the current date
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnStartButtonClick();
        showDialogOnEndButtonClick();

        //TODO, Validate that endDate is greater than Start date.

        AddData();
    }

    public void showDialogOnStartButtonClick() {

        editStartDate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);//.getDatePicker().setDescendantFocusability(DatePicker.FOCUS_BLOCK_DESCENDANTS);
                    }
                }
        );
    }

    public void showDialogOnEndButtonClick() {

        editEndDate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog((DIALOG_ID1));
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id){

        if (id == DIALOG_ID) {
            return new DatePickerDialog(this, dpickerStartListener, year_x, month_x, day_x);
        }

        if (id == DIALOG_ID1) {
            return new DatePickerDialog(this, dpickerEndListener, year_x, month_x, day_x);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerStartListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;

            updateStartDisplay();
        }
    };

    private DatePickerDialog.OnDateSetListener dpickerEndListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;

            updateEndDisplay();
        }
    };

    private void updateStartDisplay() {

        editStartDate.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(day_x).append("/").append(month_x + 1).append("/").append(year_x).append(" "));

    };

    private void updateEndDisplay(){
        editEndDate.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(day_x).append("/").append(month_x + 1).append("/").append(year_x).append(" "));
    };


    public void AddData() {

        addNewProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(editProjectName.getText().toString().trim().length() <= 0 || editDescription.getText().toString().trim().length() <= 0 ||
                                editStartDate.getText().toString().trim().length() <= 0 || editEndDate.getText().toString().trim().length() <= 0 ||
                                editFunds.getText().toString().trim().length() <= 0)
                        {
                            Toast.makeText(AddNewProjectActivity_4a.this, "Please enter data in all fields", Toast.LENGTH_LONG).show();
                        }
                        else {

                            boolean isInserted = backEndDB.insertProjectSpecificData(editProjectName.getText().toString(),
                                    editDescription.getText().toString(), editStartDate.getText().toString(),
                                    editEndDate.getText().toString(), editFunds.getText().toString());

                            if (isInserted == true) {

                                String display;
                                display = "Project Name: " + editProjectName.getText().toString() + "\n" +
                                        "Description: " + editDescription.getText().toString() + "\n" +
                                        "Start Date: " + editStartDate.getText().toString() + "\n" +
                                        "End Date:" + editEndDate.getText().toString() + "\n" +
                                        "Funds :" + editFunds.getText().toString() + "\n" +
                                        "Data Inserted";

                                final Toast box = Toast.makeText(AddNewProjectActivity_4a.this, display, Toast.LENGTH_LONG);

                                box.show();

                                new CountDownTimer(9000, 1000) {

                                    public void onTick(long millisUntilFinished) {
                                        box.show();
                                    }

                                    public void onFinish() {
                                        box.show();
                                    }

                                }.start();
                            } else
                                Toast.makeText(AddNewProjectActivity_4a.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

                            //clearing edit-texts
                            editProjectName.setText("");
                            editDescription.setText("");
                            editStartDate.setText("");
                            editEndDate.setText("");
                            editFunds.setText("");
                        }

                    }

                }
        );

        addNewProjectButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    addNewProjectButton.setTextColor(Color.WHITE);
                    addNewProjectButton.setBackgroundColor(Color.parseColor("#ff0000ff"));
                    return false;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
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
