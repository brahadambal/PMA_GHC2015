package com.example.mallya.manageeasy;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddPersonnelActivity_4c extends AppCompatActivity {

    DatabaseHelper backEndDB;
    EditText editPersonnelName, editPersonnelInstance, editContact, editAddress, editSalary,editJoinDate, editResignDate, editPersonnelGender;
    Button addNewPersonnelButton;
    static final int DIALOG_ID = 0, DIALOG_ID1 = 1;
    int year_x, month_x, day_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4c_add_personnel);

        backEndDB               = new DatabaseHelper (this);

        editPersonnelName       = (EditText)findViewById(R.id.editText_PersonnelName);
        editPersonnelInstance   = (EditText)findViewById(R.id.editText_PersonnelInstanceName);
        editContact             = (EditText)findViewById(R.id.editText_PersonnelContact);
        editAddress             = (EditText)findViewById(R.id.editText_PersonnelAddress);
        editSalary              = (EditText)findViewById(R.id.editText_PersonnelSalary);
        editJoinDate            = (EditText)findViewById(R.id.editText_JoinDate);
        editResignDate          = (EditText)findViewById(R.id.editText_ResignDate);
        editPersonnelGender     = (EditText)findViewById(R.id.editText_PersonnelGender);

        addNewPersonnelButton   = (Button)findViewById(R.id.button_AddNewPersonnel);

        // To get the current date
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnJoinButtonClick();
        showDialogOnResignButtonClick();

        //TODO, Validate that ResignDate is greater than Join date.

        AddData();
    }

    public void showDialogOnJoinButtonClick() {

        editJoinDate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    public void showDialogOnResignButtonClick() {

        editResignDate.setOnClickListener(
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
                return new DatePickerDialog(this, dpickerJoinListener, year_x, month_x, day_x);
            }

            if (id == DIALOG_ID1) {
                return new DatePickerDialog(this, dpickerResignListener, year_x, month_x, day_x);
            }
            return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerJoinListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;

            updateJoinDisplay();
        }
    };

    private DatePickerDialog.OnDateSetListener dpickerResignListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;

            updateResignDisplay();
        }
    };


    private void updateJoinDisplay() {

        editJoinDate.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(day_x).append("/").append(month_x + 1).append("/").append(year_x).append(" "));

    };

    private void updateResignDisplay(){
        editResignDate.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(day_x).append("/").append(month_x + 1).append("/").append(year_x).append(" "));
    };


    public void AddData() {

        addNewPersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(editPersonnelName.getText().toString().trim().length() <= 0 || editPersonnelInstance.getText().toString().trim().length() <= 0 ||
                                editContact.getText().toString().trim().length() <= 0 || editAddress.getText().toString().trim().length() <= 0 ||
                                editSalary.getText().toString().trim().length() <= 0 || editJoinDate.getText().toString().trim().length() <= 0 ||
                                editResignDate.getText().toString().trim().length() <= 0 || editPersonnelGender.getText().toString().trim().length() <= 0 )
                        {

                            Toast.makeText(AddPersonnelActivity_4c.this, "Please enter data in all fields", Toast.LENGTH_LONG).show();
                        }
                        else {
                            boolean isInserted = backEndDB.insertPersonnelSpecificData(editPersonnelName.getText().toString(), editPersonnelInstance.getText().toString(),
                                    editContact.getText().toString(), editAddress.getText().toString(), editSalary.getText().toString(),
                                    editJoinDate.getText().toString(), editResignDate.getText().toString(), editPersonnelGender.getText().toString());

                            if (isInserted == true)
                                Toast.makeText(AddPersonnelActivity_4c.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(AddPersonnelActivity_4c.this, "Data Not Inserted", Toast.LENGTH_LONG).show();

                            //clearing edit-texts
                            editPersonnelName.setText("");
                            editPersonnelInstance.setText("");
                            editContact.setText("");
                            editAddress.setText("");
                            editSalary.setText("");
                            editJoinDate.setText("");
                            editResignDate.setText("");
                            editPersonnelGender.setText("");
                        }
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
