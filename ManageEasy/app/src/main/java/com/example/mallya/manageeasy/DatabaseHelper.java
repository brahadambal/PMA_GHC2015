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

    public static final String DATABASE_NAME = "Projects.db";

    // PROJECT SPECIFIC TABLE ENTRIES
    public static final String TABLE_1 = "Project_table";
    public static final String TABLE1_COL1 = "ID";
    public static final String TABLE1_COL2 = "ProjectName";
    public static final String TABLE1_COL3 = "Description";
    public static final String TABLE1_COL4 = "StartDate";
    public static final String TABLE1_COL5 = "EndDate";
    public static final String TABLE1_COL6 = "Funds";

    // INSTANCE SPECIFIC TABLE ENTRIES
    public static final String TABLE_2 = "Instance_table";
    public static final String TABLE2_COL1 = "ID";
    public static final String TABLE2_COL2 = "InstanceName";
    public static final String TABLE2_COL3 = "ProjectName";
    public static final String TABLE2_COL4 = "Description";
    public static final String TABLE2_COL5 = "Funds";
    public static final String TABLE2_COL6 = "Location";
    public static final String TABLE2_COL7 = "DonatedBy";

    // PERSONNEL SPECIFIC TABLE ENTRIES
    public static final String TABLE_3 = "Personnel_table";
    public static final String TABLE3_COL1 = "ID";
    public static final String TABLE3_COL2 = "PersonnelName";
    public static final String TABLE3_COL3 = "InstanceName";
    public static final String TABLE3_COL4 = "Contact";
    public static final String TABLE3_COL5 = "Address";
    public static final String TABLE3_COL6 = "Salary";
    public static final String TABLE3_COL7 = "JoiningDate";
    public static final String TABLE3_COL8 = "ResignDate";
    public static final String TABLE3_COL9 = "PersonnelGender";

    // INVENTORY SPECIFIC TABLE ENTRIES
    public static final String TABLE_4 = "Inventory_table";
    public static final String TABLE4_COL1 = "ID";
    public static final String TABLE4_COL2 = "InventoryName";
    public static final String TABLE4_COL3 = "Description";
    public static final String TABLE4_COL4 = "InstanceName";
    public static final String TABLE4_COL5 = "InventoryCost";


    // DONATIONS AND FUNDS SPECIFIC TABLE ENTRIES
    public static final String TABLE_5 = "Donation_table";
    public static final String TABLE5_COL1 = "ID";
    public static final String TABLE5_COL2 = "DonatedBy";
    public static final String TABLE5_COL3 = "Amount";
    public static final String TABLE5_COL4 = "ProjectName";
    public static final String TABLE5_COL5 = "Location";
    public static final String TABLE5_COL6 = "PANCardNum";


    //SUCCESS STORIES SPECIFIC TABLE ENTRIES
    public static final String TABLE_6 = "SuccessStory_table";
    public static final String TABLE6_COL1 = "ID";
    public static final String TABLE6_COL2 = "SStoryName";
    public static final String TABLE6_COL3 = "SStoryInstanceName";
    public static final String TABLE6_COL4 = "SStoryDescription";
    public static final String TABLE6_COL5 = "SStoryInstitution";
    public static final String TABLE6_COL6 = "Personnel";
    public static final String TABLE6_COL7 = "SStoryContact";
    public static final String TABLE6_COL8 = "SStoryAddress";


    public static int oneTimeEntryFlag = 0;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //deleteDB(db);
        //DatabaseTestHelper dbTest = new DatabaseTestHelper();

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

        db.execSQL("create table  " + TABLE_6 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, SStoryName TEXT, SStoryInstanceName TEXT, SStoryDescription TEXT," +
                "SStoryInstitution TEXT, Personnel TEXT, SStoryContact INTEGER, SStoryAddress TEXT )");

        //insertTestdata();

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_1);
        db.execSQL("drop table if exists " + TABLE_2);
        db.execSQL("drop table if exists " + TABLE_3);
        db.execSQL("drop table if exists " + TABLE_4);
        db.execSQL("drop table if exists " + TABLE_5);
        db.execSQL("drop table if exists " + TABLE_6);

        onCreate(db);
    }

    public void deleteDB() {
        // Delete the drops when this will go into production
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("drop table if exists " + TABLE_1);
        db.execSQL("drop table if exists " + TABLE_2);
        db.execSQL("drop table if exists " + TABLE_3);
        db.execSQL("drop table if exists " + TABLE_4);
        db.execSQL("drop table if exists " + TABLE_5);
        db.execSQL("drop table if exists " + TABLE_6);
    }

    public void createDB() {

        SQLiteDatabase db = this.getWritableDatabase();
        onCreate(db);

    }

    // PROJECT SPECIFIC TABLE OPERATIONS
    public boolean insertProjectSpecificData(String projectName, String description, String StartDate, String EndDate, String Funds) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE1_COL2, projectName);
        contentValues.put(TABLE1_COL3, description);
        contentValues.put(TABLE1_COL4, StartDate);
        contentValues.put(TABLE1_COL5, EndDate);
        contentValues.put(TABLE1_COL6, Funds);

        long result = db.insert(TABLE_1, null, contentValues);

        return result != -1;
    }

    public int getTotalNumProjects() {

        String countQuery = "SELECT  * FROM " + TABLE_1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public int getNumProjectSuccessStories(int projectID) {

        int tempNum;

        switch (projectID) {
            case 1:
                tempNum = 50;
                break;

            case 2:
                tempNum = 20;
                break;

            case 3:
                tempNum = 60;
                break;

            case 4:
                tempNum = 20;
                break;

            case 5:
                tempNum = 80;
                break;

            default:
                tempNum = 1;
                break;
        }
        return tempNum;

    }

    public int getNumProjectInstances(int projectID) {

        // Project instances needs to be more than or equal to number of locations.
        int tempNum;
        switch (projectID) {
            case 1:
                tempNum = 8;
                break;

            case 2:
                tempNum = 4;
                break;

            case 3:
                tempNum = 10;
                break;

            case 4:
                tempNum = 4;
                break;

            case 5:
                tempNum = 8;
                break;

            default:
                tempNum = 1;
                break;
        }
        return tempNum;

    }

    public int getNumProjectLocations(int projectID) {

        // Project Locations needs to be less than or equal to number of instances.

        int tempNum;
        switch (projectID) {
            case 1:
                tempNum = 5;
                break;

            case 2:
                tempNum = 2;
                break;

            case 3:
                tempNum = 6;
                break;

            case 4:
                tempNum = 2;
                break;

            case 5:
                tempNum = 8;
                break;

            default:
                tempNum = 3;
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
        switch (projectID) {
            case 1:
                tempNum = 10000;
                break;

            case 2:
                tempNum = 20000;
                break;

            case 3:
                tempNum = 60000;
                break;

            case 4:
                tempNum = 25000;
                break;

            case 5:
                tempNum = 15000;
                break;

            default:
                tempNum = 1000;
                break;
        }
        return tempNum;
    }


    public String getProjectName(int projectID) {

        String tempStr;

       /* String countQuery = "SELECT  ProjectName FROM " + TABLE_1 + " where id=" + projectID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        tempStr = cursor.getString(1);
        cursor.close();
        return tempStr; */

        switch (projectID) {
            case 1:
                tempStr = "Girl Edu";
                break;

            case 2:
                tempStr = "Health Care";
                break;

            case 3:
                tempStr = "Child Care";
                break;

            case 4:
                tempStr = "Project Revamp";
                break;

            case 5:
                tempStr = "Food For ALL";
                break;

            default:
                tempStr = "project" + projectID;
                break;
        }
        return tempStr;
    }

    public int getNumPersonnelPerProject(int projectID) {

        int tempNum;
        switch (projectID) {
            case 1:
                tempNum = 10;
                break;

            case 2:
                tempNum = 20;
                break;

            case 3:
                tempNum = 30;
                break;

            case 4:
                tempNum = 40;
                break;

            case 5:
                tempNum = 10;
                break;

            default:
                tempNum = 1;
                break;
        }
        return tempNum;
    }

    // INSTANCE SPECIFIC TABLE OPERATIONS

    public boolean insertInstanceSpecificData(String InstanceName, String ProjectName, String Description, String Funds, String Location, String DonatedBy) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE2_COL2, InstanceName);
        contentValues.put(TABLE2_COL3, ProjectName);
        contentValues.put(TABLE2_COL4, Description);
        contentValues.put(TABLE2_COL5, Funds);
        contentValues.put(TABLE2_COL6, Location);
        contentValues.put(TABLE2_COL7, DonatedBy);


        long result = db.insert(TABLE_2, null, contentValues);

        return result != -1;
    }

    public int getTotalNumInstances() {
        String countQuery = "SELECT  * FROM " + TABLE_2;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public int getInstanceFunds(int InstanceID) {
        if (InstanceID < 10)
            return 1000;
        else if (InstanceID < 15)
                return 2000;

        return 3000;
    }

    public int getNumPersonnelPerInstance(int InstanceID) {

        if (InstanceID < 10)
            return 10;
        else
            return 30;
    }

    public int getNumInstanceSuccessStories(int InstanceID) {

        if (InstanceID < 10)
            return 10;
        else
            return 5;
    }

    public String getInstanceName(int instanceID) {

        return ("Instance" + instanceID);
    }

    public String getProjectOfInstanceName(int instanceID) {

        return ("Project" + instanceID);
    }

    public int getNumInstancesPerLocation(int projectID, String location) {
        if (projectID < 10)
            return 10;
        else
            return 5;
    }


    public Cursor getIndividualInstanceData(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_2 + " where ID=" + id, null);
        return result;
    }

    // PERSONNEL SPECIFIC TABLE OPERATIONS

    public boolean insertPersonnelSpecificData(String PersonnelName, String InstanceName, String Contact, String Address, String Salary,
                                               String JoinDate, String ResignDate, String PersonnelGender) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE3_COL2, PersonnelName);
        contentValues.put(TABLE3_COL3, InstanceName);
        contentValues.put(TABLE3_COL4, Contact);
        contentValues.put(TABLE3_COL5, Address);
        contentValues.put(TABLE3_COL6, Salary);
        contentValues.put(TABLE3_COL7, JoinDate);
        contentValues.put(TABLE3_COL8, ResignDate);
        contentValues.put(TABLE3_COL9, PersonnelGender);

        long result = db.insert(TABLE_3, null, contentValues);

        return result != -1;
    }

    public int getTotalNumPersonnel() {

        String countQuery = "SELECT  * FROM " + TABLE_3;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public String getPersonnelName(int personnelID) {
        return ("Personnel" + personnelID);
    }


    public Cursor getIndividualPersonnelData(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_3 + " where ID=" + id, null);
        return result;
    }


    // INVENTORY SPECIFIC TABLE OPERATIONS

    public boolean insertInventorySpecificData(String InventoryName, String Description, String InstanceName, String InventoryCost) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE4_COL2, InventoryName);
        contentValues.put(TABLE4_COL3, Description);
        contentValues.put(TABLE4_COL4, InstanceName);
        contentValues.put(TABLE4_COL5, InventoryCost);

        long result = db.insert(TABLE_4, null, contentValues);

        return result != -1;
    }

    public int getTotalNumInventory() {

        String countQuery = "SELECT  * FROM " + TABLE_4;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public String getInventoryName(int inventoryID) {
        return ("Inventory" + inventoryID);
    }

    public Cursor getIndividualInventoryData(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_4 + " where ID=" + id, null);
        return result;
    }

    // Given a project ID and inventory name, get the inventory cost of it.
    public int getInventoryCostForProject(int projectID, String invetoryName) {
        return (1000);
    }

    //Given an Instance ID and inventory name, get the inventory cost of it.
    public int getInventoryCostForInstance(int instanceID, String inventoryName) {

        if (instanceID < 10 && inventoryName == "uniforms")
            return (500);
        else if ( instanceID > 10 && inventoryName == "uniforms")
            return 20;

        if (instanceID < 20 && inventoryName == "food")
            return 100;
        else if (instanceID > 20 && inventoryName == "food")
            return 300;

        if (instanceID < 10 && inventoryName == "clothes")
            return 600;
        else if (instanceID > 10 && inventoryName =="clothes")
             return 250;

        if (instanceID < 20 && inventoryName =="medicines")
            return 200;
        else if (instanceID > 20 && inventoryName == "medicines")
            return 0;

        return 500;
    }


    // DONATION SPECIFIC TABLE OPERATIONS

    public boolean insertDonationSpecificData(String DonatedBy, String Amount, String ProjectName, String Location, String PANCard) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE5_COL2, DonatedBy);
        contentValues.put(TABLE5_COL3, Amount);
        contentValues.put(TABLE5_COL4, ProjectName);    // TODO Drop down from existing Instances only
        contentValues.put(TABLE5_COL5, Location);
        contentValues.put(TABLE5_COL6, PANCard);

        long result = db.insert(TABLE_5, null, contentValues);

        return result != -1;
    }

    public int getTotalNumDonations() {

        String countQuery = "SELECT  * FROM " + TABLE_5;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public String getDonationName(int donationID) {
        return ("Donation" + donationID);
    }


    //Given a project ID fetch the specific donations made towards it if any.
    public int getSumFundsPerProject(int ProjectID) {
        return 1000;
    }

    //Sum of all Donations towards specific projects
    public int getSumDonationsForProjects() {
        return (300000);
    }

    // Given a PanID get the total sum of donations made.
    public int getSumDonations(String PanID) {
        return (3000);
    }

    //How much Funds are in free pool, ie not allocated to any project yet.
    public int getFundsInFreePool() {
        return (500000);
    }

    // How many projects have the money from this donation
    public int getTotalNumProjectDonationsByID(int donationID) {
        return 4;
    }

    //Given a projectID and a donationID, get the sum total of donations from that donationID allocated as Funds to projectID

    public int getFundsFromDonationsForProject(int projectID, int donationID) {
        return 35000;
    }

    public int getFundsFromDonationsForInstance(int instanceID) {
        return (50000);
    }

    // SUCCESS STORY SPECIFIC TABLE OPERATIONS

    public boolean insertSuccessStorySpecificData(String SuccessStoryName, String SuccessStoryInstanceName, String SuccessStoryDescription,
                                                  String Institution, String Personnel, String SuccessStoryContact, String SuccessStoryAddress) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE6_COL2, SuccessStoryName);
        contentValues.put(TABLE6_COL3, SuccessStoryInstanceName);    // TODO Drop down from existing Instances only
        contentValues.put(TABLE6_COL4, SuccessStoryDescription);
        contentValues.put(TABLE6_COL5, Institution);
        contentValues.put(TABLE6_COL6, Personnel);
        contentValues.put(TABLE6_COL7, SuccessStoryContact);
        contentValues.put(TABLE6_COL8, SuccessStoryAddress);


        long result = db.insert(TABLE_6, null, contentValues);

        return result != -1;
    }

    public int getTotalNumSuccessStory() {

        String countQuery = "SELECT  * FROM " + TABLE_6;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public String getSuccessStoryName(int successStoryID) {
        return ("Success Story" + successStoryID);
    }

    public Cursor getIndividualSuccessStoryData(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_6 + " where ID=" + id, null);
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

    public void insertTestdata() {

        deleteDB();
        createDB();

        insertProjectSpecificData("Samruddhi", "Girl Child Education", "1/1/2013", " ", "80000");
        insertProjectSpecificData("Abhivruddhi", "Elderly Welfare", "2/2/2010", " ", "50000");
        insertProjectSpecificData("Santrupthi", "Rural Heath", "3/3/2005", " ", "100000");
        insertProjectSpecificData("Wempower", "women empowement", "10/2/2010", " ", "70000");
        insertProjectSpecificData("Orion", "Orphan welfare", "1/1/2013", " ", "60000");
        insertProjectSpecificData("Hercules", "Physically challenged welfare", "2/2/2010", " ", "75000");
        insertProjectSpecificData("MindoverMatter", "Mentally challenged welfare", "3/3/2005", " ", "90000");
        insertProjectSpecificData("Live on", "Organ Donation Awareness", "10/2/2010", " ", "50000");
        insertProjectSpecificData("Wish foundation", "Terminal cancer patient wish foundation", "1/1/2013", " ", "200000");
        insertProjectSpecificData("Karuna", "Animal welfare", "2/2/2010", " ", "70000");
        insertProjectSpecificData("Grassroot", "Rural Education", "3/3/2005", " ", "50000");
        insertProjectSpecificData("X-force", "Women self defense", "10/2/2010", " ", "50000");
        insertProjectSpecificData("Healthy Life", "Yoga classes", "1/2/2014", " ", "50000");

        insertDonationSpecificData("Rao", "10000", "Karuna", "ANY", "DSHFDHR4783");
        insertDonationSpecificData("Dhanushree", "50000", "Abhivruddhi", "ANT", "RFKJGT55RTR6");
        insertDonationSpecificData("BInfosys", "100000", "Samruddhi", "ANY", "COMPANY");
        insertDonationSpecificData("EBM", "100000", "Wempower", "ANY", "COMPANY");
        insertDonationSpecificData("Rao", "30000", "Karuna", "ANY", "DSHFDHR4783");
        insertDonationSpecificData("BInfosys", "100000", "MindoverMatter", "ANY", "COMPANY");
        insertDonationSpecificData("EBM", "100000", "ANY", "ANY", "COMPANY");
        insertDonationSpecificData("Zipro", "90000", "Liveon", "ANY", "COMPANY");
        insertDonationSpecificData("Zipro", "90000", "Grassroot", "ANY", "COMPANY");
        insertDonationSpecificData("Madhusudan", "100000", "Santrupthi", "ANY", "RUUTORUTO95");
        insertDonationSpecificData("Savitri", "90000", "HealthyLife", "ANY", "UOUOO787960");
        insertDonationSpecificData("Champak", "80000", "Orion", "ANY", "6378JFDDBDFG");
        insertDonationSpecificData("Rao", "50000", "Karuna", "ANY", "DSHFDHR4783");
        insertDonationSpecificData("Dhanya", "100000", "Hercules", "ANY", "4UYUI989YFGD");
        insertDonationSpecificData("Kamakshi Hospital", "200000", "Wish foundation", "ANY", "COMPANY");
        insertDonationSpecificData("Orion hospital", "150000", "Wish foundation", "ANY", "COMPANY");
        insertDonationSpecificData("Dhanya", "100000", "X-force", "ANY", "4UYUI989YFGD");
        insertDonationSpecificData("MetAPPs", "20000", "ANY", "ANY", "COMPANY");


        insertInstanceSpecificData("B-instance1", "Samruddhi", "NA", "50000", "Bangalore", "-");
        insertInstanceSpecificData("B-instance2", "Abhivruddhi", "NA", "50000", "Bangalore", "-");
        insertInstanceSpecificData("B-instance3", "Santrupthi", "NA", "50000", "Bangalore", "-");
        insertInstanceSpecificData("C-instance1", "Wempower", "NA", "50000", "Chennai", "-");
        insertInstanceSpecificData("C-instance2", "Orion", "NA", "50000", "Chennai", "-");
        insertInstanceSpecificData("G-instance1", "Hercules", "NA", "50000", "Gulbarga", "-");
        insertInstanceSpecificData("T-instance1", "MindoverMatter", "NA", "50000", "Tumkur", "-");
        insertInstanceSpecificData("B-instance4", "Live on", "NA", "50000", "Bangalore", "-");
        insertInstanceSpecificData("M-instance1", "Wish foundation", "NA", "50000", "Mysore", "-");
        insertInstanceSpecificData("B-instance5", "Karuna", "NA", "50000", "Bangalore", "-");
        insertInstanceSpecificData("R-instance1", "Grassroot", "NA", "50000", "Raichur", "-");
        insertInstanceSpecificData("B-instance6", "X-force", "NA", "50000", "Bangalore", "-");
        insertInstanceSpecificData("M-instance2", "Healthy Life", "NA", "50000", "Mysore", "-");
        insertInstanceSpecificData("Z-instance1", "Samruddhi", "NA", "50000", "Hubli", "-");
        insertInstanceSpecificData("Z-instance2", "Abhivruddhi", "NA", "50000", "Hubli", "-");
        insertInstanceSpecificData("Z-instance3", "Santrupthi", "NA", "50000", "Hubli", "-");
        insertInstanceSpecificData("F-instance1", "Wempower", "NA", "50000", "Belgaum", "-");
        insertInstanceSpecificData("F-instance2", "Orion", "NA", "50000", "Belgaum", "-");
        insertInstanceSpecificData("F-instance3", "Hercules", "NA", "50000", "Belgaum", "-");
        insertInstanceSpecificData("G-instance2", "MindoverMatter", "NA", "50000", "Gulbarga", "-");
        insertInstanceSpecificData("B-instance8", "Live on", "NA", "50000", "Bangalore", "-");
        insertInstanceSpecificData("S-instance1", "Wish foundation", "NA", "50000", "Mangalore", "-");
        insertInstanceSpecificData("S-instance2", "Karuna", "NA", "50000", "Mangalore", "-");
        insertInstanceSpecificData("B-instance7", "Samruddhi", "NA", "50000", "Bangalore", "-");


        insertInventorySpecificData("books", "NA", "B-instance1", "1000");
        insertInventorySpecificData("uniform", "NA", "B-instance1", "5000");
        insertInventorySpecificData("Medicines", "NA", "B-instance2", "10000");
        insertInventorySpecificData("clothes", "NA", "B-instance2", "7000");
        insertInventorySpecificData("food", "NA", "B-instance2", "12000");
        insertInventorySpecificData("books", "NA", "C-instance1", "1000");
        insertInventorySpecificData("Medicines", "NA", "C-instance2", "5000");
        insertInventorySpecificData("clothes", "NA", "C-instance2", "10000");
        insertInventorySpecificData("food", "NA", "C-instance2", "10000");
        insertInventorySpecificData("Medicines", "NA", "G-instance1", "5000");
        insertInventorySpecificData("Instuments", "NA", "G-instance1", "20000");
        insertInventorySpecificData("clothes", "NA", "T-instance1", "10000");
        insertInventorySpecificData("books", "NA", "T-instance1", "1000");
        insertInventorySpecificData("food", "NA", "T-instance1", "10000");
        insertInventorySpecificData("Medicines", "NA", "T-instance1", "2000");
        insertInventorySpecificData("books", "NA", "B-instance8", "1000");
        insertInventorySpecificData("Medicines", "NA", "M-instance1", "5000");
        insertInventorySpecificData("Toys", "NA", "M-instance1", "1000");
        insertInventorySpecificData("clothes", "NA", "M-instance1", "6000");
        insertInventorySpecificData("Toys", "NA", "G-instance1", "1000");


        insertSuccessStorySpecificData("Gim", "B-instance4", "NA", "B-institution", "Shashi89", " ","Bangalore");
        insertSuccessStorySpecificData("Jimmy", "B-instance1", "NA", "B-institution", "Abhishek60", " ", "Bangalore");
        insertSuccessStorySpecificData("Sanjay", "B-instance3", "NA", "B-institution", "Shamala", " ", "Bangalore");
        insertSuccessStorySpecificData("Sanjeev", "M-instance2", "NA", "M-institution", "JohnD", " ", "Mysore");
        insertSuccessStorySpecificData("Sanjeevani", "G-instance2", "NA", "G-institution", "Vijay", " ", "Gulburga");
        insertSuccessStorySpecificData("Salman", "F-instance1", "NA", "F-institution", "Siri", " ", "Belgaum");
        insertSuccessStorySpecificData("Sharuk", "B-instance4", "NA", "B-institution", "Shashi89", " ", "Bangalore");
        insertSuccessStorySpecificData("Naveen", "B-instance4", "NA", "B-institution", "Shashi89", " ", "Bangalore");
        insertSuccessStorySpecificData("Nithin", "Z-instance1", "NA", "Z-institution", "Vishwas", " ", "Hubli");
        insertSuccessStorySpecificData("Nilesh", "Z-instance1", "NA", "Z-institution", "Vishwas", " ", "Hubli");
        insertSuccessStorySpecificData("Sandeep", "Z-instance1", "NA", "Z-institution", "Vishwas", " ", "Hubli");
        insertSuccessStorySpecificData("Suresh", "S-instance1", "NA", "S-institution", "Shama", " ", "Mangalore");
        insertSuccessStorySpecificData("Suraj", "S-instance1", "NA", "S-institution", "Shama", " ", "Mangalore");
        insertSuccessStorySpecificData("Ashwin", "S-instance1", "NA", "S-institution", "Shama", " ", "Mangalore");
        insertSuccessStorySpecificData("Mahesh", "S-instance2", "NA", "S-institution", "Fathima", " ", "Mangalore");
        insertSuccessStorySpecificData("Ashwini", "B-instance3", "NA", "B-institution", "Shamala", " ", "Bangalore");
        insertSuccessStorySpecificData("Priya", "B-instance3", "NA", "B-institution", "Shamala", " ", "Bangalore");
        insertSuccessStorySpecificData("Piya", "C-instance1", "NA", "C-institution", "Katha55", " ", "Chennai");
        insertSuccessStorySpecificData("Pinku", "C-instance2", "NA", "C-institution", "Srikantha20", " ", "Chennai");
        insertSuccessStorySpecificData("Kaljal", "C-instance1", "NA", "C-institution", "Katha55", " ", "Chennai");
        insertSuccessStorySpecificData("Priyanka", "C-instance2", "NA", "C-institution", "Srikantha20", " ", "Chennai");


        insertPersonnelSpecificData("Abhishek", "B-instance1", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Shikha", "B-instance2", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Shamala", "B-instance3", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Katha", "C-instance1", "1234378899", "Chennai", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Srikantha", "C-instance2", "1234378899", "Chennai", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("George", "G-instance1", "1234378899", "Gulburga", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Pari", "T-instance1", "1234378899", "Tumkur", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Shashi", "B-instance4", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Sampath", "M-instance1", "1234378899", "Mysore", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Kala", "B-instance5", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Kavitha", "R-instance1", "1234378899", "Raichur", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Lalitha", "B-instance6", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("JohnD", "M-instance2", "1234378899", "Mysore", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Vishwas", "Z-instance1", "1234378899", "Hubli", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Gauthami", "Z-instance2", "1234378899", "Hubli", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Mahesh", "Z-instance3", "1234378899", "Hubli", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Siri", "F-instance1", "1234378899", "Belgaum", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Vikas", "F-instance2", "1234378899", "Belgaum", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Vikram", "F-instance3", "1234378899", "Belgaum", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Vijay", "G-instance2", "1234378899", "Gulburga", "10000", "1/1/2013", " ", "Male");
        insertPersonnelSpecificData("Vinaya", "B-instance8", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Shama", "S-instance1", "1234378899", "Mangalore", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Fathima", "S-instance2", "1234378899", "Mangalore", "10000", "1/1/2013", " ", "Female");
        insertPersonnelSpecificData("Faizal", "B-instance7", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Male");


        /* Abhishek60	B-instance1	1234378899	Bangalore	10000	3/3/2005		Male
        Shikha200	B-instance2	1234378899	Bangalore	10000	3/3/2005		Female
        Shamala50	B-instance3	1234378899	Bangalore	10000	3/3/2005		Female
        Katha55	C-instance1	1234378899	Chennai	10000	3/3/2005		Male
        Srikantha20	C-instance2	1234378899	Chennai	10000	3/3/2005		Male
        George20	G-instance1	1234378899	Gulburga	10000	3/3/2005		Male
        Pari78	T-instance1	1234378899	Tumkur	10000	3/3/2005		Female
        Shashi89	B-instance4	1234378899	Bangalore	10000	3/3/2005		Male
        Sampath20	M-instance1	1234378899	Mysore	10000	3/3/2005		Male
        Kala90	B-instance5	1234378899	Bangalore	10000	3/3/2005		Female
        Kavitha78	R-instance1	1234378899	Raichur	10000	3/3/2005		Female
        Lalitha34	B-instance6	1234378899	Bangalore	10000	3/3/2005		Female
        JohnD67	M-instance2	1234378899	Mysore	10000	3/3/2005		Male
        Vishwas89	Z-instance1	1234378899	Hubli	10000	3/3/2005		Male
        Gauthami22	Z-instance2	1234378899	Hubli	10000	3/3/2005		Female
        Mahesh909	Z-instance3	1234378899	Hubli	10000	3/3/2005		Male
        Siri101	F-instance1	1234378899	Belgaum	10000	3/3/2005		Male
        Vikas67	F-instance2	1234378899	Belgaum	10000	3/3/2005		Male
        Vikram45	F-instance3	1234378899	Belgaum	10000	3/3/2005		Male
        Vijay56	G-instance2	1234378899	Gulburga	10000	3/3/2005		Male
        Vinaya78	B-instance8	1234378899	Bangalore	10000	3/3/2005		Female
        Shama 90	S-instance1	1234378899	Mangalore	10000	3/3/2005		Female
        Fathima90	S-instance2	1234378899	Mangalore	10000	3/3/2005		Female
        Faizal90	B-instance7	1234378899	Bangalore	10000	3/3/2005		Male */

    }
}


