package com.example.android.crudapp;
/*
This Is a basic Tutorial CRUD APP created by Vipul Kumar Maurya.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /* Here Is The Declarations for Buttons on The Main Activity */
    Button AddEmp, ViewEmp, DeleteEmp, UpdateEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The Attatching Buttons with Views on MainActivity.
        AddEmp = (Button) findViewById(R.id.addemp);
        ViewEmp = (Button) findViewById(R.id.viewemp);
        UpdateEmp = (Button) findViewById(R.id.updemp);
        DeleteEmp = (Button) findViewById(R.id.delemp);

        // Adding click Listener for Add Employee button
        // On touch of the Button Add Employee setOnClickListener will invoke EditActivity Activity
        AddEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to Start EditActivity
                Intent intent = new Intent(MainActivity.this, EditEmployee.class);
                startActivity(intent);

            }
        });

        // Adding click Listener for View Employee button
        // On touch of the Button View Employee setOnClickListener will invoke ViewActivity Activity
        ViewEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);

            }
        });

        // Adding click Listener for Delete Employee button
        // On touch of the Button Delete Button setOnClickListener will invoke DeleteEmployee Activity
        DeleteEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DeleteEmployee.class);
                startActivity(intent);
            }
        });

        // Adding click Listener for Update Employee button
        // On touch of the Button Update Button setOnClickListener will invoke EditEmployee Activity
        UpdateEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditEmployee.class);
                startActivity(intent);

            }
        });
    }

}
