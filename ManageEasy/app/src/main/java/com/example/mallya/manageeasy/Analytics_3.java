package com.example.mallya.manageeasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Analytics_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_analytics);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_charts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

  /*
    Under Analytics we can have
    1. Have we exceeded the fund collected for a particular project and used from free pool?
        Projects Vs Funds allocated per project
        a. Need Sum of Funds donated per project from the Funds table.   int getFundsDonatedForProject (Project ID)
        b. Need Funds allocated per project for a project ID.            Function already mentioned above.
        c. Need Sum of Funds donated not specifically for any project   int getFreeFundsDonated()

    2. Who is our patron contributor. Based on same pan card.
        a. Sum of Donations per contributor.                        int getSumofDonations (String DonateBy)

    3. Funds Consumed till now for a project - inventory-salary  = expense.
       a.  Get the Funds allocated per project.         Function already mentioned above.
       b.  Sum of all Salaries of all the volunteers under a project   int getSumSalaryOfPersonnel  (int ProjectID)
       c.  Sum of all the cost of inventories under a project          int getSumCostOfInventories  (int ProjectID)

    4. How Many female volunteers per project..
        a.  Get the count of all the female volunteers per project    int getNumFemalePersonnel  (int ProjectID)
        This is useful in projects involving girl child.

     */

