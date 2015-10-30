package com.example.mallya.manageeasy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Mallya on 10/23/2015.
 */
@SuppressLint("SetJavaScriptEnabled")
public class OverViewProjectActivity_4a extends ActionBarActivity {

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

        final Toast box = Toast.makeText(OverViewProjectActivity_4a.this, display, Toast.LENGTH_LONG);

        box.show();

        new CountDownTimer(9000, 1000)
        {

            public void onTick(long millisUntilFinished) {box.show();}
            public void onFinish() {box.show();}

        }.start();
        webView.loadUrl("file:///android_asset/chartProjectOverview.html");
    }

    public class WebAppInterface {

       @JavascriptInterface
        public int getTotalNumProjects() {

            return (backEndDB.getTotalNumProjects());
        }

        @JavascriptInterface
        public int getNumPersonnelPerProject(int projectID) {

            return (backEndDB.getNumPersonnelPerProject(projectID));
        }

        @JavascriptInterface
        public String getProjectName(int projectID) {

            return (backEndDB.getProjectName(projectID));
        }

        @JavascriptInterface
        public int getProjectFunds(int projectID) {

            return (backEndDB.getProjectFunds(projectID));
        }

        @JavascriptInterface
        public int getNumProjectLocations(int projectID) {

            return (backEndDB.getNumProjectLocations(projectID));
        }

        @JavascriptInterface
        public int getNumProjectInstances(int projectID) {

            return (backEndDB.getNumProjectInstances(projectID));
        }

        @JavascriptInterface
        public int getNumProjectSuccessStories(int projectID) {

            return (backEndDB.getNumProjectSuccessStories(projectID));
        }

    }

}