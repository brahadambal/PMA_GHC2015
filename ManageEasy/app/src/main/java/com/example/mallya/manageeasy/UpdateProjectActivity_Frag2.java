package com.example.mallya.manageeasy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Mallya on 10/18/2015.
 */


public class UpdateProjectActivity_Frag2 extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    public static Activity activity;
    Button addInstanceButton, updateInstanceButton, deleteInstanceButton, overviewInstanceButton, listAllInstanceButton;

    // newInstance constructor for creating fragment with arguments
    public static UpdateProjectActivity_Frag2 newInstance(int page, String title, Activity _activity) {
        UpdateProjectActivity_Frag2 fragmentSecond = new UpdateProjectActivity_Frag2();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentSecond.setArguments(args);
        activity = _activity;
        return fragmentSecond;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");


    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upa_fragment_second, container, false);

        addInstanceButton = (Button)view.findViewById(R.id.button_AddInstance);
        updateInstanceButton = (Button)view.findViewById(R.id.button_UpdateInstance);
        deleteInstanceButton = (Button)view.findViewById(R.id.button_DeleteInstance);
        overviewInstanceButton = (Button)view.findViewById(R.id.button_OverviewInstance);
        listAllInstanceButton = (Button)view.findViewById(R.id.button_ListALLInstances);

        // INSTANCE SPECIFIC LISTENERS
        addInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent instanceAddIntent = new Intent("com.example.mallya.manageeasy.AddInstanceActivity_4b");
                        startActivity(instanceAddIntent);
                    }
                }
        );

        updateInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent instanceUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdateInstanceActivity_4b");
                        startActivity(instanceUpdateIntent);
                    }
                }
        );

        deleteInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent instanceDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteInstanceActivity_4b");
                        startActivity(instanceDeleteIntent);
                    }
                }
        );

        overviewInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent instanceOverviewIntent = new Intent("com.example.mallya.manageeasy.OverViewInstanceActivity_4b");
                        startActivity(instanceOverviewIntent);
                    }
                }
        );

        listAllInstanceButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent instanceListAllIntent = new Intent("com.example.mallya.manageeasy.ListAllInstanceActivity_4b");
                        startActivity(instanceListAllIntent);
                    }
                }
        );
        return view;
    }
}