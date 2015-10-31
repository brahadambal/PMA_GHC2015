package com.example.mallya.manageeasy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.gson.Gson;

/**
 * Created by Mallya on 10/25/2015.
 */
@SuppressLint("SetJavaScriptEnabled")
public class OverViewInventoryActivity_4d extends ActionBarActivity {

    WebView webView;
    DatabaseHelper backEndDB = new DatabaseHelper (this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcontainer);

        webView = (WebView) findViewById(R.id.overview_project);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

        webView.getSettings().setJavaScriptEnabled(true);
        String display = "Google chart loading...Please wait for a few seconds for the chart to appear";

        final Toast box = Toast.makeText(OverViewInventoryActivity_4d.this, display, Toast.LENGTH_LONG);

        box.show();

        new CountDownTimer(9000, 1000)
        {
            public void onTick(long millisUntilFinished) {box.show();}
            public void onFinish() {box.show();}

        }.start();
        webView.loadUrl("file:///android_asset/chartInventoryOverview.html");
    }

    public class WebAppInterface {

        @JavascriptInterface
        public int getTotalNumOfInventoryTypes() {
            return 7;
        }

        @JavascriptInterface
        public String getUniqueInventoryTypes() {
            //backEndDB.getFundsFromDonationsForProject(donateID);
            String[] data = new String[] {"books", "uniforms", "food", "medicines", "clothes", "abc", "xyz" };
            Gson gson = new Gson();
            String inventory = gson.toJson(data);
            return inventory;
        }


        @JavascriptInterface
        public int getTotalNumProjects() {
            return (backEndDB.getTotalNumProjects());
        }

        //Given a project ID and inventory name, get the inventory cost of it.
        @JavascriptInterface
        public int getInventoryCostForProject(int projectID, String invetoryName) {
            return (backEndDB.getInventoryCostForProject(projectID, invetoryName));
        }

        @JavascriptInterface
        public String getProjectName(int projectID) {
            return (backEndDB.getProjectName(projectID));
        }

        @JavascriptInterface
        public int getTotalNumInstances(){
            return (backEndDB.getTotalNumInstances());
        }

        //Given an Instance ID and inventory name, get the inventory cost of it.
        @JavascriptInterface
        public int getInventoryCostForInstance(int instanceID, String inventoryName) {
            return (backEndDB.getInventoryCostForInstance(instanceID, inventoryName));
        }

        @JavascriptInterface
        public String getInstanceName(int instanceID) {
            return (backEndDB.getInstanceName(instanceID));
        }







    }

}