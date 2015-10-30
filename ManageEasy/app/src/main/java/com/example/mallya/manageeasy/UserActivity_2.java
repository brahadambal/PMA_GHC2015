package com.example.mallya.manageeasy;

// THIS IS THE FISRT ACTIVITY AFTER LOGIN

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class UserActivity_2 extends AppCompatActivity {

    private static ImageButton project_button;
    private static ImageButton chart_button;
    private static ImageButton personnel_button;
    private static ImageButton inventory_button;
    private static ImageButton funds_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_user);
        project_button = (ImageButton) findViewById(R.id.imageButton_Project);
        chart_button = (ImageButton) findViewById(R.id.imageButton_Analytics);
        personnel_button = (ImageButton) findViewById(R.id.imageButton_Personnel);
        inventory_button = (ImageButton) findViewById(R.id.imageButton_Inventory);
        funds_button = (ImageButton) findViewById(R.id.imageButton_Funds);

        project_button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent projectIntent = new Intent("com.example.mallya.manageeasy.ProjectActivity_3");
                        startActivity(projectIntent);
                    }
                }
        );

        chart_button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent chartIntent = new Intent("com.example.mallya.manageeasy.Analytics_3");
                        startActivity(chartIntent);
                    }
                }
        );

        personnel_button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent chartIntent = new Intent("com.example.mallya.manageeasy.Personnel_3");
                        startActivity(chartIntent);
                    }
                }
        );

        inventory_button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent chartIntent = new Intent("com.example.mallya.manageeasy.Inventory_3");
                        startActivity(chartIntent);
                    }
                }
        );

        funds_button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent chartIntent = new Intent("com.example.mallya.manageeasy.Funds_3");
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
