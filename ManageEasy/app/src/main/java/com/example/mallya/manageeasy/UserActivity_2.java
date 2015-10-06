package com.example.mallya.manageeasy;

// THIS IS THE FISRT ACTIVITY AFTER LOGIN

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class UserActivity_2 extends AppCompatActivity {

    private static ImageButton project_button;
    private static ImageButton chart_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_user);
        project_button = (ImageButton) findViewById(R.id.imageButton_Project);
        chart_button = (ImageButton) findViewById(R.id.imageButton_chart);

        project_button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent projectIntent = new Intent("com.example.mallya.manageeasy.UpdateProjectActivity_3");
                        startActivity(projectIntent);
                    }
                }
        );

        chart_button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent chartIntent = new Intent("com.example.mallya.manageeasy.ChartsActivity_3");
                        startActivity(chartIntent);
                    }
                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
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
