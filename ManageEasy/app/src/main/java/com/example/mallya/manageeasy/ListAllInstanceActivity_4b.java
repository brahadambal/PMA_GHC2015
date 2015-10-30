package com.example.mallya.manageeasy;

import android.app.Activity;
import android.content.Intent;
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

                    Intent instanceListIntent = new Intent(ListAllInstanceActivity_4b.this, ListIndividualInstanceActivity_4bb.class);
                    startActivity(instanceListIntent);
                }});
        }
    }

}
