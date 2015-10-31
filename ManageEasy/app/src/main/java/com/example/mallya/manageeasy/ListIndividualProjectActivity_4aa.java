package com.example.mallya.manageeasy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.gson.Gson;

/**
 * Created by Mallya on 10/23/2015.
 */
@SuppressLint("SetJavaScriptEnabled")
public class ListIndividualProjectActivity_4aa extends ActionBarActivity{

    DatabaseHelper backEndDB = new DatabaseHelper (this);
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcontainer);

        int id = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("projectID");
        }

        webView = (WebView)findViewById(R.id.overview_project);
        webView.addJavascriptInterface(new WebAppInterface(id), "Android");

        webView.getSettings().setJavaScriptEnabled(true);
        String display = "Google chart loading...Please wait for a few seconds for the chart to appear";

        final Toast box = Toast.makeText(ListIndividualProjectActivity_4aa.this, display, Toast.LENGTH_LONG);

        box.show();

        new CountDownTimer(9000, 1000)
        {

            public void onTick(long millisUntilFinished) {box.show();}
            public void onFinish() {box.show();}

        }.start();
        webView.loadUrl("file:///android_asset/chartProjectIndividual.html");
    }

    public class WebAppInterface {

        int projectID;

        WebAppInterface(int newID) {
            projectID = newID;
        }

        @JavascriptInterface
        public int getTotalNumProjectLocations() {
            //return (backEndDB.getNumProjectLocations(projectID));
            return 6;
        }

        @JavascriptInterface
        public int getNumInstancesPerLocation(String location) {
            return (backEndDB.getNumInstancesPerLocation(projectID, location));
        }

        @JavascriptInterface
        public int getNumPersonnelPerInstance(int instanceID) {
            return (backEndDB.getNumPersonnelPerInstance(instanceID));
        }

        @JavascriptInterface
        public String getUniqueLocationsForProjects() {
            String[] data = new String[] {"Bangalore", "Mysore", "Bidar", "Tumkur", "Mangalore", "Udupi"};
            Gson gson = new Gson();
            String locations = gson.toJson(data);
            return locations;
        }

        @JavascriptInterface
       public int getNumProjectsForLocation(String location){

           return (backEndDB.getNumProjectsForLocation(location));

       }

        @JavascriptInterface
        public int getNumPersonnelPerProject(int num) {
            int tempNum;
             switch(num)
             {
                 case 1: tempNum=10;
                 break;

                 case 2: tempNum=20;
                 break;

                 case 3: tempNum=30;
                 break;

                 case 4: tempNum=40;
                 break;

                 case 5: tempNum=10;
                 break;

                 default: tempNum=1;
                 break;
             }
            return tempNum;
        }


    }

}