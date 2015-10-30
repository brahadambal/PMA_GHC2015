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
import android.widget.Toast;

/**
 * Created by Mallya on 10/25/2015.
 */
public class ListAllFundsActivity_4f extends Activity {

    DatabaseHelper backEndDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamiclistall);

        int totalNumDonations;


        backEndDB  = new DatabaseHelper (this);
        totalNumDonations = backEndDB.getTotalNumDonations();

        Drawable d = getResources().getDrawable(R.drawable.gradient_blue);
        String donationName;

        for (int i = 1; i <= totalNumDonations; i++) {
            LinearLayout linear = (LinearLayout) findViewById(R.id.layout1);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)
                    ;
            Button btn = new Button(this);
            btn.setId(i);
            final int id_ = btn.getId();

            donationName = backEndDB.getDonationName(i);
            btn.setText(donationName);
            btn.setTextColor(Color.WHITE);

            btn.setBackgroundDrawable(d);
            linear.addView(btn, params);

            btn = ((Button) findViewById(id_));
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Intent donationListIntent = new Intent(ListAllFundsActivity_4f.this, ListIndividualFundsActivity_4ff.class);
                    //To pass "i" variable to the activity. This is the id of the Donation
                    donationListIntent.putExtra("FundID", id_);
                    startActivity(donationListIntent);


                }});
        }
    }



}
