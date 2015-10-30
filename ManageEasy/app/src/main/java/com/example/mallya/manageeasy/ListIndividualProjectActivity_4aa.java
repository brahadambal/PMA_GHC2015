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
public class ListIndividualProjectActivity_4aa extends ActionBarActivity{

    DatabaseHelper backEndDB = new DatabaseHelper (this);;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcontainer);

        webView = (WebView)findViewById(R.id.overview_project);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

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

       public String getProjectName1(int projectID){

           return (backEndDB.getProjectName(projectID));

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

        @JavascriptInterface
        public String getProjectName(int num) {

            String tempStr;

            switch(num)
            {
                case 1: tempStr="Girl Edu";
                break;

                case 2: tempStr="Health Care";
                break;

                case 3: tempStr="Child Care";
                break;

                case 4: tempStr="Project Revamp";
                break;

                case 5: tempStr="Food For ALL";
                break;

                default: tempStr="No Project";
                break;
            }
            return tempStr;
        }

        @JavascriptInterface
        public int getProjectFunds(int num){

            int tempNum;
            switch(num)
            {
                case 1: tempNum=10000;
                    break;

                case 2: tempNum=20000;
                    break;

                case 3: tempNum=60000;
                    break;

                case 4: tempNum=25000;
                    break;

                case 5: tempNum=15000;
                    break;

                default: tempNum=1;
                    break;
            }
            return tempNum;
        }

        @JavascriptInterface
        public int getNumProjectLocations(int num){

            int tempNum;
            switch(num)
            {
                case 1: tempNum=5;
                    break;

                case 2: tempNum=2;
                    break;

                case 3: tempNum=6;
                    break;

                case 4: tempNum=2;
                    break;

                case 5: tempNum=8;
                    break;

                default: tempNum=1;
                    break;
            }
            return tempNum;
        }

        @JavascriptInterface
        public int getNumProjectInstances(int num){

            int tempNum;
            switch(num)
            {
                case 1: tempNum=8;
                    break;

                case 2: tempNum=4;
                    break;

                case 3: tempNum=10;
                    break;

                case 4: tempNum=4;
                    break;

                case 5: tempNum=8;
                    break;

                default: tempNum=1;
                    break;
            }
            return tempNum;

        }

        @JavascriptInterface
        public int getNumProjectSuccessStories(int num){

            int tempNum;
            switch(num)
            {
                case 1: tempNum=50;
                    break;

                case 2: tempNum=20;
                    break;

                case 3: tempNum=60;
                    break;

                case 4: tempNum=20;
                    break;

                case 5: tempNum=80;
                    break;

                default: tempNum=1;
                    break;
            }
            return tempNum;

        }
    }

}