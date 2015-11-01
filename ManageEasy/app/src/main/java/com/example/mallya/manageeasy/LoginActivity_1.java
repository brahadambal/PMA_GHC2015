package com.example.mallya.manageeasy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity_1 extends Activity {

    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_button;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_login);

        LoginButton();
    }

    public void LoginButton() {
        username = (EditText)findViewById(R.id.editText_UserName);
        password = (EditText)findViewById(R.id.editText_Password);
        attempts = (TextView)findViewById(R.id.TextView_numberOfAttempts);
        login_button = (Button)findViewById(R.id.button_LOGIN);

        attempts.setText(Integer.toString(attempt_counter));

        login_button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (username.getText().toString().equals("Admin") &&
                                password.getText().toString().equals("admin")) {
                            Toast.makeText(LoginActivity_1.this, "User and password is correct",
                                    Toast.LENGTH_SHORT).show();

                            //Test elements into the db
                            DatabaseHelper backEndDb = new DatabaseHelper(LoginActivity_1.this);
                            backEndDb.insertTestdata();

                            Intent intent = new Intent("com.example.mallya.manageeasy.UserActivity_2");
                            startActivity(intent);
                        } else {
                            attempt_counter--;
                            attempts.setText(Integer.toString(attempt_counter));
                            Toast.makeText(LoginActivity_1.this, "User and password is not correct",
                                    Toast.LENGTH_SHORT).show();
                            if (attempt_counter == 0) {
                                login_button.setEnabled(false);
                            }

                        }
                    }
                }

        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
