package com.example.android.crudapp;

/**
 * Created by Vipul Kumar Maurya on 23-07-2017.
 */

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    // Instantiating DbHelperClass to use its methods.
    // If not instantiated App Crash**
    DbHelperClass dbHelperClass = new DbHelperClass(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        // String data= dbHelperClass.getData();
        // do what ever you want here
        // Defining Textview on view _acvitity to show our data.
        TextView displayData = (TextView) findViewById(R.id.show_data);
        // storing data in cursor from getData() from DbHelperClass
        Cursor cursor = dbHelperClass.getData();
        // disply text message about no of rows
        displayData.setText("The Employee app have " + cursor.getCount() + " rows");
        // this method will read and set data all the table row on TextView
        while (cursor.moveToNext()) {
            String colID = cursor.getString(cursor.getColumnIndex("EMPLOYEE_ID"));
            String colName = cursor.getString(cursor.getColumnIndex("EMPLOYEE_NAME"));
            String colDpt = cursor.getString(cursor.getColumnIndex("DEPT"));
            String colSal = cursor.getString(cursor.getColumnIndex("SALARY"));
            String colDate = cursor.getString(cursor.getColumnIndex("HIRE_DATE"));

            // to show row of table. If displayData.setText() used only first row will be shown.
            displayData.append("\n" + colID + "-" + colName + "-" + colDpt + "-" + Integer.parseInt(colSal) + "-" + colDate);
        }


    }

    @Override
    protected void onDestroy() {
        dbHelperClass.close();
        super.onDestroy();
    }

}


/*  String data=" ";
        while(cursor.moveToNext()){
            data = cursor.getString(cursor.getColumnIndex("EMPLOYEE_NAME"));
            data=data+cursor.getString(cursor.getColumnIndex("DEPT"));
              cursor.moveToNext();

        }  */