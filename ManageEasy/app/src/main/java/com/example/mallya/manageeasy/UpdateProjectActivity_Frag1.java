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

public class UpdateProjectActivity_Frag1  extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    public static Activity activity;
    Button addProjectButton, updateProjectButton, deleteProjectButton, overviewProjectButton, listAllProjectButton;

    // newInstance constructor for creating fragment with arguments
    public static UpdateProjectActivity_Frag1 newInstance(int page, String title, Activity _activity) {
        UpdateProjectActivity_Frag1 fragmentFirst = new UpdateProjectActivity_Frag1();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        activity = _activity;
        return fragmentFirst;
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
        View view = inflater.inflate(R.layout.upa_fragment_first, container, false);

        addProjectButton = (Button)view.findViewById(R.id.button_AddProject);
        updateProjectButton = (Button)view.findViewById(R.id.button_UpdateProject);
        deleteProjectButton = (Button)view.findViewById(R.id.button_DeleteProject);
        overviewProjectButton = (Button)view.findViewById(R.id.button_Overview);
        listAllProjectButton = (Button)view.findViewById(R.id.button_ListALLprojects);

        // PROJECT SPECIFIC LISTENERS
        addProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent projectAddIntent = new Intent("com.example.mallya.manageeasy.AddNewProjectActivity_4a");
                        startActivity(projectAddIntent);
                    }
                }
        );

        updateProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent projectUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdateProjectDetailsActivity_4a");
                        startActivity(projectUpdateIntent);
                    }
                }
        );

        deleteProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent projectDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteProjectActivity_4a");
                        startActivity(projectDeleteIntent);
                    }
                }
        );

        overviewProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent projectOverviewIntent = new Intent(UpdateProjectActivity_Frag1.this.getActivity(), OverViewProjectActivity_4a.class);
                        startActivity(projectOverviewIntent);
                    }
                }
        );

        listAllProjectButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent projectListAllIntent = new Intent("com.example.mallya.manageeasy.ListAllProjectActivity_4a");
                        startActivity(projectListAllIntent);
                    }
                }
        );

        return view;
    }
}
