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
public class ListAllProjectActivity_4a extends Activity {

    DatabaseHelper backEndDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamiclistall);

        int totalNumProjects;


        backEndDB  = new DatabaseHelper (this);
        totalNumProjects = backEndDB.getTotalNumProjects();

        Drawable d = getResources().getDrawable(R.drawable.gradient_blue);
        String projectName;

        for (int i = 1; i <= totalNumProjects; i++) {
            LinearLayout linear = (LinearLayout) findViewById(R.id.layout1);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)
                    ;
            Button btn = new Button(this);
            btn.setId(i);
            final int id_ = btn.getId();

            projectName = backEndDB.getProjectName(i);
            btn.setText(projectName);
            btn.setTextColor(Color.WHITE);

            btn.setBackgroundDrawable(d);
            linear.addView(btn, params);

            btn = ((Button) findViewById(id_));
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Intent projectListIntent = new Intent(ListAllProjectActivity_4a.this, ListIndividualProjectActivity_4aa.class);
                    startActivity(projectListIntent);
                }});
        }
    }

}


//Other functions for reference
//btn.setBackgroundColor(Color.rgb(70, 80, 90));
//linear.invalidate();
//btn.invalidate();
//Toast.makeText(view.getContext(),
//"Button clicked index = "+id_,Toast.LENGTH_SHORT).show();