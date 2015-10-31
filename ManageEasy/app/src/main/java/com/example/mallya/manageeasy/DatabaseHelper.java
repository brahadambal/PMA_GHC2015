package com.example.mallya.manageeasy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.webkit.JavascriptInterface;

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
    public static final String TABLE2_COL5="Funds";
    public static final String TABLE2_COL6="Location";
    public static final String TABLE2_COL7="DonatedBy";

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
    public static final String TABLE3_COL9="PersonnelGender";

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
    public static final String TABLE5_COL3="Amount";
    public static final String TABLE5_COL4="ProjectName";
    public static final String TABLE5_COL5="Location";
    public static final String TABLE5_COL6="PANCardNum";


    //SUCCESS STORIES SPECIFIC TABLE ENTRIES
    public static final String TABLE_6="SuccessStory_table";
    public static final String TABLE6_COL1="ID";
    public static final String TABLE6_COL2="SuccessStoryName";
    public static final String TABLE6_COL3="SuccessStoryInstanceName";
    public static final String TABLE6_COL4="SuccessStoryDescription";
    public static final String TABLE6_COL5="Institution";
    public static final String TABLE6_COL6="Personnel";
    public static final String TABLE6_COL7="SuccessStoryContact";
    public static final String TABLE6_COL8="SuccessStoryAddress";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        deleteDB(db);
        DatabaseTestHelper dbTest = new DatabaseTestHelper();

        // TODO DO not create Tables if they exist already.

        db.execSQL("create table  " + TABLE_1 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, ProjectName TEXT, Description TEXT, " +
                "StartDate INTEGER, EndDate INTEGER, Funds INTEGER )");

        db.execSQL("create table  " + TABLE_2 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, InstanceName TEXT, ProjectName TEXT," +
                 "Description TEXT, Funds INTEGER, Location TEXT, DonatedBy TEXT )");

        db.execSQL("create table  " + TABLE_3 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, PersonnelName TEXT, InstanceName TEXT," +
                 "Contact TEXT, Address TEXT, Salary INTEGER, JoiningDate TEXT, ResignDate TEXT, PersonnelGender TEXT  )");

        db.execSQL("create table  " + TABLE_4 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, InventoryName TEXT, Description TEXT," +
                "InstanceName TEXT , InventoryCost INTEGER )");

        db.execSQL("create table  " + TABLE_5 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, DonatedBy TEXT, Amount INTEGER, ProjectName TEXT," +
                "Location TEXT, PanCardNum TEXT )");

        db.execSQL("create table  " + TABLE_6 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, SStoryName TEXT, SStoryInstanceName, SStoryDescription TEXT," +
                "SStoryInstitution TEXT, Personnel TEXT, SStoryContact INTEGER, SStoryAddress TEXT )");

        dbTest.insertTestdata();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists"+ TABLE_1);
        db.execSQL("drop table if exists" + TABLE_2);
        db.execSQL("drop table if exists" + TABLE_3);
        db.execSQL("drop table if exists" + TABLE_4);
        db.execSQL("drop table if exists" + TABLE_5);
        db.execSQL("drop table if exists" + TABLE_6);

        onCreate(db);
    }

    public void deleteDB (SQLiteDatabase db) {
        // Delete the drops when this will go into production
        db.execSQL("drop table if exists"+ TABLE_1);
        db.execSQL("drop table if exists" + TABLE_2);
        db.execSQL("drop table if exists" + TABLE_3);
        db.execSQL("drop table if exists" + TABLE_4);
        db.execSQL("drop table if exists" + TABLE_5);
        db.execSQL("drop table if exists" + TABLE_6);
    }


    // PROJECT SPECIFIC TABLE OPERATIONS
    public boolean insertProjectSpecificData(String projectName, String description, String  StartDate, String EndDate, String Funds) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE1_COL2, projectName);
        contentValues.put(TABLE1_COL3, description);
        contentValues.put(TABLE1_COL4, StartDate);
        contentValues.put(TABLE1_COL5, EndDate);
        contentValues.put(TABLE1_COL6, Funds);

        long result = db.insert(TABLE_1,null,contentValues);

        return result != -1;
    }

    public int getTotalNumProjects() {
        return 15;
    }

    public int getNumProjectSuccessStories(int projectID) {

        int tempNum;
        switch(projectID)
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

    public int getNumProjectInstances(int projectID) {

        // Project instances needs to be more than or equal to number of locations.
        int tempNum;
        switch(projectID)
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

    public int getNumProjectLocations(int projectID) {

        // Project Locations needs to be less than or equal to number of instances.

        int tempNum;
        switch(projectID)
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

            default: tempNum=3;
                break;
        }
        return tempNum;

    }

    public int getNumProjectsForLocation(String location) {

        // Project Locations needs to be less than or equal to number of instances.
        return 10;

    }

    public int getProjectFunds(int projectID) {

        int tempNum;
        switch(projectID)
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

            default: tempNum=1000;
                break;
        }
        return tempNum;
    }


    public String getProjectName(int projectID) {

        String tempStr;

        switch(projectID)
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

            default: tempStr="project" + projectID;
                break;
        }
        return tempStr;

    }

    public int getNumPersonnelPerProject(int projectID) {

        int tempNum;
        switch(projectID)
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

    // INSTANCE SPECIFIC TABLE OPERATIONS

    public boolean insertInstanceSpecificData(String InstanceName, String ProjectName, String  Description, String Funds, String Location, String DonatedBy) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE2_COL2,InstanceName);
        contentValues.put(TABLE2_COL3,ProjectName);
        contentValues.put(TABLE2_COL4,Description);
        contentValues.put(TABLE2_COL5,Funds);
        contentValues.put(TABLE2_COL6,Location);
        contentValues.put(TABLE2_COL7,DonatedBy);


        long result = db.insert(TABLE_2,null,contentValues);

        return result != -1;
    }

    public int getTotalNumInstances() {
        return 50;
    }

    public int  getInstanceFunds (int InstanceID) {
        return 1000;
    }

    public int getNumPersonnelPerInstance (int InstanceID) {
        return 10;
    }

    public int getNumInstanceSuccessStories(int InstanceID) {
        return 10;
    }

    public String getInstanceName( int instanceID) {

        return ("Instance" + instanceID);
    }

    public String getProjectOfInstanceName (int instanceID) {

        return ("Project" + instanceID);
    }

    public int getNumInstancesPerLocation(int projectID, String location) {
        return (10);
    }


    public Cursor getIndividualInstanceData(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_2 + " where ID=" +id ,null );
        return result;
    }

    // PERSONNEL SPECIFIC TABLE OPERATIONS

    public boolean insertPersonnelSpecificData(String PersonnelName, String InstanceName, String  Contact, String Address, String Salary,
                                               String JoinDate, String ResignDate, String PersonnelGender) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE3_COL2,PersonnelName);
        contentValues.put(TABLE3_COL3,InstanceName);
        contentValues.put(TABLE3_COL4,Contact);
        contentValues.put(TABLE3_COL5,Address);
        contentValues.put(TABLE3_COL6,Salary);
        contentValues.put(TABLE3_COL7,JoinDate);
        contentValues.put(TABLE3_COL8,ResignDate);
        contentValues.put(TABLE3_COL9,PersonnelGender);

        long result = db.insert(TABLE_3,null,contentValues);

        return result != -1;
    }

    public int getTotalNumPersonnel() {
        return 20;
    }

    public String getPersonnelName(int personnelID) {
        return ("Personnel" + personnelID);
    }


    public Cursor getIndividualPersonnelData(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_3 + " where ID=" +id ,null );
        return result;
    }


    // INVENTORY SPECIFIC TABLE OPERATIONS

    public boolean insertInventorySpecificData(String InventoryName, String Description, String InstanceName, String  InventoryCost) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE4_COL2,InventoryName);
        contentValues.put(TABLE4_COL3,Description);
        contentValues.put(TABLE4_COL4,InstanceName);
        contentValues.put(TABLE4_COL5,InventoryCost);

        long result = db.insert(TABLE_4,null,contentValues);

        return result != -1;
    }

    public int getTotalNumInventory(){
        return 20;
    }

    public String getInventoryName(int inventoryID) {
        return ("Inventory" + inventoryID);
    }

    public Cursor getIndividualInventoryData(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_4 + " where ID=" +id ,null );
        return result;
    }

    // Given a project ID and inventory name, get the inventory cost of it.
    public int getInventoryCostForProject(int projectID, String invetoryName) {
        return (1000);
    }

    //Given an Instance ID and inventory name, get the inventory cost of it.
    public int getInventoryCostForInstance(int instanceID, String inventoryName) {
        return (500);
    }


    // DONATION SPECIFIC TABLE OPERATIONS

    public boolean insertDonationSpecificData(String DonatedBy, String Amount, String ProjectName, String  Location, String PANCard) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE5_COL2,DonatedBy);
        contentValues.put(TABLE5_COL3,Amount);
        contentValues.put(TABLE5_COL4,ProjectName);    // TODO Drop down from existing Instances only
        contentValues.put(TABLE5_COL5,Location);
        contentValues.put(TABLE5_COL6,PANCard);

        long result = db.insert(TABLE_5,null,contentValues);

        return result != -1;
    }

    public int getTotalNumDonations() {
        return 20;
    }

    public String getDonationName(int donationID) {
        return ("Donation" + donationID);
    }


    //Given a project ID fetch the specific donations made towards it if any.
    public int getSumFundsPerProject (int ProjectID) {
        return 1000;
    }

    //Sum of all Donations towards specific projects
    public int getSumDonationsForProjects() {
         return (300000);
    }

    // Given a PanID get the total sum of donations made.
    public int getSumDonations (String PanID) {
        return (3000);
    }

    //How much Funds are in free pool, ie not allocated to any project yet.
    public int getFundsInFreePool (){
        return (500000);
    }

    // How many projects have the money from this donation
    public int getTotalNumProjectDonationsByID (int donationID)   {
        return 4;
    }

    //Given a projectID and a donationID, get the sum total of donations from that donationID allocated as Funds to projectID

    public int getFundsFromDonationsForProject (int projectID, int donationID) {
        return 35000;
    }

    public int getFundsFromDonationsForInstance (int instanceID) {
        return (50000);
    }

    // SUCCESS STORY SPECIFIC TABLE OPERATIONS

    public boolean insertSuccessStorySpecificData(String SuccessStoryName, String SuccessStoryInstanceName, String SuccessStoryDescription,
    String Institution, String Personnel, String SuccessStoryContact, String SuccessStoryAddress) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE6_COL2,SuccessStoryName);
        contentValues.put(TABLE6_COL3,SuccessStoryInstanceName);    // TODO Drop down from existing Instances only
        contentValues.put(TABLE6_COL4,SuccessStoryDescription);
        contentValues.put(TABLE6_COL5,Institution);
        contentValues.put(TABLE6_COL6,Personnel);
        contentValues.put(TABLE6_COL7,SuccessStoryContact);
        contentValues.put(TABLE6_COL8,SuccessStoryAddress);


        long result = db.insert(TABLE_6,null,contentValues);

        return result != -1;

    }
    public int getTotalNumSuccessStory() {
        return 20;
    }

    public String getSuccessStoryName(int successStoryID) {
        return ("Success Story" + successStoryID);
    }

    public Cursor getIndividualSuccessStoryData(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_6 + " where ID=" +id ,null );
        return result;
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
}



