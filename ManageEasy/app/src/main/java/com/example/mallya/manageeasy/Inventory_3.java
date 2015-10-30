package com.example.mallya.manageeasy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Inventory_3 extends AppCompatActivity {

    Button addInventoryButton, updateInventoryButton, deleteInventoryButton, overviewInventoryButton, listAllPersonnelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_inventory);

        addInventoryButton      = (Button) findViewById(R.id.button_AddInventory);
        updateInventoryButton   = (Button) findViewById(R.id.button_UpdateInventory);
        deleteInventoryButton   = (Button) findViewById(R.id.button_DeleteInventory);
        overviewInventoryButton = (Button) findViewById(R.id.button_Overview);
        listAllPersonnelButton  = (Button) findViewById(R.id.button_ListALLInventory);

        // INVENTORY SPECIFIC LISTENERS

        addInventoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inventoryAddIntent = new Intent("com.example.mallya.manageeasy.AddInventoryActivity_4d");
                        startActivity(inventoryAddIntent);
                    }
                }
        );

        updateInventoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inventoryUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdateInventoryActivity_4d");
                        startActivity(inventoryUpdateIntent);
                    }
                }
        );

        deleteInventoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inventoryDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteInventoryActivity_4d");
                        startActivity(inventoryDeleteIntent);
                    }
                }
        );

        overviewInventoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inventoryOverviewIntent = new Intent(Inventory_3.this, OverViewInventoryActivity_4d.class);
                        startActivity(inventoryOverviewIntent);
                    }
                }
        );

        listAllPersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inventoryListAllIntent = new Intent("com.example.mallya.manageeasy.ListAllInventoryActivity_4d");
                        startActivity(inventoryListAllIntent);
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
