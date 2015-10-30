package com.example.mallya.manageeasy;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ProjectPagerAdapter extends FragmentPagerAdapter {
    public Activity activity;
    private static int NUM_ITEMS = 3;

    public ProjectPagerAdapter(FragmentManager fragmentManager) {
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
                return UpdateProjectActivity_Frag3.newInstance(2, "SuccessStories", this.activity);
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
                return ("Success Story");
            default:
                return null;
        }
    }

}
