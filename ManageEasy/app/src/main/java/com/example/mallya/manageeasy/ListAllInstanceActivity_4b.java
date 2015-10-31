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
 * Created by Mallya on 10/23/2015.
 */
public class ListAllInstanceActivity_4b extends Activity {

    DatabaseHelper backEndDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamiclistall);

        int totalNumInstances;

        backEndDB  = new DatabaseHelper (this);
        totalNumInstances = backEndDB.getTotalNumInstances();

        Drawable d = getResources().getDrawable(R.drawable.gradient_blue);
        String instanceName;

        for (int i = 1; i <= totalNumInstances; i++) {
            LinearLayout linear = (LinearLayout) findViewById(R.id.layout1);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)
                    ;
            Button btn = new Button(this);
            btn.setId(i);
            final int id_ = btn.getId();

            instanceName = backEndDB.getInstanceName(i);
            btn.setText(instanceName);
            btn.setTextColor(Color.WHITE);

            btn.setBackgroundDrawable(d);
            linear.addView(btn, params);

            btn = ((Button) findViewById(id_));
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Cursor result = backEndDB.getIndividualInstanceData(id_);
                    if (result.getCount() == 0){
                        //Toast.makeText(ListAllFundsActivity_4f.this, "No data available", Toast.LENGTH_LONG).show();
                        showAllInstanceData("Error", "No Data found");
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (result.moveToNext()) {
                        buffer.append("ID: "+ result.getString(0)+ "\n");
                        buffer.append("Instance Name: "+ result.getString(1)+ "\n");
                        buffer.append("Project Name: "+ result.getString(2)+ "\n");
                        buffer.append("Description: "+ result.getString(3)+ "\n");
                        buffer.append("Funds: "+ result.getString(4)+ "\n");
                        buffer.append("Location: "+ result.getString(5)+ "\n");
                        buffer.append("DonatedBY: "+ result.getString(6)+ "\n");
                    }
                    //Show all data
                    showAllInstanceData("Personnel Data", buffer.toString());
                }});
        }
    }

    public void showAllInstanceData(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
