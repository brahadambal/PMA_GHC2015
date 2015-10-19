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
public class UpdateProjectActivity_Frag4 extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    public static Activity activity;
    Button addPersonnelButton, updatePersonnelButton, deletePersonnelButton;

    // newInstance constructor for creating fragment with arguments
    public static UpdateProjectActivity_Frag4 newInstance(int page, String title, Activity _activity) {
        UpdateProjectActivity_Frag4 fragmentFourth = new UpdateProjectActivity_Frag4();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFourth.setArguments(args);
        activity = _activity;
        return fragmentFourth;
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
        View view = inflater.inflate(R.layout.upa_fragment_fourth, container, false);
        //TextView tvLabel = (TextView) view.findViewById(R.id.textView1);
        //tvLabel.setText(page + " -- " + title);

        addPersonnelButton = (Button) view.findViewById(R.id.button_AddPersonnel);
        updatePersonnelButton = (Button) view.findViewById(R.id.button_UpdatePersonnel);
        deletePersonnelButton = (Button) view.findViewById(R.id.button_DeletePersonnel);

        // PERSONNEL SPECIFIC LISTENERS

        addPersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personnelAddIntent = new Intent("com.example.mallya.manageeasy.AddPersonnelActivity_4c");
                        startActivity(personnelAddIntent);
                    }
                }
        );

        updatePersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personnelUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdatePersonnelActivity_4c");
                        startActivity(personnelUpdateIntent);
                    }
                }
        );

        deletePersonnelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personnelDeleteIntent = new Intent("com.example.mallya.manageeasy.DeletePersonnelActivity_4c");
                        startActivity(personnelDeleteIntent);
                    }
                }
        );

        return view;
    }
}
