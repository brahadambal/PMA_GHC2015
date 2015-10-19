package com.example.mallya.manageeasy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;

/**
 * Created by Mallya on 10/4/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Projects.db";

    // PROJECT SPECIFIC TABLE ENTRIES
    public static final String TABLE_1="Project_table";
    public static final String TABLE1_COL1 ="ID";
    public static final String TABLE1_COL2 ="ProjectName";
    public static final String TABLE1_COL3 ="Description";
    public static final String TABLE1_COL4 ="StartDate";
    public static final String TABLE1_COL5 ="EndDate";
    public static final String TABLE1_COL6 ="Funds";

    // INSTANCE SPECIFIC TABLE ENTRIES
    public static final String TABLE_2="Instance_table";
    public static final String TABLE2_COL1="ID";
    public static final String TABLE2_COL2="InstanceName";
    public static final String TABLE2_COL3="ProjectName";
    public static final String TABLE2_COL4="Description";
    public static final String TABLE2_COL5="Fund";
    public static final String TABLE2_COL6="Location";

    // PERSONNEL SPECIFIC TABLE ENTRIES
    public static final String TABLE_3="Personnel_table";
    public static final String TABLE3_COL1="ID";
    public static final String TABLE3_COL2="PersonnelName";
    public static final String TABLE3_COL3="InstanceName";
    public static final String TABLE3_COL4="Contact";
    public static final String TABLE3_COL5="Address";
    public static final String TABLE3_COL6="Salary";
    public static final String TABLE3_COL7="JoiningDate";
    public static final String TABLE3_COL8="ResignDate";

    // INVENTORY SPECIFIC TABLE ENTRIES
    public static final String TABLE_4="Inventory_table";
    public static final String TABLE4_COL1="ID";
    public static final String TABLE4_COL2="InventoryName";
    public static final String TABLE4_COL3="InventoryDescription";
    public static final String TABLE4_COL4="InstanceName";
    public static final String TABLE4_COL5="InventoryCost";


    // DONATIONS AND FUNDS SPECIFIC TABLE ENTRIES
    public static final String TABLE_5="Donation_table";
    public static final String TABLE5_COL1="ID";
    public static final String TABLE5_COL2="DonatedBy";
    public static final String TABLE5_COL3="Funds";
    public static final String TABLE5_COL4="ProjectName";
    public static final String TABLE5_COL5="InstanceName";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // TODO DO not create Tables if they exist already. :D

        db.execSQL("create table  " + TABLE_1 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, ProjectName TEXT, Description TEXT, " +
                "StartDate INTEGER, EndDate INTEGER, Funds INTEGER )");

        db.execSQL("create table  " + TABLE_2 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, Instance Name TEXT, Project Name TEXT," +
                 "Description TEXT, Fund INTEGER, Location TEXT )");

        db.execSQL("create table  " + TABLE_3 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, Personnel Name TEXT, Instance Name TEXT," +
                 "Contact TEXT, Address TEXT, Salary INTEGER, Joining Date TEXT, Resign Date TEXT )");

        db.execSQL("create table  " + TABLE_4 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, Inventory Name TEXT, Description TEXT," +
                        "Instance Name TEXT , InventoryCost INTEGER )");

        db.execSQL("create table  " + TABLE_5 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, Donated By TEXT, FUNDS INTEGER, Project Name TEXT," +
                "Instance Name INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists"+ TABLE_1);
        db.execSQL("drop table if exists"+ TABLE_2);
        db.execSQL("drop table if exists"+ TABLE_3);
        db.execSQL("drop table if exists"+ TABLE_4);
        db.execSQL("drop table if exists"+ TABLE_5);

        onCreate(db);
    }

    // PROJECT SPECIFIC TABLE OPERATIONS
    public boolean insertProjectSpecificData(String projectName, String description, String  StartDate, String EndDate, String Funds) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE1_COL2,projectName);
        contentValues.put(TABLE1_COL3, description);
        contentValues.put(TABLE1_COL4, StartDate);
        contentValues.put(TABLE1_COL5, EndDate);
        contentValues.put(TABLE1_COL6, Funds);

        long result = db.insert(TABLE_1,null,contentValues);

        return result != -1;
    }




    // INSTANCE SPECIFIC TABLE OPERATIONS

    public boolean insertInstanceSpecificData(String InstanceName, String ProjectName, String  Description, String Funds, String Location) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE2_COL2,InstanceName);
        contentValues.put(TABLE2_COL3,ProjectName);
        contentValues.put(TABLE2_COL4,Description);
        contentValues.put(TABLE2_COL5,Funds);
        contentValues.put(TABLE2_COL6,Location);


        long result = db.insert(TABLE_2,null,contentValues);

        return result != -1;
    }

    // PERSONNEL SPECIFIC TABLE OPERATIONS

    public boolean insertPersonnelSpecificData(String PersonnelName, String InstanceName, String  Contact, String Address, String Salary,
                                               String JoinDate, String ResignDate) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE3_COL2,PersonnelName);
        contentValues.put(TABLE3_COL3,InstanceName);
        contentValues.put(TABLE3_COL4,Contact);
        contentValues.put(TABLE3_COL5,Address);
        contentValues.put(TABLE3_COL6,Salary);
        contentValues.put(TABLE3_COL7,JoinDate);
        contentValues.put(TABLE3_COL8,ResignDate);

        long result = db.insert(TABLE_3,null,contentValues);

        return result != -1;
    }


    // INVENTORY SPECIFIC TABLE OPERATIONS

    public boolean insertInventorySpecificData(String InventoryName, String Description, String InstanceName, String  InventoryCost) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE4_COL2,InventoryName);
        contentValues.put(TABLE4_COL3,InventoryName);
        contentValues.put(TABLE4_COL4,InstanceName);
        contentValues.put(TABLE4_COL5,InventoryCost);

        long result = db.insert(TABLE_4,null,contentValues);

        return result != -1;
    }


    // DONATION SPECIFIC TABLE OPERATIONS

    public boolean insertDonationSpecificData(String DonatedBy, String Funds, String InstanceName, String  ProjectName) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE5_COL2,DonatedBy);
        contentValues.put(TABLE5_COL3,Funds);
        contentValues.put(TABLE5_COL4,InstanceName);    // TODO Drop down from existing Instances only
        contentValues.put(TABLE5_COL5,ProjectName);     // TODO Drop down from existing Projects only

        long result = db.insert(TABLE_5,null,contentValues);

        return result != -1;
    }

}