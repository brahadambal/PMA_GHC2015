package com.example.mallya.manageeasy;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    public Activity activity;
    private static int NUM_ITEMS = 4;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return UpdateProjectActivity_Frag1.newInstance(0, "Projects", this.activity);
            case 1: // Fragment # 1 - This will show SecondFragment
                return UpdateProjectActivity_Frag2.newInstance(1, "Instances", this.activity);
            case 2: // Fragment # 2 - This will show ThirdFragment
                return UpdateProjectActivity_Frag3.newInstance(2, "Inventory", this.activity);
            case 3: // Fragment # 3 - This will show FourthFragment
                return UpdateProjectActivity_Frag4.newInstance(3, "Personnel", this.activity);
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return ("Projects");
            case 1:
                return ("Instances");
            case 2:
                return ("Inventory");
            case 3:
                return ("Personnel");
            default:
                return null;
        }
    }

}
