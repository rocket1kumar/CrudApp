package com.example.android.crudapp;

/**
 * Created by Vipul Kumar Maurya on 23-07-2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditEmployee extends AppCompatActivity {
    // Declaring Buttons and EditText of the Edit activity
    EditText Ename, Eid, Edept, Esalary, Hdate;
    Button Btnsave, Btnupdate;
    // Instantiating DbHelperClass
    DbHelperClass Dbhelper = new DbHelperClass(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);
        // Binding EditText with views
        Eid = (EditText) findViewById(R.id.eid);

        Ename = (EditText) findViewById(R.id.ename);

        Edept = (EditText) findViewById(R.id.edept);

        Esalary = (EditText) findViewById(R.id.esalary);

        Hdate = (EditText) findViewById(R.id.hdate);
// Binding Button  with views
        Btnsave = (Button) findViewById(R.id.btnsave);
        Btnupdate = (Button) findViewById(R.id.btnupdate);

        // OnClick Listener for Add new record
        Btnsave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    String d = Eid.getText().toString();
                    String n = Ename.getText().toString();
                    String dt = Edept.getText().toString();
                    int s = Integer.parseInt(Esalary.getText().toString());
                    String h = Hdate.getText().toString();
                    // Calling int insert(...) from DbhelperClass
                    boolean result = Dbhelper.insert(d, n, dt, s, h);
                    if (result)
                        Toast.makeText(EditEmployee.this, "Record Saved Successful", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(EditEmployee.this, "error:can not save record", Toast.LENGTH_SHORT).show();
                } finally {
                    // Whether record added or not this will close the edit activity
                    finish();
                }
            }

        });

        // OnClick Listener for Update
        Btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String id = Eid.getText().toString();
                    // Calling void update(...) from DbHelperClass
                    int u = Dbhelper.update(id, Ename.getText().toString(), Edept.getText().toString(),
                            Integer.parseInt(Esalary.getText().toString()), Hdate.getText().toString());
                    if (u > 0)
                        Toast.makeText(EditEmployee.this, "ID " + id + " is updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(EditEmployee.this, "ID " + id + " can not be updated or does not exist ", Toast.LENGTH_SHORT).show();
                } finally {
                    // this will close edit activity
                    finish();
                    ;
                }

            }
        });

    }


}
