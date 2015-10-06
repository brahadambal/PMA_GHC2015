package com.example.mallya.manageeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class UpdateProjectActivity_3 extends AppCompatActivity {

    /*
    There are 4 sub activities here related to (1) Project Specific updates
    (2) Instance Specific Updates (3) Personnel Updates (4) Inventory Updates.
    Each of these have 3 buttons for Adding new, updating and deleting.
     */

    Button addProjectButton, updateProjectButton, deleteProjectButton;
    Button addInstanceButton, updateInstanceButton, deleteInstanceButton;
    Button addPersonnelButton, updatePersonnelButton, deletePersonnelButton;
    Button addInventoryButton, updateInventoryButton, deleteInventoryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_update_project);

        addProjectButton = (Button)findViewById(R.id.Button_AddProject);
        updateProjectButton = (Button)findViewById(R.id.button_UpdateProject);
        deleteProjectButton = (Button)findViewById(R.id.button_DeleteProject);

        addInstanceButton = (Button)findViewById(R.id.button_AddInstance);
        updateInstanceButton = (Button)findViewById(R.id.button_UpdateInstance);
        deleteInstanceButton = (Button)findViewById(R.id.button_DeleteInstance);

        addPersonnelButton = (Button)findViewById(R.id.button_AddPersonnel);
        updatePersonnelButton = (Button)findViewById(R.id.button_UpdatePersonnel);
        deletePersonnelButton = (Button)findViewById(R.id.button_DeletePersonnel);

        addInventoryButton = (Button)findViewById(R.id.button_AddInventory);
        updateInventoryButton = (Button)findViewById(R.id.button_UpdateInventory);
        deleteInventoryButton = (Button)findViewById(R.id.button_DeleteInventory);

        // PROJECT SPECIFIC LISTENERS
        addProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent projectAddIntent = new Intent("com.example.mallya.manageeasy.AddNewProjectActivity_4a");
                        startActivity(projectAddIntent);
                    }
                }
        );

        updateProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent projectUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdateProjectDetailsActivity_4a");
                        startActivity(projectUpdateIntent);
                    }
                }
        );

        deleteProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent projectDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteProjectActivity_4a");
                        startActivity(projectDeleteIntent);
                    }
                }
        );

        // INSTANCE SPECIFIC LISTENERS
        addInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent instanceAddIntent = new Intent("com.example.mallya.manageeasy.AddInstanceActivity_4b");
                        startActivity(instanceAddIntent);
                    }
                }
        );

        updateInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent instanceUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdateInstanceActivity_4b");
                        startActivity(instanceUpdateIntent);
                    }
                }
        );

        deleteInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent instanceDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteInstanceActivity_4b");
                        startActivity(instanceDeleteIntent);
                    }
                }
        );

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
                        Intent inventoryDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteInvetoryActivity_4d");
                        startActivity(inventoryDeleteIntent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_project, menu);
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
