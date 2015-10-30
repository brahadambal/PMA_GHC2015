package com.example.mallya.manageeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Funds_3 extends AppCompatActivity {

    Button addFundsButton, updateFundsButton, deleteFundsButton, overviewFundsButton, listAllFundsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_funds);

        addFundsButton      = (Button) findViewById(R.id.button_AddFunds);
        updateFundsButton   = (Button) findViewById(R.id.button_UpdateFunds);
        deleteFundsButton   = (Button) findViewById(R.id.button_DeleteFunds);
        overviewFundsButton = (Button) findViewById(R.id.button_Overview);
        listAllFundsButton  = (Button) findViewById(R.id.button_ListAllFunds);

        // FUNDS AND DONATION SPECIFIC LISTENERS
        // INVENTORY SPECIFIC LISTENERS

        addFundsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent fundsAddIntent = new Intent("com.example.mallya.manageeasy.AddFundsActivity_4f");
                        startActivity(fundsAddIntent);
                    }
                }
        );

        updateFundsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent fundsUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdateFundsActivity_4f");
                        startActivity(fundsUpdateIntent);
                    }
                }
        );

        deleteFundsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent fundsDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteFundsActivity_4f");
                        startActivity(fundsDeleteIntent);
                    }
                }
        );

        overviewFundsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent fundsOverviewIntent = new Intent(Funds_3.this, OverViewFundsActivity_4f.class);
                        startActivity(fundsOverviewIntent);
                    }
                }
        );

        listAllFundsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent fundsListAllIntent = new Intent("com.example.mallya.manageeasy.ListAllFundsActivity_4f");
                        startActivity(fundsListAllIntent);
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
