package com.example.mallya.manageeasy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Mallya on 10/23/2015.
 */

@SuppressLint("SetJavaScriptEnabled")
public class OverViewSuccessStoryActivity_4e extends ActionBarActivity {

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

        final Toast box = Toast.makeText(OverViewSuccessStoryActivity_4e.this, display, Toast.LENGTH_LONG);

        box.show();

        new CountDownTimer(9000, 1000)
        {

            public void onTick(long millisUntilFinished) {box.show();}
            public void onFinish() {box.show();}

        }.start();
        webView.loadUrl("file:///android_asset/chartSuccessStoryOverview.html");
    }

    public class WebAppInterface {

        @JavascriptInterface
        public int getTotalNumProjects() {
            return (backEndDB.getTotalNumProjects());
        }

        @JavascriptInterface
        public int getNumProjectSuccessStories(int projectID) {
            return (backEndDB.getNumProjectSuccessStories(projectID));
        }

        @JavascriptInterface
        public String getProjectName(int projectID) {
            return (backEndDB.getProjectName(projectID));
        }

        @JavascriptInterface
        public int getTotalNumInstances() {
            return (backEndDB.getTotalNumInstances());
        }

        @JavascriptInterface
        public int getNumInstanceSuccessStories(int instanceID) {
            return (backEndDB.getNumInstanceSuccessStories(instanceID));
        }

        @JavascriptInterface
        public String getInstanceName(int instanceID){
            return (backEndDB.getInstanceName(instanceID));
        }

        @JavascriptInterface
        public int getTotalNumSuccessStory() {
            return (backEndDB.getTotalNumSuccessStory());
        }

        @JavascriptInterface
        public String getSuccessStoryName(int successStoryID){
            return (backEndDB.getSuccessStoryName(successStoryID));
        }
    }

}