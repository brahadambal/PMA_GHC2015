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


public class UpdateProjectActivity_Frag3 extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    public static Activity activity;
    Button addSStoryButton, updateSStoryButton, deleteSStoryButton,overviewSStoryButton, listAllSStoryButton;

    // newInstance constructor for creating fragment with arguments
    public static UpdateProjectActivity_Frag3 newInstance(int page, String title, Activity _activity) {
        UpdateProjectActivity_Frag3 fragmentThird = new UpdateProjectActivity_Frag3();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentThird.setArguments(args);
        activity = _activity;
        return fragmentThird;
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
        View view = inflater.inflate(R.layout.upa_fragment_third, container, false);
        //TextView tvLabel = (TextView) view.findViewById(R.id.textView1);
        //tvLabel.setText(page + " -- " + title);

        addSStoryButton = (Button)view.findViewById(R.id.button_AddSuccessStory);
        updateSStoryButton = (Button)view.findViewById(R.id.button_UpdateSuccessStory);
        deleteSStoryButton = (Button)view.findViewById(R.id.button_DeleteSuccessStory);
        overviewSStoryButton = (Button)view.findViewById(R.id.Button_Overview);
        listAllSStoryButton = (Button)view.findViewById(R.id.Button_ListALLSuccssStory);

        // INSTANCE SPECIFIC LISTENERS
        addSStoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent successStoryAddIntent = new Intent("com.example.mallya.manageeasy.AddSuccessStoryActivity_4e");
                        startActivity(successStoryAddIntent);
                    }
                }
        );

        updateSStoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent successStoryUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdateSuccessStoryActivity_4e");
                        startActivity(successStoryUpdateIntent);
                    }
                }
        );

        deleteSStoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent successStoryDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteSuccessStoryActivity_4e");
                        startActivity(successStoryDeleteIntent);
                    }
                }
        );

        overviewSStoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent successStoryOverviewIntent = new Intent("com.example.mallya.manageeasy.OverViewSuccessStoryActivity_4e");
                        startActivity(successStoryOverviewIntent);
                    }
                }
        );

        listAllSStoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent successStoryOverviewIntent = new Intent("com.example.mallya.manageeasy.ListAllSuccessStoryActivity_4e");
                        startActivity(successStoryOverviewIntent);
                    }
                }
        );
        return view;
    }
}