package com.example.android.crudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Vipul Kumar Maurya on 23-07-2017.
 */
/* DbhHelperClass extends SQLteOpenhelper, SQLiteOpenHelper provide several Methods
  but OnCreate and OnUpgrade  which Must be Implemented
  */

public class DbHelperClass extends SQLiteOpenHelper {
    // public Table name because it will used in other several activites,  It will be the name of created table
    public final static String TABLE_NAME = "record";
    // private Database name, It is name of the database which will be created, It will be used within this class only.
    // Final and static because it will be used before the instance of DbHelperClass
    private final static String DATABASE_NAME = "employee.db";
    // Database ver determines database version
    private final static int DATABASE_VER = 1;

    public DbHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    // onCreate method create table of the database
    /* Querry for Creating table , CREATE TABLE <TABLE NAME> (<COLUMN NAME> <TYPE> PRIMARY KEY,
                                    <COLUMN NAME> <TYPE>,<COLUMN NAME> <TYPE>,<COLUMN NAME> <TYPE>,<COLUMN NAME> <TYPE>);

      */

    @Override
    public void onCreate(SQLiteDatabase db) {
        String querry = "CREATE TABLE " + TABLE_NAME + " (EMPLOYEE_ID TEXT PRIMARY KEY,EMPLOYEE_NAME TEXT,DEPT TEXT,SALARY INTEGER, HIRE_DATE TEXT);";
        db.execSQL(querry);
    }

    // onUpgrade method drop table if exist and create new database through onCreate method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }


    /* Method to insert values into Table
    Querry for Inserting values, INSERT INTO <TABLE NAME> VALUES (<VALUE>,<VALUE>,<VALUE>,<VALUE>,<VALUE>,<VALUE>);
    @ContentValues hold data in the Key, Value pair, where key is Column Name and values is user input type of column.
     */
    // this Method is called in EditEmployee Activity

    public boolean insert(String id, String name, String dept, int sal, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        // creating Object of ContentValues values
        ContentValues values = new ContentValues();

        values.put("EMPLOYEE_ID", id);
        values.put("EMPLOYEE_NAME", name);
        values.put("DEPT", dept);
        values.put("SALARY", sal);
        values.put("HIRE_DATE", date);
        // int insert(...) method return -1 if data is not inserted into table
        long newRow = db.insert(TABLE_NAME, null, values);
        if (newRow == -1) return false;
        else return true;
    }


    // Method to fetch or get data from database table.
    /* Cursor store all the data of the querry
      */
    // this method is called in ViewActivity
    public Cursor getData() {
        // String Selection[]={"EMPLOYEE_ID","EMPLOYEE_NAME","DEPT","SALARY","HIRE_DATE"};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        //cursor= db.query(TABLE_NAME,Selection,null,null,null ,null,null);
        // Querry for getting all the data, SELECT * FROM <TABLE NAME>;
        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }
// Method to update the data
    // this method is similar to insert Method and called in EditEmployee Activity and return no of rows updated
    // Querry for Updating table row, UPDATE <TABLE NAME> SET <COLUMN NAME> = VALUE,.. WHERE [CALUES];

    public int update(String id, String name, String dpt, int sal, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put("EMPLOYEE_NAME", name);
            values.put("DEPT", dpt);
            values.put("SALARY", sal);
            values.put("HIRE_DATE", date);
            int u = db.update(TABLE_NAME, values, "EMPLOYEE_ID= '" + id + "'", null);
            return u;
        }
        // Close Database to prevent from Memory Leakes
        finally {
            db.close();

        }
    }

    // Method to delete Table row
// Querry, DELETE FROM <TABLE NAME> WHERE <COLUMN NAME>= <VALUE>...;
    public int delete(String id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            // ContentValues values = new ContentValues();
            int d = db.delete(TABLE_NAME, "EMPLOYEE_ID= '" + id + "'", null);
            return d;
        }

        // Close Database to prevent from Memory Leakes
        finally {
            db.close();

        }
    }

}