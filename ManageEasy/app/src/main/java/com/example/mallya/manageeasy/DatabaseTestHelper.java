package com.example.mallya.manageeasy;

import android.app.Activity;

/**
 * Created by Mallya on 10/31/2015.
 */
public class DatabaseTestHelper extends Activity {

    DatabaseHelper backendDB = new DatabaseHelper (this);

    public void insertTestdata() {

        backendDB.insertProjectSpecificData("Samruddhi", "Girl Child Education", "1/1/2013", " ", "80000");
        backendDB.insertProjectSpecificData("Abhivruddhi", "Elderly Welfare", "2/2/2010", " ", "50000");
        backendDB.insertProjectSpecificData("Santrupthi", "Rural Heath", "3/3/2005", " ", "100000");
        backendDB.insertProjectSpecificData("Wempower", "women empowement", "10/2/2010", " ", "70000");
        backendDB.insertProjectSpecificData("Orion", "Orphan welfare", "1/1/2013", " ", "60000");
        backendDB.insertProjectSpecificData("Hercules", "Physically challenged welfare", "2/2/2010", " ", "75000");
        backendDB.insertProjectSpecificData("MindoverMatter", "Mentally challenged welfare", "3/3/2005", " ", "90000");
        backendDB.insertProjectSpecificData("Live on", "Organ Donation Awareness", "10/2/2010", " ", "50000");
        backendDB.insertProjectSpecificData("Wish foundation", "Terminal cancer patient wish foundation", "1/1/2013", " ", "200000");
        backendDB.insertProjectSpecificData("Karuna", "Animal welfare", "2/2/2010", " ", "70000");
        backendDB.insertProjectSpecificData("Grassroot", "Rural Education", "3/3/2005", " ", "50000");
        backendDB.insertProjectSpecificData("X-force", "Women self defense", "10/2/2010", " ", "50000");
        backendDB.insertProjectSpecificData("Healthy Life", "Yoga classes", "1/2/2014", " ", "50000");

        backendDB.insertDonationSpecificData("Rao", "10000", "Karuna", "ANY", "DSHFDHR4783");
        backendDB.insertDonationSpecificData("Dhanushree", "50000", "Abhivruddhi", "ANT", "RFKJGT55RTR6");
        backendDB.insertDonationSpecificData("BInfosys", "100000", "Samruddhi", "ANY", "COMPANY");
        backendDB.insertDonationSpecificData("EBM", "100000", "Wempower", "ANY", "COMPANY");
        backendDB.insertDonationSpecificData("Rao", "30000", "Karuna", "ANY", "DSHFDHR4783");
        backendDB.insertDonationSpecificData("BInfosys", "100000", "MindoverMatter", "ANY", "COMPANY");
        backendDB.insertDonationSpecificData("EBM", "100000", "ANY", "ANY", "COMPANY");
        backendDB.insertDonationSpecificData("Zipro", "90000", "Liveon", "ANY", "COMPANY");
        backendDB.insertDonationSpecificData("Zipro", "90000", "Grassroot", "ANY", "COMPANY");
        backendDB.insertDonationSpecificData("Madhusudan", "100000", "Santrupthi", "ANY", "RUUTORUTO95");
        backendDB.insertDonationSpecificData("Savitri", "90000", "HealthyLife", "ANY", "UOUOO787960");
        backendDB.insertDonationSpecificData("Champak", "80000", "Orion", "ANY", "6378JFDDBDFG");
        backendDB.insertDonationSpecificData("Rao", "50000", "Karuna", "ANY", "DSHFDHR4783");
        backendDB.insertDonationSpecificData("Dhanya", "100000", "Hercules", "ANY", "4UYUI989YFGD");
        backendDB.insertDonationSpecificData("Kamakshi Hospital", "200000", "Wish foundation", "ANY", "COMPANY");
        backendDB.insertDonationSpecificData("Orion hospital", "150000", "Wish foundation", "ANY", "COMPANY");
        backendDB.insertDonationSpecificData("Dhanya", "100000", "X-force", "ANY", "4UYUI989YFGD");
        backendDB.insertDonationSpecificData("MetAPPs", "20000", "ANY", "ANY", "COMPANY");


        backendDB.insertInstanceSpecificData("B-instance1", "Samruddhi", "NA", "50000", "Bangalore", "-");
        backendDB.insertInstanceSpecificData("B-instance2", "Abhivruddhi", "NA", "50000", "Bangalore", "-");
        backendDB.insertInstanceSpecificData("B-instance3", "Santrupthi", "NA", "50000", "Bangalore", "-");
        backendDB.insertInstanceSpecificData("C-instance1", "Wempower", "NA", "50000", "Chennai", "-");
        backendDB.insertInstanceSpecificData("C-instance2", "Orion", "NA", "50000", "Chennai", "-");
        backendDB.insertInstanceSpecificData("G-instance1", "Hercules", "NA", "50000", "Gulbarga", "-");
        backendDB.insertInstanceSpecificData("T-instance1", "MindoverMatter", "NA", "50000", "Tumkur", "-");
        backendDB.insertInstanceSpecificData("B-instance4", "Live on", "NA", "50000", "Bangalore", "-");
        backendDB.insertInstanceSpecificData("M-instance1", "Wish foundation", "NA", "50000", "Mysore", "-");
        backendDB.insertInstanceSpecificData("B-instance5", "Karuna", "NA", "50000", "Bangalore", "-");
        backendDB.insertInstanceSpecificData("R-instance1", "Grassroot", "NA", "50000", "Raichur", "-");
        backendDB.insertInstanceSpecificData("B-instance6", "X-force", "NA", "50000", "Bangalore", "-");
        backendDB.insertInstanceSpecificData("M-instance2", "Healthy Life", "NA", "50000", "Mysore", "-");
        backendDB.insertInstanceSpecificData("Z-instance1", "Samruddhi", "NA", "50000", "Hubli", "-");
        backendDB.insertInstanceSpecificData("Z-instance2", "Abhivruddhi", "NA", "50000", "Hubli", "-");
        backendDB.insertInstanceSpecificData("Z-instance3", "Santrupthi", "NA", "50000", "Hubli", "-");
        backendDB.insertInstanceSpecificData("F-instance1", "Wempower", "NA", "50000", "Belgaum", "-");
        backendDB.insertInstanceSpecificData("F-instance2", "Orion", "NA", "50000", "Belgaum", "-");
        backendDB.insertInstanceSpecificData("F-instance3", "Hercules", "NA", "50000", "Belgaum", "-");
        backendDB.insertInstanceSpecificData("G-instance2", "MindoverMatter", "NA", "50000", "Gulbarga", "-");
        backendDB.insertInstanceSpecificData("B-instance8", "Live on", "NA", "50000", "Bangalore", "-");
        backendDB.insertInstanceSpecificData("S-instance1", "Wish foundation", "NA", "50000", "Mangalore", "-");
        backendDB.insertInstanceSpecificData("S-instance2", "Karuna", "NA", "50000", "Mangalore", "-");
        backendDB.insertInstanceSpecificData("B-instance7", "Samruddhi", "NA", "50000", "Bangalore", "-");


        backendDB.insertInventorySpecificData("books", "NA", "B-instance1", "1000");
        backendDB.insertInventorySpecificData("uniform", "NA", "B-instance1", "5000");
        backendDB.insertInventorySpecificData("Medicines", "NA", "B-instance2", "10000");
        backendDB.insertInventorySpecificData("clothes", "NA", "B-instance2", "7000");
        backendDB.insertInventorySpecificData("food", "NA", "B-instance2", "12000");
        backendDB.insertInventorySpecificData("books", "NA", "C-instance1", "1000");
        backendDB.insertInventorySpecificData("Medicines", "NA", "C-instance2", "5000");
        backendDB.insertInventorySpecificData("clothes", "NA", "C-instance2", "10000");
        backendDB.insertInventorySpecificData("food", "NA", "C-instance2", "10000");
        backendDB.insertInventorySpecificData("Medicines", "NA", "G-instance1", "5000");
        backendDB.insertInventorySpecificData("Instuments", "NA", "G-instance1", "20000");
        backendDB.insertInventorySpecificData("clothes", "NA", "T-instance1", "10000");
        backendDB.insertInventorySpecificData("books", "NA", "T-instance1", "1000");
        backendDB.insertInventorySpecificData("food", "NA", "T-instance1", "10000");
        backendDB.insertInventorySpecificData("Medicines", "NA", "T-instance1", "2000");
        backendDB.insertInventorySpecificData("books", "NA", "B-instance8", "1000");
        backendDB.insertInventorySpecificData("Medicines", "NA", "M-instance1", "5000");
        backendDB.insertInventorySpecificData("Toys", "NA", "M-instance1", "1000");
        backendDB.insertInventorySpecificData("clothes", "NA", "M-instance1", "6000");
        backendDB.insertInventorySpecificData("Toys", "NA", "G-instance1", "1000");


        backendDB.insertSuccessStorySpecificData("Gim", "B-instance4", "NA", "B-institution", "Shashi89", "Bangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Jimmy", "B-instance1", "NA", "B-institution", "Abhishek60", "Bangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Sanjay", "B-instance3", "NA", "B-institution", "Shamala", "Bangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Sanjeev", "M-instance2", "NA", "M-institution", "JohnD", "Mysore", "NA");
        backendDB.insertSuccessStorySpecificData("Sanjeevani", "G-instance2", "NA", "G-institution", "Vijay", "Gulburga", "NA");
        backendDB.insertSuccessStorySpecificData("Salman", "F-instance1", "NA", "F-institution", "Siri", "Belgaum", "NA");
        backendDB.insertSuccessStorySpecificData("Sharuk", "B-instance4", "NA", "B-institution", "Shashi89", "Bangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Naveen", "B-instance4", "NA", "B-institution", "Shashi89", "Bangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Nithin", "Z-instance1", "NA", "Z-institution", "Vishwas", "Hubli", "NA");
        backendDB.insertSuccessStorySpecificData("Nilesh", "Z-instance1", "NA", "Z-institution", "Vishwas", "Hubli", "NA");
        backendDB.insertSuccessStorySpecificData("Sandeep", "Z-instance1", "NA", "Z-institution", "Vishwas", "Hubli", "NA");
        backendDB.insertSuccessStorySpecificData("Suresh", "S-instance1", "NA", "S-institution", "Shama", "Mangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Suraj", "S-instance1", "NA", "S-institution", "Shama", "Mangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Ashwin", "S-instance1", "NA", "S-institution", "Shama", "Mangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Mahesh", "S-instance2", "NA", "S-institution", "Fathima", "Mangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Ashwini", "B-instance3", "NA", "B-institution", "Shamala", "Bangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Priya", "B-instance3", "NA", "B-institution", "Shamala", "Bangalore", "NA");
        backendDB.insertSuccessStorySpecificData("Piya", "C-instance1", "NA", "C-institution", "Katha55", "Chennai", "NA");
        backendDB.insertSuccessStorySpecificData("Pinku", "C-instance2", "NA", "C-institution", "Srikantha20", "Chennai", "NA");
        backendDB.insertSuccessStorySpecificData("Kaljal", "C-instance1", "NA", "C-institution", "Katha55", "Chennai", "NA");
        backendDB.insertSuccessStorySpecificData("Priyanka", "C-instance2", "NA", "C-institution", "Srikantha20", "Chennai", "NA");


        backendDB.insertPersonnelSpecificData("Abhishek", "B-instance1", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Male");
        backendDB.insertPersonnelSpecificData("Shikha", "B-instance2", "1234378899", "Bangalore", "10000", "1/1/2013", " ", "Female");
        backendDB.insertPersonnelSpecificData("Shamala", "B-instance3", "1234378899", "Bangalore", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("Katha", "C-instance1", "1234378899", "Chennai", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Srikantha", "C-instance2", "1234378899", "Chennai", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("George", "G-instance1", "1234378899", "Gulburga", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Pari", "T-instance1", "1234378899", "Tumkur", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("Shashi", "B-instance4", "1234378899", "Bangalore", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Sampath", "M-instance1", "1234378899", "Mysore", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Kala", "B-instance5", "1234378899", "Bangalore", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("Kavitha", "R-instance1", "1234378899", "Raichur", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("Lalitha", "B-instance6", "1234378899", "Bangalore", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("JohnD", "M-instance2", "1234378899", "Mysore", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Vishwas", "Z-instance1", "1234378899", "Hubli", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Gauthami", "Z-instance2", "1234378899", "Hubli", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("Mahesh", "Z-instance3", "1234378899", "Hubli", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Siri", "F-instance1", "1234378899", "Belgaum", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Vikas", "F-instance2", "1234378899", "Belgaum", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Vikram", "F-instance3", "1234378899", "Belgaum", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Vijay", "G-instance2", "1234378899", "Gulburga", "10000", "1/1/2013",  " ", "Male");
        backendDB.insertPersonnelSpecificData("Vinaya", "B-instance8", "1234378899", "Bangalore", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("Shama", "S-instance1", "1234378899", "Mangalore", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("Fathima", "S-instance2", "1234378899", "Mangalore", "10000", "1/1/2013",  " ", "Female");
        backendDB.insertPersonnelSpecificData("Faizal",	"B-instance7",	"1234378899",	"Bangalore",	"10000",	"1/1/2013",	 " ",	"Male");


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
