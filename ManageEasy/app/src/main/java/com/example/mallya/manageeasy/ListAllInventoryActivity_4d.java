package com.example.mallya.manageeasy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Mallya on 10/25/2015.
 */
public class ListAllInventoryActivity_4d extends Activity {

    DatabaseHelper backEndDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamiclistall);

        int totalNumInventory;


        backEndDB  = new DatabaseHelper (this);
        totalNumInventory = backEndDB.getTotalNumInventory();

        Drawable d = getResources().getDrawable(R.drawable.gradient_blue);
        String inventoryName;

        for (int i = 1; i <= totalNumInventory; i++) {
            LinearLayout linear = (LinearLayout) findViewById(R.id.layout1);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)
                    ;
            Button btn = new Button(this);
            btn.setId(i);
            final int id_ = btn.getId();

            inventoryName = backEndDB.getInventoryName(i);
            btn.setText(inventoryName);
            btn.setTextColor(Color.WHITE);

            btn.setBackgroundDrawable(d);
            linear.addView(btn, params);

            btn = ((Button) findViewById(id_));
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Cursor result = backEndDB.getIndividualInventoryData(id_);
                    if (result.getCount() == 0){
                        //Toast.makeText(ListAllFundsActivity_4f.this, "No data available", Toast.LENGTH_LONG).show();
                        showAllInventoryData("Error", "No Data found");
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (result.moveToNext()) {
                        buffer.append("ID: "+ result.getString(0)+ "\n");
                        buffer.append("Inventory Name: "+ result.getString(1)+ "\n");
                        buffer.append("Description: "+ result.getString(2)+ "\n");
                        buffer.append("Instance Name: "+ result.getString(3)+ "\n");
                        buffer.append("Inventory Cost "+ result.getString(4)+ "\n");
                    }

                    //Show all data
                    showAllInventoryData("Inventory Data", buffer.toString());
                }});
        }
    }

    public void showAllInventoryData(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}
