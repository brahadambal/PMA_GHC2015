package com.example.mallya.manageeasy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import com.google.gson.Gson;

/**
 * Created by Mallya on 10/23/2015.
 */
@SuppressLint("SetJavaScriptEnabled")
public class ListIndividualFundsActivity_4ff extends ActionBarActivity{

    DatabaseHelper backEndDB = new DatabaseHelper (this);;
    WebView webView;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcontainer);

       int id = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("FundsID");
        }

        webView = (WebView)findViewById(R.id.overview_project);
        //webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        webView.addJavascriptInterface(new WebAppInterface(id), "Android");

        webView.getSettings().setJavaScriptEnabled(true);
        String display = "Google chart loading...Please wait for a few seconds for the chart to appear";

        final Toast box = Toast.makeText(ListIndividualFundsActivity_4ff.this, display, Toast.LENGTH_LONG);

        box.show();

        new CountDownTimer(9000, 1000)
        {

            public void onTick(long millisUntilFinished) {box.show();}
            public void onFinish() {box.show();}

        }.start();
        webView.loadUrl("file:///android_asset/chartFundsIndividual.html");
    }

    public class WebAppInterface {
        int donateID;

        WebAppInterface(int newID) {
            donateID = newID;
        }


        @JavascriptInterface
        public String getDonationsBy(int donationID) {

            return (backEndDB.getDonationName(donationID));

        }

        // How many projects have the money from this donation
        @JavascriptInterface
        public int getTotalNumProjectDonationsByID() {

            return (backEndDB.getTotalNumProjectDonationsByID(donateID));

        }

        // How many instances have the money from this donation
        @JavascriptInterface
        public int getTotalNumInstanceDonationsByID() {
            return (3);
        }
        //Given a donationID, get the sum total of donations from that donationID allocated as Funds to projectID
        @JavascriptInterface
        public String getFundsFromDonationsForProject() {

            //backEndDB.getFundsFromDonationsForProject(donateID);
            int[] data = new int[]{42000, 24000, 17000, 15400};
            Gson gson = new Gson();
            String numbers = gson.toJson(data);
            return numbers;
        }

        //Given a donationID, get an array of projectIDs that have been allocated funds from this donationID
        @JavascriptInterface
        public String getProjectIDsFromThisDonation() {

            //backEndDB.
            int[] data = new int[]{42, 24, 17, 15};
            Gson gson = new Gson();
            String numbers = gson.toJson(data);
            return numbers;

        }

        @JavascriptInterface
        public String getProjectName(int projectID) {
            return (backEndDB.getProjectName(projectID));
        }

        @JavascriptInterface
        public int getFundsFromDonationsForInstance(int instanceID) {
            return (backEndDB.getFundsFromDonationsForInstance(instanceID));
        }

        @JavascriptInterface
        public String getInstanceName(int instanceID) {
            return (backEndDB.getInstanceName(instanceID));
        }

        @JavascriptInterface
        public int getFundsInFreePool() {
            return (10000);
        }

        @JavascriptInterface
        public int getSumDonationsForProjects() {
            return (20000);
        }


        //Given a donationID, get the sum total of donations from that donationID allocated as Funds to projectID
        @JavascriptInterface
        public String  getFundsFromDonationsForInstances () {

            //backEndDB.getFundsFromDonationsForProject(donateID);
            int[] data = new int[] {42000, 24000, 17000, 15400};
            Gson gson = new Gson();
            String numbers = gson.toJson(data);
            return numbers;
        }

        //Given a donationID, get an array of projectIDs that have been allocated funds from this donationID
        @JavascriptInterface
        public String getInstanceIDsFromThisDonation() {

            //backEndDB.
            int[] data = new int[] {42, 24, 17, 15};
            Gson gson = new Gson();
            String numbers = gson.toJson(data);
            return numbers;

        }
    }


}