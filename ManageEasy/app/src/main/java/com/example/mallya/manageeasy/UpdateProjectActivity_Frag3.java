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
    Button addInventoryButton, updateInventoryButton, deleteInventoryButton;

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

        addInventoryButton = (Button) view.findViewById(R.id.button_AddInventory);
        updateInventoryButton = (Button) view.findViewById(R.id.button_UpdateInventory);
        deleteInventoryButton = (Button) view.findViewById(R.id.button_DeleteInventory);

        // INVENTORY SPECIFIC LISTENERS
        addInventoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inventoryAddIntent = new Intent("com.example.mallya.manageeasy.AddInventoryActivity_4d");
                        startActivity(inventoryAddIntent);
                    }
                }
        );

        updateInventoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inventoryUpdateIntent = new Intent("com.example.mallya.manageeasy.UpdateInventoryActivity_4d");
                        startActivity(inventoryUpdateIntent);
                    }
                }
        );

        deleteInventoryButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inventoryDeleteIntent = new Intent("com.example.mallya.manageeasy.DeleteInvetoryActivity_4d");
                        startActivity(inventoryDeleteIntent);
                    }
                }
        );

        return view;
    }
}
