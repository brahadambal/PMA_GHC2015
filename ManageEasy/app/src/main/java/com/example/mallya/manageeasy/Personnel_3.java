package com.example.mallya.manageeasy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Personnel_3 extends AppCompatActivity {

    Button addPersonnelButton, updatePersonnelButton, deletePersonnelButton, overviewPersonnelButton, listAllPersonnelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_personnel);

        addPersonnelButton      = (Button) findViewById(R.id.button_AddPersonnel);
        updatePersonnelButton   = (Button) findViewById(R.id.button_UpdatePersonnel);
        deletePersonnelButton   = (Button) findViewById(R.id.button_DeletePersonnel);
        overviewPersonnelButton = (Button) findViewById(R.id.button_Overview);
        listAllPersonnelButton  = (Button) findViewById(R.id.button_ListALLPersonnel);

        // PERSONNEL SPECIFIC LISTENERS

        addPersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personnelAddIntent = new Intent("com.example.mallya.manageeasy.AddPersonnelActivity_4c");
                        startActivity(personnelAddIntent);
                    }
                }
        );

        updatePersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personnelUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdatePersonnelActivity_4c");
                        startActivity(personnelUpdateIntent);
                    }
                }
        );

        deletePersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personnelDeleteIntent = new Intent("com.example.mallya.manageeasy.DeletePersonnelActivity_4c");
                        startActivity(personnelDeleteIntent);
                    }
                }
        );

        overviewPersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personnelOverviewIntent = new Intent(Personnel_3.this, OverViewPersonnelActivity_4c.class);
                        startActivity(personnelOverviewIntent);
                    }
                }
        );

        listAllPersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personnelListAllIntent = new Intent("com.example.mallya.manageeasy.ListAllPersonnelActivity_4c");
                        startActivity(personnelListAllIntent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_charts, menu);
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
